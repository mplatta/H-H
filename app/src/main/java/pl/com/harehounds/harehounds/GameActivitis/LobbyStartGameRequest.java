package pl.com.harehounds.harehounds.GameActivitis;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 11.12.2017.
 */

public class LobbyStartGameRequest extends StringRequest {

	private Map<String, String> params;

	LobbyStartGameRequest(Integer gameId, Integer player, Response.Listener<String> listener) {
		super(Method.POST, ServerLinks.GET_GAME, listener, null);

		params = new HashMap<>();
		params.put("gameId", gameId.toString());
		params.put("player", player.toString());
	}

	@Override
	public Map<String, String> getParams() {
		return params;
	}
}
