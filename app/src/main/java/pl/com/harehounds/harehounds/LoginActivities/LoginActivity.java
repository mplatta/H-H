package pl.com.harehounds.harehounds.LoginActivities;

import android.Manifest;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import pl.com.harehounds.harehounds.GameActivitis.SeekerActivities.SeekerActivity;
import pl.com.harehounds.harehounds.MainMenuActivities.MainMenuActivity;
import pl.com.harehounds.harehounds.R;
import pl.com.harehounds.harehounds.RegisterActivity;
import pl.com.harehounds.harehounds.User.UserSingleton;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
	// UI references.
	private AutoCompleteTextView mEmailView;
	private EditText mPasswordView;
	private View mProgressView;
	private View mLoginFormView;

	private static final int REQUEST_FINE_LOCATION = 0;
	// TODO: 15.11.2017 change pattern to standard regex
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
		Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		// Set up the login form.
		mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
		mPasswordView = (EditText) findViewById(R.id.password);

		checkPermission();

		Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
		mEmailSignInButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				attemptLogin();
			}
		});

		mLoginFormView = findViewById(R.id.login_form);
		mProgressView = findViewById(R.id.login_progress);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
	                                       @NonNull String permissions[], @NonNull int[] grantResults) {
		switch (requestCode) {
			case REQUEST_FINE_LOCATION: {
				// If request is cancelled, the result arrays are empty.
				if (grantResults.length > 0
						&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					// TODO: 09.11.2017 do smth :)
				}
				else {
					// TODO: 09.11.2017 do smth :)
				}
			}
		}
	}

	private void attemptLogin() {
		// Reset errors.
		mEmailView.setError(null);
		mPasswordView.setError(null);

		// Store values at the time of the login attempt.
		String email = mEmailView.getText().toString();
		String password = mPasswordView.getText().toString();

		boolean cancel = false;
		View focusView = null;

		// Check for a valid password, if the user entered one.
		if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
			mPasswordView.setError(getString(R.string.error_invalid_password));
			focusView = mPasswordView;
			cancel = true;
		}

		// Check for a valid email address.
		if (TextUtils.isEmpty(email)) {
			mEmailView.setError(getString(R.string.error_field_required));
			focusView = mEmailView;
			cancel = true;
		} else if (!isEmailValid(email)) {
			mEmailView.setError(getString(R.string.error_invalid_email));
			focusView = mEmailView;
			cancel = true;
		}

		if (cancel) {
			focusView.requestFocus();
		} else {
			showProgress(true);
			connectServer();
		}
	}

	private void connectServer() {
		final String email = mEmailView.getText().toString();
		final String password = mPasswordView.getText().toString();

		Response.Listener<String> responseListener = new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					JSONObject jsonResponse = new JSONObject(response);
					boolean success = jsonResponse.getBoolean("success");
					showProgress(false);

					if (success) {
						int userId = jsonResponse.getInt("userId");
						goToMainMenu(userId, jsonResponse.getString("nickName"), email);
					} else {
						signInFailed();
						showProgress(false);
					}
				} catch (JSONException e) {
					showProgress(false);
					// TODO: 31.10.2017 change error message
					AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
					builder.setMessage(e.getMessage())
						.setNegativeButton("Retry", null)
						.create()
						.show();
				}
//				showProgress(false);
			}
		};

		LoginRequest loginRequest = new LoginRequest(email, password, responseListener);
		RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
		queue.add(loginRequest);
//		showProgress(false);
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
			mLoginFormView.animate().setDuration(shortAnimTime).alpha(
				show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
				mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
				}
			});

			mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
			mProgressView.animate().setDuration(shortAnimTime).alpha(
				show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
				mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
				}
			});
		} else {
			// The ViewPropertyAnimator APIs are not available, so simply show
			// and hide the relevant UI components.
			mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
			mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	private void checkPermission() {
		int permissionCheck = ContextCompat.checkSelfPermission(LoginActivity.this,
				Manifest.permission.ACCESS_FINE_LOCATION);

		if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(LoginActivity.this,
				new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
				REQUEST_FINE_LOCATION);
		}
	}

	private void signInFailed() {
		mEmailView.requestFocus();
		mEmailView.setError("This e-mail is incorrect");
		mPasswordView.setError(getString(R.string.error_incorrect_password));
		Toast.makeText(this, "E-mail or password is incorrect", Toast.LENGTH_SHORT).show();
	}

	public void goToMainMenu(Integer userId, String nickName, String email) {
//		showProgress(false);
		UserSingleton.getInstance(userId, nickName, email);
		Intent intent = new Intent(LoginActivity.this, MainMenuActivity.class);
		LoginActivity.this.startActivity(intent);
		this.finish();
	}

	public void goToRegistration(View view) {
		mEmailView.setError(null);
		mPasswordView.setError(null);
		mEmailView.setText(null);
		mPasswordView.setText(null);

		startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
	}

	// only for GPS test
	public void goTestLocation(View view) {
		startActivity(new Intent(LoginActivity.this, SeekerActivity.class));
	}

	public static boolean isEmailValid(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
		return matcher.find();
	}

	private boolean isPasswordValid(String password) {
		//TODO: Replace this with your own logic
		return password.length() > 4;
	}
}