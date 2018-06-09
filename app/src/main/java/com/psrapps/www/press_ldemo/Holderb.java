package com.psrapps.www.press_ldemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by poornashekarreddy.p on 10-09-2017.
 */

public class Holderb extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView description;
    private TextView category;
    public RelativeLayout relativeLayout;
    public Holderb(View itemView) {
        super(itemView);
        this.name=(TextView)itemView.findViewById(R.id.name);
        this.description=(TextView)itemView.findViewById(R.id.description);
        this.category=(TextView)itemView.findViewById(R.id.category);
        this.relativeLayout=(RelativeLayout)itemView.findViewById(R.id.relativess);
    }
    public void UpdateUI(Modelb q){
        category.setText(q.getCategory());
        name.setText(q.getName());
        description.setText(q.getDescription());
    }
}
