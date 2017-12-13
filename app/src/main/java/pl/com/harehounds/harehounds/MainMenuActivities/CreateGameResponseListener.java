package pl.com.harehounds.harehounds.MainMenuActivities;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import pl.com.harehounds.harehounds.GameActivitis.Lobby;

/**
 * created by klata on 13.12.17.
 */

public class CreateGameResponseListener implements Response.Listener<String> {
	private Integer gameId;
	private FragmentActivity activity;

	@Override
	public void onResponse(String response) {
		try {
			JSONObject jsonObject = new JSONObject(response);
			this.gameId = jsonObject.getInt("gameId");
			Intent intent = new Intent(activity, Lobby.class);
			intent.putExtra("gameId", gameId.toString());
			intent.putExtra("host", "true");
			activity.startActivity(intent);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	CreateGameResponseListener(FragmentActivity activity, Integer gameId) {
		this.gameId = gameId;
		this.activity = activity;
	}
}
