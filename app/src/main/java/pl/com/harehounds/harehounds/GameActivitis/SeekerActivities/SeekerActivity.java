package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import pl.com.harehounds.harehounds.R;

public class SeekerActivity extends AppCompatActivity {

	private TextView mDirection;
	private TextView mStatus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seeker);

		mDirection = (TextView) findViewById(R.id.direction);
		mStatus = (TextView) findViewById(R.id.status);
		Button mButton = (Button) findViewById(R.id.getLoc);

		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		LocationListener locationListener = new LocationListener() {
			@Override
			public void onLocationChanged(Location location) {
				mDirection.append("\n " + location.getLatitude() + "   " + location.getLongitude());
			}

			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {
				mDirection.setText(null);
				mStatus.setText(provider + " / " + extras.toString());
			}

			@Override
			public void onProviderEnabled(String provider) {
				mStatus.setText(provider);
			}

			@Override
			public void onProviderDisabled(String provider) {
				if (!Objects.equals(provider, "network")) {
					Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
					startActivity(intent);
				}
			}
		};

		if (ActivityCompat.checkSelfPermission(SeekerActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(SeekerActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
			// TODO: Consider calling
			//    ActivityCompat#requestPermissions
			// here to request the missing permissions, and then overriding
			//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
			//                                          int[] grantResults)
			// to handle the case where the user grants the permission. See the documentation
			// for ActivityCompat#requestPermissions for more details.
			mStatus.setText("dupa");

			return;
		}


//		Location lastKnowLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

		//locationListener.onLocationChanged(lastKnowLocation);

		mButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
//				if (ActivityCompat.checkSelfPermission(SeekerActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(SeekerActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//					// TODO: Consider calling
//					//    ActivityCompat#requestPermissions
//					// here to request the missing permissions, and then overriding
//					//   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//					//                                          int[] grantResults)
//					// to handle the case where the user grants the permission. See the documentation
//					// for ActivityCompat#requestPermissions for more details.
//					return;
//				} else locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 200, 0, locationListener);
				mDirection.setText(null);
			}
		});

//		mDirection.append(lastKnowLocation.toString());
		locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
		//mDirection.setText("test");
	}
}
