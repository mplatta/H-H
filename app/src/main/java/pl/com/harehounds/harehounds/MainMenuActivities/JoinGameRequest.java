package pl.com.harehounds.harehounds.MainMenuActivities;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 13.12.17.
 */

public class JoinGameRequest extends StringRequest {
	private Map<String, String> params;

	JoinGameRequest(Integer gameId, Integer userId, Response.Listener<String> listener) {
		super(Request.Method.POST, ServerLinks.GAMES_JOIN, listener, null);
		params = new HashMap<>();
		params.put("gameId", gameId.toString());
		params.put("userId", userId.toString());
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}
