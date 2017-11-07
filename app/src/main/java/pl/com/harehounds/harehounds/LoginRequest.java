package pl.com.harehounds.harehounds;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by klata on 25.10.17.
 */

public class LoginRequest extends StringRequest {
    // TODO: 31.10.2017 change server address
    private static final String LOGIN_REQUEST_URL = "http://42.0.139.255:5000/api/login";
    private Map<String, String> params;

    public LoginRequest(String email, String password, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}