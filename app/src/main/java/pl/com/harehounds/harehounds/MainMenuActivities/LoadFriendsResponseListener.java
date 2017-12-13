package pl.com.harehounds.harehounds.MainMenuActivities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pl.com.harehounds.harehounds.GameActivitis.Lobby;

/**
 * created by klata on 06.12.2017.
 */

class LoadFriendsResponseListener implements Response.Listener<String>, Response.ErrorListener {
	private LinearLayout linearLayoutFriends = null;
	private FragmentActivity activity = null;
	private Integer gameId = 0;

	@Override
	public void onResponse(String response) {
		try {
			JSONArray jsonArray = new JSONArray(response);

			for (int i = 0; i < jsonArray.length(); i++) {
//				Integer gameId = 0;
				JSONObject jsonFriend = jsonArray.getJSONObject(i);
				Log.d("friend", jsonFriend.toString());

				LinearLayout linearLayout = new LinearLayout(activity);
				TextView friend = new TextView(activity);
				friend.setTextSize(24);
				friend.setText(jsonFriend.getString("login"));
				gameId = jsonFriend.getInt("gameId");

				if (gameId != 0) {
					Button button = new Button(activity);
					button.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							Intent intent = new Intent(activity, Lobby.class);
							intent.putExtra("gameId", gameId.toString());
							intent.putExtra("host", "false");
							activity.startActivity(intent);
						}
					});
					linearLayout.addView(button);
				}

				linearLayout.addView(friend);

//				friend.setNickText(jsonFriend.getString("login"));
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
