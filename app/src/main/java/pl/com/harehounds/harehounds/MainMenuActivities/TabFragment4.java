package pl.com.harehounds.harehounds.MainMenuActivities;

/*
 * created by Adam on 12.11.2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import pl.com.harehounds.harehounds.R;
import pl.com.harehounds.harehounds.User.UserSingleton;

public class TabFragment4 extends Fragment {
    private Integer gameId;
    private UserSingleton user = UserSingleton.getInstance();
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_fragment_4, container, false);

        Button startGame = (Button) view.findViewById(R.id.startNewGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewGame();
            }
        });
        return view;
    }

    private void createNewGame() {
        CreateGameResponseListener responseListener = new CreateGameResponseListener(getActivity(), gameId);
        CreateGameRequest createGameRequest = new CreateGameRequest(user.getIdUser(), 60, 0, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(createGameRequest);
    }
}
