package pl.com.harehounds.harehounds.GameActivitis.RunnerActivities;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Objects;

/**
 * created by klata on 11.12.2017.
 */

class RunnerLocationListener implements LocationListener {
	private AppCompatActivity activity;
	private Integer gameId;
	private TextView lat;
	private TextView longi;
	private Boolean start;
	private TextView test;

	@Override
	public void onLocationChanged(Location location) {

//		this.location = location;

		Location tmp = new Location("");

		if (start) {
			lat.setText(((Double) location.getLatitude()).toString());
			longi.setText(((Double) location.getLongitude()).toString());

			start = false;
		}

		tmp.setLatitude(Double.parseDouble(lat.getText().toString()));
		tmp.setLongitude(Double.parseDouble(longi.getText().toString()));


		if (location.distanceTo(tmp) > 10) {
			RunnerGameResponseListener responseListener = new RunnerGameResponseListener(activity);
			RunnerGameRequest runnerGameRequest = new RunnerGameRequest(gameId, location.getLatitude(), location.getLongitude(), responseListener);
			RequestQueue queue = Volley.newRequestQueue(activity);
			queue.add(runnerGameRequest);
			test.setText(((Float) location.distanceTo(tmp)).toString());
		}
		lat.setText(((Double) location.getLatitude()).toString());
		longi.setText(((Double) location.getLongitude()).toString());

		Log.d("loctest_latitude", ((Double)location.getLatitude()).toString());
		Log.d("loctest_longitude", ((Double)location.getLongitude()).toString());
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {

	}

	@Override
	public void onProviderEnabled(String provider) {

	}

	@Override
	public void onProviderDisabled(String provider) {
		if (!Objects.equals(provider, "network")) {
			Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			activity.startActivity(intent);
		}
	}

	RunnerLocationListener(Integer gameId, AppCompatActivity _activity, TextView lat, TextView longi, TextView test) {
		this.activity = _activity;
		this.gameId = gameId;
		this.lat = lat;
		this.longi = longi;
		this.start = true;
		this.test = test;
	}
}
