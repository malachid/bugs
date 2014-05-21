package org.eoti.bugs.mavenandroidplugin.issue358.api;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.TextView;

public class IdField extends TextView
{
    protected static int DEFAULT_TEXT_BG_COLOR = Color.WHITE;

    public IdField(Context context) {
        super(context);
    }

    public IdField(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.org_eoti_bugs_mavenandroidplugin_issue358_api_IdField);
        try {
            int colorId = arr.getColor(R.styleable.org_eoti_bugs_mavenandroidplugin_issue358_api_IdField_idBackgroundColor, DEFAULT_TEXT_BG_COLOR);
            setBackgroundColor(colorId);
        } finally {
            arr.recycle();
        }
    }

}