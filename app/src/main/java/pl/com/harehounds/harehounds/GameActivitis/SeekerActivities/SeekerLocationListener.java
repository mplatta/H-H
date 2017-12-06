package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.util.Objects;

/**
 * created by klata on 13.11.2017.
 */

class SeekerLocationListener implements LocationListener {
	private final Float minDistance = 50f;
	private AppCompatActivity activity;
	private TextView mDirection;
	private TextView mStatus;
	private Checkpoint checkpoint;

	@Override
	public void onLocationChanged(Location location) {
		mDirection.append("\n " + location.getLatitude() + "   " + location.getLongitude());
		Float distance = location.distanceTo(checkpoint.getLocation());
		Float bearing = location.bearingTo(checkpoint.getLocation());

		mStatus.setText(CompassRose.getDirection(bearing));

		if (minDistance >= distance) {
			// TODO: 06.12.2017 zagadka
		}

		if (checkpoint.getStatus()) {
			SeekerGameResponseListener responseListener = new SeekerGameResponseListener(checkpoint);
			SeekerGameRequest seekerGameRequest = new SeekerGameRequest(0, 0, responseListener);
			RequestQueue queue = Volley.newRequestQueue(activity);
			queue.add(seekerGameRequest);
		}
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
			activity.startActivity(intent);
		}
	}

	SeekerLocationListener(AppCompatActivity _activity,TextView _textView1, TextView _textView2, Checkpoint _checkpoint) {
		activity = _activity;
		mDirection = _textView1;
		mStatus = _textView2;
		checkpoint = _checkpoint;
	}
}
