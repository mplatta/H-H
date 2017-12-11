package pl.com.harehounds.harehounds.ServerPaths;

/**
 * created by klata on 15.11.17.
 */

public abstract class ServerLinks {
	public static final String LOGIN_REQUEST_URL = "http://42.0.139.255:5000/api/login";
//	public static final String LOGIN_REQUEST_URL = "http://klata.cba.pl/testapp2.php";
	public static final String REGISTER_REQUEST_URL = "http://42.0.139.255:5000/api/register";
//	private static final String FRIEND_REQUEST_URL = "http://42.0.139.255:5000/api/friends";
	public static final String ADD_FRIEND_REQUEST_URL = "http://42.0.139.255:5000/api/friends";
	public static final String GET_FRIEND_REQUEST_URL = "http://42.0.139.255:5000/api/friends";
	public static final String GET_CHECKPOINT_POSITION = "http://42.0.139.255:5000/api/getCheckpoint";
	public static final String SET_WAY_POINT_POSITION = "http://42.0.139.255:5000/api/setWaypoint";
}
