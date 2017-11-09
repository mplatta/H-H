package pl.com.harehounds.harehounds;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Adam on 05.11.2017.
 */

public class FriendComponent extends LinearLayout {
    TextView name_text;

    public FriendComponent(Context context) {
        super(context);
        init(context);
    }

    public FriendComponent(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FriendComponent(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.friend_component, this);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
    }

    public void setNickText(String name) {
        name_text.setText(name);
    }
}