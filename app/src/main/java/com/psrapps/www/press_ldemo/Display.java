package com.psrapps.www.press_ldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Display extends AppCompatActivity {
    TextView a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        String link=getIntent().getStringExtra("quote");
        a=(TextView)findViewById(R.id.disp);
        a.setText(link);
    }
}
