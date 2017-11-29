package pl.com.harehounds.harehounds;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import pl.com.harehounds.harehounds.LoginActivitis.LoginActivity;

/**
 * Created by Adam on 23.10.2017.
 * edit by Klata on 31.10.2017
 */
public class RegisterActivity extends Activity {

	private AutoCompleteTextView mEmailView;
	private EditText mPasswordView, mConfirmPasswordView, mNickNameView;
	private View mProgressView;
	private View mRegisterFormView;
	private String email, password, confirm_password, nickName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		mEmailView = findViewById(R.id.email);
		mPasswordView = findViewById(R.id.password);
		mConfirmPasswordView = findViewById(R.id.confirm_password);
		mNickNameView = findViewById(R.id.nickName);
		mProgressView = findViewById(R.id.register_progress);
		mRegisterFormView = findViewById(R.id.register_form);

		Button registerButton = findViewById(R.id.email_register_button);
		registerButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				register();
			}
		});
	}

	/**
	 * Shows the progress UI and hides the register form.
	 */
	// TODO: 01.11.2017 trzeba sprawdzic czy da sie to do jakiejs klasy statycznej czy dac
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	private void showProgress(final boolean show) {
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
			int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

			mRegisterFormView.setVisibility(show ? View.GONE : View.VISIBLE);
			mRegisterFormView.animate().setDuration(shortAnimTime).alpha(
					show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
				@Override
				public void onAnimationEnd(Animator animation) {
					mRegisterFormView.setVisibility(show ? View.GONE : View.VISIBLE);
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
			mRegisterFormView.setVisibility(show ? View.GONE : View.VISIBLE);
		}
	}

	private void onSignUpSuccess() {
		Response.Listener<String> responseListener = new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
			try {
				JSONObject jsonResponse = new JSONObject(response);
				boolean loginSuccess = jsonResponse.getBoolean("loginSuccess");
				boolean mailSuccess = jsonResponse.getBoolean("mailSuccess");

				showProgress(false);

				if (loginSuccess) {
					if (mailSuccess) {
						successSignUp();
					} else {
						mEmailView.requestFocus();
						mEmailView.setError("E-mail already in use");
					}
				} else {
					mNickNameView.requestFocus();
					mNickNameView.setError("Login already in use");
				}
			} catch (JSONException e) {
				// TODO: 31.10.2017 change error message
				showProgress(false);

				AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
				builder.setMessage(e.getMessage())
					.setNegativeButton("Retry", null)
					.create()
					.show();
			}
			}
		};

		RegisterRequest registerRequest = new RegisterRequest(email, nickName, password, responseListener);
		RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
		queue.add(registerRequest);
	}

	private boolean validate() {
		boolean valid = true;

		if (!LoginActivity.isEmailValid(email) || email.length() > 32 || email.isEmpty()) {
			mEmailView.setError("Invalid e-mail!");
			valid = false;
		}
		if (nickName.isEmpty()) {
			mNickNameView.setError(getString(R.string.error_field_required));
		}
		if (!(password.equals(confirm_password))) {
			mConfirmPasswordView.setError(getString(R.string.prompt_password_confirm));
			valid = false;
		}
		if (password.isEmpty()) {
			mPasswordView.setError(getString(R.string.error_field_required));
			valid = false;
		}
		if (confirm_password.isEmpty()) {
			mConfirmPasswordView.setError(getString(R.string.error_field_required));
			valid = false;
		}

		return valid;
	}

	private void register() {
		initialize();   // Initialize inputs to Strings;
		if (!validate()) {
			Toast.makeText(this, "Signup has failed :(", Toast.LENGTH_SHORT).show();
			mEmailView.setText(email);
			mNickNameView.setText(nickName);
		} else {
			showProgress(true);
			onSignUpSuccess();
		}
	}

	// TODO: 01.11.2017 polecam zmienic nazwe tej funkcji na cos bardziej precyzyjnego
	private void initialize() {
		email = mEmailView.getText().toString().trim();
		password = mPasswordView.getText().toString().trim();
		confirm_password = mConfirmPasswordView.getText().toString().trim();
		nickName = mNickNameView.getText().toString().trim();
	}

	private void successSignUp() {
		Toast.makeText(this, "Signup success!", Toast.LENGTH_LONG).show();
		this.finish();
	}
}
