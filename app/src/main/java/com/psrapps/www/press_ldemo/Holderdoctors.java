package com.psrapps.www.press_ldemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by poornashekarreddy.p on 14-09-2017.
 */

public class Holderdoctors extends RecyclerView.ViewHolder {
    private TextView docname;
    private TextView docemail;
    private TextView doccity;
    private TextView docaddress;
    public Holderdoctors(View itemView) {
        super(itemView);
        this.docname=(TextView)itemView.findViewById(R.id.docname);
        this.docemail=(TextView)itemView.findViewById(R.id.docemail);
        this.doccity=(TextView)itemView.findViewById(R.id.doccity);
        this.docaddress=(TextView)itemView.findViewById(R.id.docaddress);
    }
    public void UpdateUI(Modeldoctors doctor)
    {
        docname.setText(doctor.getDocname());
        docemail.setText(doctor.getDocemail());
        doccity.setText(doctor.getDoccity());
        docaddress.setText(doctor.getDocaddress());
    }
}
