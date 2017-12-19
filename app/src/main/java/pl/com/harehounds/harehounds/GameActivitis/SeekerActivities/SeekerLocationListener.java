package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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

	private TextView mQuestion;
	private Button mOptionA;
	private Button mOptionB;
	private Button mOptionC;
	private Button mOptionD;

	private Checkpoint checkpoint = Checkpoint.getInstance();
	private Integer gameId;

	@Override
	public void onLocationChanged(Location location) {
		Float distance = location.distanceTo(checkpoint.getLocation());
		Float bearing = location.bearingTo(checkpoint.getLocation());

		if (minDistance <= distance) {
				mOptionA.setVisibility(View.VISIBLE);
				mOptionB.setVisibility(View.VISIBLE);
				mOptionC.setVisibility(View.VISIBLE);
				mOptionD.setVisibility(View.VISIBLE);
			if (checkpoint.getWayPoint()) {
				mQuestion.setText("uciekający są w odległości mniejszej niż 50m: " );

			} else {
				checkpoint.setStatus(true);

				mQuestion.setText(checkpoint.getText() + "\n" +
						checkpoint.getOptionA() + "\n" +
						checkpoint.getOptionB() + "\n" +
						checkpoint.getOptionC() + "\n" +
						checkpoint.getOptionD() + "\n");
			}
		} else {
			mQuestion.setText("Do zagadki pozostalo ci: " + distance.toString() + "\n"
					+ "kieruj się na: " + CompassRose.getDirection(bearing));
			mOptionA.setVisibility(View.INVISIBLE);
			mOptionB.setVisibility(View.INVISIBLE);
			mOptionC.setVisibility(View.INVISIBLE);
			mOptionD.setVisibility(View.INVISIBLE);
		}

		if (checkpoint.getStatus()) {
			SeekerGameResponseListener responseListener = new SeekerGameResponseListener(checkpoint);
			SeekerGameRequest seekerGameRequest = new SeekerGameRequest(gameId, 0, responseListener);
			RequestQueue queue = Volley.newRequestQueue(activity);
			queue.add(seekerGameRequest);
		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
//		mDirection.setText(null);
//		mStatus.setText(provider + " / " + extras.toString());
	}

	@Override
	public void onProviderEnabled(String provider) {
//		mStatus.setText(provider);
	}

	@Override
	public void onProviderDisabled(String provider) {
		if (!Objects.equals(provider, "network")) {
			Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			activity.startActivity(intent);
		}
	}

	SeekerLocationListener(AppCompatActivity _activity, Integer gameId, TextView mQuestion, Checkpoint _checkpoint,
						   Button mOptionA, Button mOptionB, Button mOptionC, Button mOptionD) {
		activity = _activity;
		checkpoint = _checkpoint;
		this.gameId = gameId;
		this.mQuestion = mQuestion;
		this.mOptionA = mOptionA;
		this.mOptionB = mOptionB;
		this.mOptionC = mOptionC;
		this.mOptionD = mOptionD;
	}
}
