package pl.com.harehounds.harehounds.GameActivitis.RunnerActivities;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 11.12.2017.
 */

class RunnerGameRequest extends StringRequest {
	private Map<String, String> params;

	RunnerGameRequest(Integer gameId, Double latitude, Double longitude, Response.Listener<String> listener) {
		super(Method.POST, ServerLinks.SET_WAY_POINT_POSITION, listener, null);

		params = new HashMap<>();
		params.put("pos_y", latitude.toString());
		params.put("pos_x", longitude.toString());
		params.put("gameId", gameId.toString());
		params.put("riddle", "False");
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}
