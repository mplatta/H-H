package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * created by klata on 06.12.2017.
 */

class SeekerGameResponseListener implements Response.Listener<String> {
	private Checkpoint checkpoint;

	@Override
	public void onResponse(String response) {
		try {
			JSONObject jsonResponse = new JSONObject(response);
			checkpoint.setLatitude(jsonResponse.getDouble("latitude"));
			checkpoint.setLongitude(jsonResponse.getDouble("longitude"));
			checkpoint.setStatus(false);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	SeekerGameResponseListener(Checkpoint _checkpoint) {
		this.checkpoint = _checkpoint;
	}
}