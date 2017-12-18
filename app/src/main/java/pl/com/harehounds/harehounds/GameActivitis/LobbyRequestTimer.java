package pl.com.harehounds.harehounds.GameActivitis;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * created by klata on 11.12.2017.
 */

class LobbyRequestTimer implements Runnable {

	private Handler timerHandler = new Handler();
	private TextView mRunnerTextView;
	private TextView mSeekerTextView;
	private Integer gameId;
	private Boolean host;
	private AppCompatActivity activity;

	@Override
	public void run() {
		LobbyResponseListener responseListener = new LobbyResponseListener(activity, mRunnerTextView, mSeekerTextView, gameId, host);
		LobbyRequest lobbyRequest = new LobbyRequest(gameId, responseListener);
		RequestQueue queue = Volley.newRequestQueue(activity);
		queue.add(lobbyRequest);

		timerHandler.postDelayed(this, 5000);
	}

	LobbyRequestTimer(AppCompatActivity activity, Integer gameId, Boolean host, TextView mRunner, TextView mSeeker) {
		this.mRunnerTextView = mRunner;
		this.mSeekerTextView = mSeeker;
		this.gameId = gameId;
		this.activity = activity;
		this.host = host;
	}

	public void Close() {
		timerHandler.removeCallbacks(this);
	}
}
