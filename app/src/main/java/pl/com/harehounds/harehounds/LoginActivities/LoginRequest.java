package pl.com.harehounds.harehounds.LoginActivities;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;

/**
 * created by klata on 25.10.17.
 */
class LoginRequest extends StringRequest {
    // TODO: 31.10.2017 change server address
    private Map<String, String> params;

    LoginRequest(String email, String password, Response.Listener<String> listener) {
        super(Request.Method.POST, ServerLinks.LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}