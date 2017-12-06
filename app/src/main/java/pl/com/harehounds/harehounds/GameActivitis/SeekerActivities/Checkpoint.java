package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

import android.location.Location;

/**
 * created by klata on 06.12.2017.
 */

class Checkpoint {
	private Integer id;
	private Location location;
	private String question;
	private String[] options;
	private Integer answer;
	private Boolean status;

	public Location getLocation() {
		return location;
	}

	public Double getLatitude() {
		return location.getLatitude();
	}

	public void setLatitude(Double _latitude) {
		this.location.setLatitude(_latitude);
	}

	public Double getLongitude() {
		return location.getLongitude();
	}

	public void setLongitude(Double _longitude) {
		this.location.setLongitude(_longitude);
	}

	public Boolean getStatus() {
		return this.status;
	}

	public void setStatus(Boolean status) {
		this.status = status;

	}

	Checkpoint(Double _latitude, Double _longitude) {
		this.location.setLatitude(_latitude);
		this.location.setLongitude(_longitude);
	}

	Checkpoint() {}
}
