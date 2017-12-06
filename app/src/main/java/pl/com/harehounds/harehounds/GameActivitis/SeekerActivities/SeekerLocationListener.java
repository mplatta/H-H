package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;

import pl.com.harehounds.harehounds.R;

/**
 * created by klata on 13.11.2017.
 */

class SeekerLocationListener implements LocationListener {
	private TextView mDirection;
	private TextView mStatus;

	@Override
	public void onLocationChanged(Location location) {

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {

	}

	@Override
	public void onProviderEnabled(String provider) {

	}

	@Override
	public void onProviderDisabled(String provider) {

	}

	SeekerLocationListener() {
//		mDirection = (TextView) findViewById(R.id.direction);
//		mStatus = (TextView) findViewById(R.id.status);
	}
}
