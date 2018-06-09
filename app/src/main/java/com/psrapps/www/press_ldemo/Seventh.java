package com.psrapps.www.press_ldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by poornashekarreddy.p on 07-09-2017.
 */

public class Seventh extends Fragment {
    View myview;
    ImageButton btn,btn2,btn3,btn4,btn5,btn6;
    String qt;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.seventh,container,false);
        btn=(ImageButton)myview.findViewById(R.id.button1);
        btn2=(ImageButton)myview.findViewById(R.id.button2);
        btn3=(ImageButton) myview.findViewById(R.id.button3);
        btn4=(ImageButton)myview.findViewById(R.id.button4);
        btn5=(ImageButton)myview.findViewById(R.id.button5);
        btn6=(ImageButton)myview.findViewById(R.id.button6);
        load();
        return myview;
    }

    public void load(){
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getContext(),"btn",Toast.LENGTH_LONG).show();
                qt="btn";
                load2();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getContext(),"btn2",Toast.LENGTH_LONG).show();
                qt="btn2";
                load2();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getContext(),"btn3",Toast.LENGTH_LONG).show();
                qt="btn3";
                load2();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getContext(),"btn4",Toast.LENGTH_LONG).show();
                qt="btn4";
                load2();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getContext(),"btn5",Toast.LENGTH_LONG).show();
                qt="btn5";
                load2();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Toast.makeText(getContext(),"btn6",Toast.LENGTH_LONG).show();
                qt="btn6";
                load2();
            }
        });
    }
    public void load2()
    {
        Intent i=new Intent(getContext(),Display.class);
        i.putExtra("quote",qt);
        startActivity(i);
    }
}
