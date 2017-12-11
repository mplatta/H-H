package pl.com.harehounds.harehounds.GameActivitis;

import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * created by klata on 11.12.2017.
 */

class LobbyResponseListener implements Response.Listener<String> {

	private TextView mRunnerTextView;
	private TextView mSeekerTextView;
	
	@Override
	public void onResponse(String response) {
		try {
			JSONObject jsonResponse = new JSONObject(response);
			mRunnerTextView.setText(jsonResponse.getString("runnerLogin"));
			mSeekerTextView.setText(jsonResponse.getString("seekerLogin"));
			
			Boolean startGame = jsonResponse.getBoolean("gameStatus");
			
			if(startGame) {
				// TODO: 11.12.2017 przejscie do gry
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	LobbyResponseListener(TextView mRunnerTextView, TextView mSeekerTextView) {
		this.mRunnerTextView = mRunnerTextView;
		this.mSeekerTextView = mSeekerTextView;
	}
}
