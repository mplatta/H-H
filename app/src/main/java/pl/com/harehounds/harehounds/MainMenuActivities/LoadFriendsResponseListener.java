package pl.com.harehounds.harehounds.MainMenuActivities;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * created by klata on 06.12.2017.
 */

class LoadFriendsResponseListener implements Response.Listener<String>, Response.ErrorListener {
	private LinearLayout linearLayoutFriends = null;
	private FragmentActivity activity = null;

	@Override
	public void onResponse(String response) {
		try {
			JSONArray jsonArray = new JSONArray(response);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonFriend = jsonArray.getJSONObject(i);
				Log.d("friend", jsonFriend.toString());

				LinearLayout linearLayout = new LinearLayout(activity);
				TextView friend = new TextView(activity);
				friend.setTextSize(24);
				friend.setText(jsonFriend.getString("login"));
				Button button = new Button(activity);

				linearLayout.addView(friend);
				linearLayout.addView(button);
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
