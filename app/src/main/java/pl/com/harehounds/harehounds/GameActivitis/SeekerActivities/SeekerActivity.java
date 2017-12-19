package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import pl.com.harehounds.harehounds.R;

public class SeekerActivity extends AppCompatActivity {

	private Button mOptionA;
	private Button mOptionB;
	private Button mOptionC;
	private Button mOptionD;
	private TextView mQuestion;

	private Integer gameId;
	private Checkpoint checkpoint = Checkpoint.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seeker);

		gameId = Integer.parseInt(getIntent().getStringExtra("gameId"));

		mOptionA = (Button) findViewById(R.id.optionA);
		mOptionB = (Button) findViewById(R.id.optionB);
		mOptionC = (Button) findViewById(R.id.optionC);
		mOptionD = (Button) findViewById(R.id.optionD);
		mQuestion = (TextView) findViewById(R.id.question);

		// take first checkpoint
		SeekerGameResponseListener responseListener = new SeekerGameResponseListener(checkpoint);
		SeekerGameRequest seekerGameRequest = new SeekerGameRequest(gameId, 0, responseListener);
		RequestQueue queue = Volley.newRequestQueue(SeekerActivity.this);
		queue.add(seekerGameRequest);

		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		LocationListener locationListener = new SeekerLocationListener(this, gameId, mQuestion, checkpoint, mOptionA, mOptionB, mOptionC, mOptionD);

		if (ActivityCompat.checkSelfPermission(SeekerActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
			!= PackageManager.PERMISSION_GRANTED &&
			ActivityCompat.checkSelfPermission(SeekerActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
			!= PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.

			return;
		}

		mOptionA.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkpoint.answerQuestion(0);
			}
		});

		mOptionB.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkpoint.answerQuestion(1);
			}
		});

		mOptionC.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkpoint.answerQuestion(2);
			}
		});

		mOptionD.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkpoint.answerQuestion(3);
			}
		});

		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 0, locationListener);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locationListener);
	}

}
