package pl.com.harehounds.harehounds.MainMenuActivities;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * created by klata on 29.11.17.
 */

class AddFriendResponseListener implements Response.Listener<String> {
	private FragmentActivity activityToShow = null;

	@Override
	public void onResponse(String response) {
		try {
			JSONObject jsonResponse = new JSONObject(response);
			boolean success = jsonResponse.getBoolean("success");

			if (success) {
				Toast.makeText(activityToShow, "Success!", Toast.LENGTH_LONG).show();
				// TODO: 15.11.17 add refreash list
			} else {
				Toast.makeText(activityToShow, "Failed! This user doesn't exist!", Toast.LENGTH_LONG).show();
			}
		} catch (JSONException e) {
			// TODO: 31.10.2017 change error message
			AlertDialog.Builder builder = new AlertDialog.Builder(activityToShow);
			builder.setMessage(e.getMessage())
					.setNegativeButton("Retry", null)
					.create()
					.show();
		}
	}

	AddFriendResponseListener(FragmentActivity activity) {
		this.activityToShow = activity;
	}
}
