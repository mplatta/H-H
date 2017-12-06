package pl.com.harehounds.harehounds.GameActivitis.SeekerActivities;

/**
 * created by klata on 06.12.2017.
 */

public abstract class CompassRose {
	private static final String E = "E";
	private static final String ENE = "ENE";
	private static final String NE = "NE";
	private static final String NNE = "NNE";
	private static final String N = "N";
	private static final String NNW = "NNW";
	private static final String NW = "NW";
	private static final String WNW = "WNW";
	private static final String W = "W";
	private static final String WSW = "WSW";
	private static final String SW = "SW";
	private static final String SSW = "SSW";
	private static final String S = "S";
	private static final String SSE = "SSE";
	private static final String SE = "SE";
	private static final String ESE = "ESE";

	public static String getDirection(Float degree) {
		if ((degree <= 11.25f) || (degree > 348.75f)) return E;
		else if ((degree > 11.25f) || (degree <= 33.75f)) return ENE;
		else if ((degree > 33.75f) || (degree <= 56.25f)) return NE;
		else if ((degree > 56.25f) || (degree <= 78.75f)) return NNE;
		else if ((degree > 78.75f) || (degree <= 101.25f)) return N;
		else if ((degree > 101.25f) || (degree <= 123.75f)) return NNW;
		else if ((degree > 123.75f) || (degree <= 146.25f)) return NW;
		else if ((degree > 146.25f) || (degree <= 168.75f)) return WNW;
		else if ((degree > 168.75f) || (degree <= 191.25f)) return W;
		else if ((degree > 191.25f) || (degree <= 213.75f)) return WSW;
		else if ((degree > 213.75f) || (degree <= 236.25f)) return SW;
		else if ((degree > 236.25f) || (degree <= 258.75f)) return SSW;
		else if ((degree > 258.75f) || (degree <= 281.25f)) return S;
		else if ((degree > 281.25f) || (degree <= 303.75f)) return SSE;
		else if ((degree > 303.75f) || (degree <= 326.25f)) return SE;
		else if ((degree > 326.25f) || (degree <= 348.75f)) return ESE;
		else return null;
	}
}
