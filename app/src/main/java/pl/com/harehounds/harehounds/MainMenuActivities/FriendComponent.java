package pl.com.harehounds.harehounds.MainMenuActivities;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import pl.com.harehounds.harehounds.R;

/**
 * created by Adam on 05.11.2017.
 */

public class FriendComponent extends LinearLayout {
	private Context context;
	private TextView name;

	public FriendComponent(Context context) {
		super(context);
		this.context = context;
		init(context);
	}

	public FriendComponent(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init(context);
	}

	public FriendComponent(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		init(context);
	}

	private void init(Context context) {
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.friend_component, this, false);

//		name = (TextView) getChildAt(0);

//		View.inflate(context, R.layout.friend_component, this);

		setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
//		FriendComponent.this.addView(name);
	}

	public void setNickText(String name) {
		this.name.setText(name);
	}
}