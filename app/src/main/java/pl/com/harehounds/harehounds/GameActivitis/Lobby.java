package pl.com.harehounds.harehounds.GameActivitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import pl.com.harehounds.harehounds.R;

public class Lobby extends AppCompatActivity {

	private TextView mRunnerTextView;
	private TextView mSeekerTextView;
	private Integer gameId;
	private Integer player;

	private Runnable timerRunnable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lobby);

		mRunnerTextView = (TextView) findViewById(R.id.player1);
		mSeekerTextView = (TextView) findViewById(R.id.player2);
		Button mStartGame = (Button) findViewById(R.id.startGameLobby);

		timerRunnable = new LobbyRequestTimer(Lobby.this, gameId, mRunnerTextView, mSeekerTextView);

		mStartGame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LobbyStartGameResponseListener responseListener = new LobbyStartGameResponseListener(Lobby.this);
				LobbyStartGameRequest lobbyStartGameRequest = new LobbyStartGameRequest(gameId, player, responseListener);
				RequestQueue queue = Volley.newRequestQueue(Lobby.this);
				queue.add(lobbyStartGameRequest);
			}
		});
	}
}
