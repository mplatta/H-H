package pl.com.harehounds.harehounds.MainMenuActivities;

import android.support.v4.app.FragmentActivity;
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
			JSONArray jsonResponse = new JSONArray(response);

			for (int i = 0; i < jsonResponse.length(); i++) {
				FriendComponent friend = new FriendComponent(activity);
				friend.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
				JSONObject jsonObject = jsonResponse.getJSONObject(i);

				friend.setNickText(jsonObject.getString("nickName"));

				linearLayout.addView(friend);
			}

		} catch (JSONException e) {
			e.printStackTrace();
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
