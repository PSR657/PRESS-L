package com.psrapps.www.press_ldemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by poornashekarreddy.p on 09-10-2017.
 */

public class NinePersonal extends Fragment {

    View myview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.personal, container, false);
        return myview;
    }
    //View view =this.getWindow().getDecorView();
    //view.setBackground(Resource(R.color.name);
}
