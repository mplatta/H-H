package pl.com.harehounds.harehounds.GameActivitis.RunnerActivities;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 13.12.17.
 */

class PutRiddleRequest extends StringRequest {
	private Map<String, String> params;

	PutRiddleRequest(Integer gameId, String latitude, String longitude, Response.Listener<String> listener) {
		super(Method.POST, ServerLinks.SET_WAY_POINT_POSITION, listener, null);

		params = new HashMap<>();
		params.put("pos_y", latitude);
		params.put("pos_x", longitude);
		params.put("riddle", "true");
		params.put("gameId", gameId.toString());

		Log.d("loctest_riddle", latitude);
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}