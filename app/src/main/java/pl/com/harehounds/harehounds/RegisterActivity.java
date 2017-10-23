package pl.com.harehounds.harehounds;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Adam on 23.10.2017.
 */

public class RegisterActivity extends Activity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView, mConfirmPasswordView;
    private View mProgressView;
    private View mRegisterFormView;
    private String email, password, confirm_password;
    Button regbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmailView           = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView        = (EditText) findViewById(R.id.password);
        mConfirmPasswordView = (EditText) findViewById(R.id.confirm_password);
        mProgressView        = (View) findViewById(R.id.register_progress);
        mRegisterFormView    = (View) findViewById(R.id.register_form);
        regbtn               = (Button) findViewById(R.id.email_register_button);

        regbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                register();
            }
        });
    }

    public void register(){
        initialize();   // Initialize inputs to Strings;
        if(!validate()){
            Toast.makeText(this, "Signup has failed :(", Toast.LENGTH_SHORT).show();
        }
        else{
            onSignupSuccess();
        }
    };

    public void onSignupSuccess(){
        //TODO actions after input validation;
    };

    public boolean validate(){
        boolean valid = true;

        if(!isEmailValid(email) || email.length()>32 || email.isEmpty()){
            mEmailView.setError("Please enter valid e-mail");
            valid = false;
        }
        if(!(password.equals(confirm_password))){
            mConfirmPasswordView.setError("Different passwords, try again");
            valid = false;
        }
        if(password.isEmpty()){
            mPasswordView.setError("This field can not be empty!");
            valid = false;
        }

        if(confirm_password.isEmpty()){
            mConfirmPasswordView.setError("This field can not be empty!");
            valid = false;
        }

        return valid;
    };

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public void initialize(){
        email               =   mEmailView.getText().toString().trim();
        password            =   mPasswordView.getText().toString().trim();
        confirm_password    =   mConfirmPasswordView.getText().toString().trim();
    };

}
