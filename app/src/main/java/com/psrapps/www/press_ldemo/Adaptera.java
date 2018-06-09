package com.psrapps.www.press_ldemo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by poornashekarreddy.p on 09-09-2017.
 */

public class Adaptera extends RecyclerView.Adapter<Holder> {

    public Adaptera(ArrayList<Model> videos) {
        this.videos = videos;
    }

    private ArrayList<Model> videos=new ArrayList();
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardvid,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final Model video = videos.get(position);
        holder.UpdateUI(video);
        final String link = video.getLink();
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),YoutubeVideo.class);
                i.putExtra("link",link);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
