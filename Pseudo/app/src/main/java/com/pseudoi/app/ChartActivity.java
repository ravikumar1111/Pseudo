package com.pseudoi.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pseudoi.app.fragments.ChartFragment;
import com.pseudoi.app.ui.main.MainFragment;

public class ChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ChartFragment.newInstance())
                    .commitNow();
        }
    }
}
