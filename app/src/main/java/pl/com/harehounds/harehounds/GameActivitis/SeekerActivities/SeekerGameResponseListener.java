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
			checkpoint.setLatitude(jsonResponse.getDouble("pos_y"));
			checkpoint.setLongitude(jsonResponse.getDouble("pos_x"));

			if (jsonResponse.getBoolean("flag")) {
				JSONObject riddle = jsonResponse.getJSONObject("riddle");

				checkpoint.setText(riddle.getString("text"));
				checkpoint.setAnswer(riddle.getString("answer"));
				checkpoint.setOptionA(riddle.getString("optionA"));
				checkpoint.setOptionB(riddle.getString("optionB"));
				checkpoint.setOptionC(riddle.getString("optionC"));
				checkpoint.setOptionD(riddle.getString("optionD"));
				checkpoint.setWayPoint(false);
			} else checkpoint.setWayPoint(true);

			checkpoint.setStatus(false);

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	SeekerGameResponseListener(Checkpoint _checkpoint) {
		this.checkpoint = _checkpoint;
	}
}