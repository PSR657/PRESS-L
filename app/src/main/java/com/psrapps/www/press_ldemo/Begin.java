package com.psrapps.www.press_ldemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by poornashekarreddy.p on 09-10-2017.
 */

public class Begin extends AppCompatActivity {
    private static int a = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin);
        ImageView logo = (ImageView)findViewById(R.id.logopng);
        logo.animate().rotationY(360).setDuration(1000);
        TextView b =(TextView)findViewById(R.id.init);
        b.animate().scaleY(1.3f).scaleX(1.3f).setDuration(1000);
        new Handler().postDelayed(new Runnable()
                                  {
                                      @Override
                                      public void run()
                                      {
                                          Intent b = new Intent(Begin.this,MainActivity.class);
                                          startActivity(b);
                                          finish();
                                      }
                                  }
                ,a);
    }
}
