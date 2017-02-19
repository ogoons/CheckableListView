package com.ogoons.checkablesample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.RelativeLayout;

/**
 * Created by ogoons on 2017-02-19.
 */

public class CheckableRelativeLayout extends RelativeLayout implements Checkable {
    final String NS = "http://schemas.android.com/apk/res/com.ogoons.checkablesample";
    final String ATTR = "checkable";

    int checkableId;
    Checkable checkable;

    public CheckableRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        checkableId = attrs.getAttributeResourceValue(NS, ATTR, 0);
    }
    public boolean isChecked() {
        checkable = (Checkable) findViewById(checkableId);
        if(checkable == null)
            return false;
        return checkable.isChecked();
    }

    public void setChecked(boolean checked) {
        checkable = (Checkable) findViewById(checkableId);
        if(checkable == null)
            return;
        checkable.setChecked(checked);
    }

    public void toggle() {
        checkable = (Checkable) findViewById(checkableId);
        if(checkable == null)
            return;
        checkable.toggle();
    }


}