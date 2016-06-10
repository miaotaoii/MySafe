package com.lcj.mysafe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class WelcomeActivity extends Activity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        if (getActionBar() != null)
            getActionBar().show();
    }
}
