package pl.com.harehounds.harehounds.GameActivitis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import pl.com.harehounds.harehounds.R;
import pl.com.harehounds.harehounds.User.UserSingleton;

public class Lobby extends AppCompatActivity {

	private TextView mRunnerTextView;
	private TextView mSeekerTextView;
	private UserSingleton user = UserSingleton.getInstance();
	private Integer gameId;
	private Boolean host;

	private Runnable timerRunnable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lobby);

		gameId = Integer.parseInt(getIntent().getStringExtra("gameId"));
		host = Boolean.parseBoolean(getIntent().getStringExtra("host"));

		if (user == null) {
			// TODO: 13.12.17 wyloguj 
		}
		
		mRunnerTextView = (TextView) findViewById(R.id.player1);
		mSeekerTextView = (TextView) findViewById(R.id.player2);
		Button mStartGame = (Button) findViewById(R.id.startGameLobby);

		timerRunnable = new LobbyRequestTimer(Lobby.this, gameId, mRunnerTextView, mSeekerTextView);

		mStartGame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LobbyStartGameResponseListener responseListener = new LobbyStartGameResponseListener(Lobby.this);
				LobbyStartGameRequest lobbyStartGameRequest = new LobbyStartGameRequest(gameId, user.getIdUser(), responseListener);
				RequestQueue queue = Volley.newRequestQueue(Lobby.this);
				queue.add(lobbyStartGameRequest);
			}
		});
	}
}