package pl.com.harehounds.harehounds.MainMenuActivities;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 13.12.17.
 */

public class CreateGameRequest extends StringRequest {
	private Map<String, String> params;

	CreateGameRequest(Integer userId, Integer startDelay, Integer privacy, Response.Listener<String> listener) {
		super(Method.POST, ServerLinks.CREATE_GAME_URL, listener, null);

		params = new HashMap<>();
		params.put("userId", userId.toString());
		params.put("start_delay", startDelay.toString());
		params.put("privacy", privacy.toString());
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}
