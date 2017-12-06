package pl.com.harehounds.harehounds.MainMenuActivities;

        import android.content.Context;
        import android.util.AttributeSet;
        import android.view.View;
        import android.widget.LinearLayout;
        import android.widget.TextView;

		import pl.com.harehounds.harehounds.R;

/**
 * created by Adam on 05.11.2017.
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