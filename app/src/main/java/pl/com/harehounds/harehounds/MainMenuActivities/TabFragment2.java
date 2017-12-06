package pl.com.harehounds.harehounds.MainMenuActivities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import pl.com.harehounds.harehounds.R;
import pl.com.harehounds.harehounds.User.UserSingleton;

/**
 * created by Adam on 01.11.2017.
 */
public class TabFragment2 extends Fragment {
	private EditText newFriendNickName;
	private UserSingleton user = UserSingleton.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.tab_fragment_2,
				container, false);

		newFriendNickName = (EditText) view.findViewById(R.id.newFriendNickName);
		Button button = (Button) view.findViewById(R.id.addFriendButton);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				addFriend();
			}
		});

		return view;
    }

	private void addFriend() {
		final String nickName = newFriendNickName.getText().toString();

		AddFriendResponseListener responseListener = new AddFriendResponseListener(getActivity());

		AddFriendRequest addFriendRequest = new AddFriendRequest(user.getIdUser(), nickName, responseListener);
		RequestQueue queue = Volley.newRequestQueue(getActivity());
		queue.add(addFriendRequest);
	}
}
