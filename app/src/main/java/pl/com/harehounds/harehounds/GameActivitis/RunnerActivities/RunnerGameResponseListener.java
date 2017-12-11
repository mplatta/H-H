package pl.com.harehounds.harehounds.GameActivitis.RunnerActivities;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * created by klata on 11.12.2017.
 */

public class RunnerGameResponseListener implements Response.Listener<String> {
	private AppCompatActivity activity;

	@Override
	public void onResponse(String response) {
		try {
			JSONObject jsonObject = new JSONObject(response);
			Boolean success = jsonObject.getBoolean("success");

			if (success) {
				Toast.makeText(activity, "Success!", Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText(activity, "Fail!", Toast.LENGTH_LONG).show();
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	RunnerGameResponseListener(AppCompatActivity activity) {
		this.activity = activity;
	}
}
