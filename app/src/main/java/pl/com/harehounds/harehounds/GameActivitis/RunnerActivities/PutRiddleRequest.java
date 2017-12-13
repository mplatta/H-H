package pl.com.harehounds.harehounds.GameActivitis.RunnerActivities;

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

	PutRiddleRequest(Integer gameId, Double latitiude, Double longitiude, Response.Listener<String> listener) {
		super(Method.POST, ServerLinks.GET_GAME, listener, null);

		params = new HashMap<>();
		params.put("gameId", gameId.toString());
		params.put("pos_y", latitiude.toString());
		params.put("pos_x", longitiude.toString());
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}
