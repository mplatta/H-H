package pl.com.harehounds.harehounds.MainMenuActivities;

import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * created by klata on 06.12.2017.
 */

public class LoadFriendsResponseListener implements Response.Listener<String>, Response.ErrorListener {
	private LinearLayout linearLayout = null;
	private FragmentActivity activity = null;

	@Override
	public void onResponse(String response) {
		try {
			JSONArray jsonArray = new JSONArray(response);

			for (int i = 0; i < jsonArray.length(); i++) {
				FriendComponent friend = new FriendComponent(activity);
//				friend.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
				JSONObject jsonFriend = jsonArray.getJSONObject(i);

				friend.setNickText(jsonFriend.getString("login"));
				linearLayout.addView(friend);
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
		this.linearLayout = linearLayout;
	}
}
