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
	private AppCompatActivity activity;

	@Override
	public void run() {
		LobbyResponseListener responseListener = new LobbyResponseListener(mRunnerTextView, mSeekerTextView);
		LobbyRequest lobbyRequest = new LobbyRequest(gameId, responseListener);
		RequestQueue queue = Volley.newRequestQueue(activity);
		queue.add(lobbyRequest);

		timerHandler.postDelayed(this, 5000);
	}

	LobbyRequestTimer(AppCompatActivity activity, Integer gameId, TextView mRunner, TextView mSeeker) {
		this.mRunnerTextView = mRunner;
		this.mSeekerTextView = mSeeker;
		this.gameId = gameId;
		this.activity = activity;
	}
}
