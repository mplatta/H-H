package pl.com.harehounds.harehounds;

import android.app.AlertDialog;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by klata on 25.10.17.
 */

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://klata.cba.pl/testapp2.php";
    private Map<String, String> params;

    public LoginRequest(String email, String password, Response.Listener<String> listener, LoginActivity test) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);

//        AlertDialog.Builder builder = new AlertDialog.Builder(test);
//        builder.setMessage(params.toString())
//                .setNegativeButton("Retry", null)
//                .create()
//                .show();
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}