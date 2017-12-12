package pl.com.harehounds.harehounds.MainMenuActivities;

/*
 * created by Adam on 12.11.2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import pl.com.harehounds.harehounds.GameActivitis.Lobby;
import pl.com.harehounds.harehounds.R;

public class TabFragment4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_fragment_4, container, false);

        Button startGame = (Button) view.findViewById(R.id.startNewGame);
        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewGame();
                Intent intent = new Intent(getActivity(), Lobby.class);

                startActivity(intent);
            }
        });
        return view;
    }

    private void createNewGame() {

    }
}
