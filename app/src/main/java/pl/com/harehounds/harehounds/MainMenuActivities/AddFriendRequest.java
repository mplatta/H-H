package pl.com.harehounds.harehounds.MainMenuActivities;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 15.11.17.
 */

class AddFriendRequest extends StringRequest {
    private Map<String, String> params;

    AddFriendRequest(Integer userId, String nickName, Response.Listener<String> listener) {
        super(Method.POST, ServerLinks.ADD_FRIEND_REQUEST_URL, listener, null);

        params = new HashMap<>();
        params.put("userId", userId.toString());
        params.put("nickName", nickName);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}