package pl.com.harehounds.harehounds.GameActivitis.RunnerActivities;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Objects;

/**
 * created by klata on 11.12.2017.
 */

class RunnerLocationListener implements LocationListener {
	private AppCompatActivity activity;

	@Override
	public void onLocationChanged(Location location) {
		Double latitude = location.getLatitude();
		Double longitude = location.getLongitude();

		RunnerGameResponseListener responseListener = new RunnerGameResponseListener(activity);
		RunnerGameRequest runnerGameRequest = new RunnerGameRequest(latitude, longitude, responseListener);
		RequestQueue queue = Volley.newRequestQueue(activity);
		queue.add(runnerGameRequest);
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

	RunnerLocationListener(AppCompatActivity _activity) {
		this.activity = _activity;
	}
}
