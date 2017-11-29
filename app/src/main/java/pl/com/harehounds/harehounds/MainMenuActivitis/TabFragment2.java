package pl.com.harehounds.harehounds.MainMenuActivitis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import pl.com.harehounds.harehounds.R;
import pl.com.harehounds.harehounds.User.UserSingleton;

/**
 * created by Adam on 01.11.2017.
 */
public class TabFragment2 extends Fragment {
	private EditText newFriendNickName;
	private UserSingleton user = UserSingleton.getInstance();
	private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.tab_fragment_2,
				container, false);

		newFriendNickName = (EditText) view.findViewById(R.id.newFriendNickName);
		Button button = (Button) view.findViewById(R.id.addFriendButton);
		button.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// do something
			}
		});

		return view;
    }

	private void addFriend() {
		final String nickName = newFriendNickName.getText().toString();

//		AddFriendResponseListener responseListener = new AddFriendResponseListener(getActivity());

		Response.Listener<String> responseListener = new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				try {
					JSONObject jsonResponse = new JSONObject(response);
					boolean success = jsonResponse.getBoolean("success");

					if (success) {
						Toast.makeText(getActivity(), "Success!", Toast.LENGTH_LONG).show();
						// TODO: 15.11.17 add refreash list
					} else {
						Toast.makeText(getActivity(), "Failed! This user doesn't exist!", Toast.LENGTH_LONG).show();
					}
				} catch (JSONException e) {
					// TODO: 31.10.2017 change error message
					AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
					builder.setMessage(e.getMessage())
						.setNegativeButton("Retry", null)
						.create()
						.show();
				}
			}
		};
		AddFriendRequest addFriendRequest = new AddFriendRequest(user.getIdUser(), nickName, responseListener);
		RequestQueue queue = Volley.newRequestQueue(getActivity());
		queue.add(addFriendRequest);
	}
}
