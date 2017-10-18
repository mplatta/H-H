package pl.com.harehounds.harehounds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import org.apache.http.*;
import java.io.*;
import java.net.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void logIn(View view) {
        HttpClient client = new DefaultHttpClient();
    }
}
