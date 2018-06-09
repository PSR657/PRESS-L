package com.psrapps.www.press_ldemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by poornashekarreddy.p on 09-09-2017.
 */

public class Holder extends RecyclerView.ViewHolder {
    private TextView Title;
    private TextView Description;
    private TextView Duration;
    private TextView Category;
    public RelativeLayout relativeLayout;


    public Holder(View itemView) {
        super(itemView);
        this.Title=(TextView)itemView.findViewById(R.id.e);
        this.Description=(TextView)itemView.findViewById(R.id.h);
        this.Duration=(TextView)itemView.findViewById(R.id.f);
        this.Category=(TextView)itemView.findViewById(R.id.g);
        this.relativeLayout=(RelativeLayout)itemView.findViewById(R.id.relative);
    }
    public void UpdateUI(Model video)
    {
        Title.setText(video.getTitle());
        Description.setText(video.getDescription());
        Duration.setText(video.getDuration());
        Category.setText(video.getCategory());
    }
}
