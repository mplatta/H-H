package pl.com.harehounds.harehounds.MainMenuActivities;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import pl.com.harehounds.harehounds.R;
import pl.com.harehounds.harehounds.ServerPaths.ServerLinks;
import pl.com.harehounds.harehounds.User.UserSingleton;

/**
 * created by Adam on 01.11.2017.
 */
public class TabFragment2 extends Fragment {
	private EditText newFriendNickName;
	private UserSingleton user = UserSingleton.getInstance();
	private LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.tab_fragment_2,
				container, false);

	    linearLayout = (LinearLayout) view.findViewById(R.id.friendsList);
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

	    loadFreinds();

		return view;
    }

	private void addFriend() {
		final String nickName = newFriendNickName.getText().toString();

		AddFriendResponseListener responseListener = new AddFriendResponseListener(getActivity());

		AddFriendRequest addFriendRequest = new AddFriendRequest(user.getIdUser(), nickName, responseListener);
		RequestQueue queue = Volley.newRequestQueue(getActivity());
		queue.add(addFriendRequest);
	}

	private void loadFreinds() {
		String url = ServerLinks.GET_FRIEND_REQUEST_URL + "?userId=" + user.getIdUser().toString();

		StringRequest loadFriendsRequest;
		loadFriendsRequest = new StringRequest(Request.Method.GET, url, new LoadFriendsResponseListener(getActivity(), linearLayout), null);
		RequestQueue queue = Volley.newRequestQueue(getActivity());
		queue.add(loadFriendsRequest);
	}
}
