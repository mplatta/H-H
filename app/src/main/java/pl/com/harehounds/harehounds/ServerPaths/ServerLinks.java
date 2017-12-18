package pl.com.harehounds.harehounds.ServerPaths;

/**
 * created by klata on 15.11.17.
 */

public abstract class ServerLinks {
	private static  final String host = "http://42.0.139.255:5000";
	public static final String LOGIN_REQUEST_URL = host + "/api/login";
//	public static final String LOGIN_REQUEST_URL = "http://klata.cba.pl/testapp2.php";
	public static final String REGISTER_REQUEST_URL = host + "/api/register";
//	private static final String FRIEND_REQUEST_URL = "http://42.0.139.255:5000/api/friends";
	public static final String ADD_FRIEND_REQUEST_URL = host + "/api/friends";
	public static final String GET_FRIEND_REQUEST_URL = host + "/api/friends";
	public static final String GET_CHECKPOINT_POSITION = host + "/api/getCheckpoint";
	public static final String SET_WAY_POINT_POSITION = host + "/api/setWaypoint";
	public static final String GET_LOBBY = host + "/api/games/lobby";
	public static final String GET_GAMES = host + "/api/games";
	public static final String CREATE_GAME_URL = host + "/api/games";
	public static final String GAMES_JOIN = host + "/api/games/join";
	public static final String SET_READY_GAMES = host + "/api/games/setready";
}