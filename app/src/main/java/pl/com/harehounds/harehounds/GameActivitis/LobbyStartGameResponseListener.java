package pl.com.harehounds.harehounds.GameActivitis;

import android.support.v7.app.AppCompatActivity;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * created by klata on 11.12.2017.
 */

class LobbyStartGameResponseListener implements Response.Listener<String> {

	private AppCompatActivity activity;

	@Override
	public void onResponse(String response) {
		try {
			JSONObject jsonResponse = new JSONObject(response);

			Boolean startGame = jsonResponse.getBoolean("gameStatus");

			if(startGame) {
				// TODO: 11.12.2017 przejscie do gry
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	LobbyStartGameResponseListener(AppCompatActivity activity) {
		this.activity = activity;
	}
}
