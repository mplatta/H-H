package pl.com.harehounds.harehounds.GameActivitis;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 11.12.2017.
 */

class LobbyRequest extends StringRequest {
	private Map<String, String> params;

	LobbyRequest(Integer gameId, Response.Listener<String> listener) {
		super(Method.POST, ServerLinks.GET_GAME, listener, null);

		params = new HashMap<>();
		params.put("lobbyId", gameId.toString());
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}
