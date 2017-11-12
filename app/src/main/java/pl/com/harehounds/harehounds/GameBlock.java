package pl.com.harehounds.harehounds;

import android.widget.LinearLayout;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Adam on 12.11.2017.
 */

public class GameBlock extends LinearLayout {
    TextView name;
    TextView distance;

    public GameBlock(Context context) {
        super(context);
        init(context);
    }

    public GameBlock(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GameBlock(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.game_component, this);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
    }
}

