package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

import android.location.Location;

/**
 * created by klata on 06.12.2017.
 */

class Checkpoint {
	private Integer id;
	private Location location;
	private String text;
//	private String[] options;
	private String answer;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Boolean status;
	private Boolean wayPoint;
	private static Checkpoint instance = null;

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

	public static Checkpoint getInstance() {
		if (instance == null) instance = new Checkpoint();
		return instance;
	}

	public static Checkpoint getInstance(Double _latitude, Double _longitude) {
		if (instance == null) instance = new Checkpoint(_latitude, _longitude);
		return instance;
	}

	private Checkpoint (Double _latitude, Double _longitude) {
		this.location.setLatitude(_latitude);
		this.location.setLongitude(_longitude);
	}

	private Checkpoint() {}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	Boolean answerQuestion(Integer i) {
		Boolean tmp;

		switch (i) {
			case 0:
				tmp = optionA.equals(answer);
				status = tmp;
				return tmp;
			case 1:
				tmp = optionB.equals(answer);
				status = tmp;
				return tmp;
			case 2:
				tmp = optionC.equals(answer);
				status = tmp;
				return tmp;
			case 3:
				tmp = optionD.equals(answer);
				status = tmp;
				return tmp;
			default:
				status = false;
				return false;
		}
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Boolean getWayPoint() {
		return wayPoint;
	}

	public void setWayPoint(Boolean wayPoint) {
		this.wayPoint = wayPoint;
	}
}
