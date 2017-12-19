package pl.com.harehounds.harehounds.GameActivitis.RunnerActivities;

import android.support.v7.app.AppCompatActivity;

import com.android.volley.Response;

/**
 * created by klata on 11.12.2017.
 */

class RunnerGameResponseListener implements Response.Listener<String> {
	private AppCompatActivity activity;

	@Override
	public void onResponse(String response) {

	}

	RunnerGameResponseListener(AppCompatActivity activity) {
		this.activity = activity;
	}
}
