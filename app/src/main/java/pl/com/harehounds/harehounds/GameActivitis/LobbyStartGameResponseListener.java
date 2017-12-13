package pl.com.harehounds.harehounds.GameActivitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import pl.com.harehounds.harehounds.GameActivitis.RunnerActivities.RunnerActivity;
import pl.com.harehounds.harehounds.GameActivitis.SeekerActivities.SeekerActivity;

/**
 * created by klata on 11.12.2017.
 */

class LobbyStartGameResponseListener implements Response.Listener<String> {

	private AppCompatActivity activity;
	private Boolean host;
	private Integer gameId;

	@Override
	public void onResponse(String response) {
		try {
			JSONObject jsonResponse = new JSONObject(response);

			if (jsonResponse.getBoolean("ready")) {
				if (host) {
					Intent intent = new Intent(activity, RunnerActivity.class);
					intent.putExtra("gameId", gameId.toString());
					activity.startActivity(intent);
				} else {
					Intent intent = new Intent(activity, SeekerActivity.class);
					intent.putExtra("gameId", gameId.toString());
					activity.startActivity(intent);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	LobbyStartGameResponseListener(AppCompatActivity activity, Boolean host, Integer gameId) {
		this.activity = activity;
		this.host = host;
		this.gameId = gameId;
	}
}
