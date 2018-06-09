package com.psrapps.www.press_ldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ShortStories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.short_stories);
        String path=getIntent().getStringExtra("path");
        Toast.makeText(getBaseContext(),path,Toast.LENGTH_LONG).show();
    }
}
