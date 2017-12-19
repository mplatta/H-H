package pl.com.harehounds.harehounds.MainMenuActivities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pl.com.harehounds.harehounds.GameActivitis.Lobby;
import pl.com.harehounds.harehounds.User.UserSingleton;

/**
 * created by klata on 06.12.2017.
 */

class LoadFriendsResponseListener implements Response.Listener<String>, Response.ErrorListener {
	private LinearLayout linearLayoutFriends = null;
	private FragmentActivity activity = null;
	private Integer gameId = 0;
	private UserSingleton user = UserSingleton.getInstance();

	@Override
	public void onResponse(String response) {
		Log.d("resp", response);
		try {
			JSONArray jsonArray = new JSONArray(response);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonFriend = jsonArray.getJSONObject(i);
				Log.d("friend", jsonFriend.toString());

				//Horizontal layout containing nickname and button
				//That will be placed in vertical layout: 'linearLayoutFriends'
				LinearLayout linearLayout = new LinearLayout(activity);


				TextView friend = new TextView(activity);
				friend.setTextSize(24);
				friend.setText(jsonFriend.getString("login"));
				gameId = jsonFriend.getInt("gameId");

				friend.setPadding(5,2,0,2);
				linearLayout.addView(friend);

				if (gameId != 0) {
					Button button = new Button(activity);
					button.setText("Dołącz");
					button.setOnClickListener(new View.OnClickListener() {
						private Integer sGameId = gameId;
						@Override
						public void onClick(View v) {

							JoinGameResponseListener responeListener = new JoinGameResponseListener();
							JoinGameRequest joinGameRequest = new JoinGameRequest(sGameId, user.getIdUser(), responeListener);
							RequestQueue queue = Volley.newRequestQueue(activity);
							queue.add(joinGameRequest);

							Intent intent = new Intent(activity, Lobby.class);
							intent.putExtra("gameId", sGameId.toString());
							Log.d("jsogameidfriend", sGameId.toString());
							intent.putExtra("host", "false");

							activity.startActivity(intent);
						}
					});

					// Name text and button 'Dołącz' next to it
					button.setPadding(10,2,0,2);
					linearLayout.addView(button);
				}
				linearLayoutFriends.addView(linearLayout);
			}

		} catch (JSONException e) {
			e.printStackTrace();
			Log.d("e:", e.toString());
		}
	}

	@Override
	public void onErrorResponse(VolleyError error) {

	}

	LoadFriendsResponseListener(FragmentActivity activity, LinearLayout linearLayout) {
		this.activity = activity;
		this.linearLayoutFriends = linearLayout;
	}
}
