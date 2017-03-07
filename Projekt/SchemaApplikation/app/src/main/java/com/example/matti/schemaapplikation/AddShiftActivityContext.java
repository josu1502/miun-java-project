package com.example.matti.schemaapplikation;

import android.content.Context;

/**
 * Created by Joakim on 17-03-07.
 */

public class AddShiftActivityContext {
    Context addActivityShiftContext;

    public AddShiftActivityContext(Context c) {
        this.addActivityShiftContext = c;
    }

    public Context getContext() {
        return addActivityShiftContext;
    }

}
