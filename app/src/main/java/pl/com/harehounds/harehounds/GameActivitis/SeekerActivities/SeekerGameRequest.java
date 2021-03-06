package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 06.12.2017.
 */

class SeekerGameRequest extends StringRequest{

	private Map<String, String> params;

	SeekerGameRequest(Integer gameId, Integer checkPointId, Response.Listener<String> listener) {
		super(Method.POST, ServerLinks.GET_CHECKPOINT_POSITION, listener, null);

		params = new HashMap<>();
		params.put("gameId", gameId.toString());
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}
