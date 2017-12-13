package pl.com.harehounds.harehounds.GameActivitis.RunnerActivities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import pl.com.harehounds.harehounds.R;

public class RunnerActivity extends AppCompatActivity {

	private Integer gameId;
	private Double latitude;
	private Double longitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_runner);

		gameId = Integer.parseInt(getIntent().getStringExtra("gameId"));

		Button mButton = (Button) findViewById(R.id.setRiddleHere);
		final LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		LocationListener locationListener = new RunnerLocationListener(this, latitude, longitude);

		if (ActivityCompat.checkSelfPermission(RunnerActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
			!= PackageManager.PERMISSION_GRANTED &&
			ActivityCompat.checkSelfPermission(RunnerActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)
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

		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 50f, locationListener);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0,  50f, locationListener);

		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				putRiddle();
			}
		});
	}

	private void putRiddle() {
		PutRiddleResponseListener responseListener = new PutRiddleResponseListener();
		PutRiddleRequest putRiddleRequest = new PutRiddleRequest(gameId, latitude, longitude, responseListener);
		RequestQueue queue = Volley.newRequestQueue(RunnerActivity.this);
		queue.add(putRiddleRequest);
	}
}
