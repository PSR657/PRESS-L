package com.psrapps.www.press_ldemo;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by poornashekarreddy.p on 10-09-2017.
 */

public class Adapterb extends RecyclerView.Adapter<Holderb> {
    public Adapterb(ArrayList<Modelb> stories) {
        this.stories = stories;
    }

    ArrayList<Modelb> stories=new ArrayList();
    @Override
    public Holderb onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardss,parent,false);
        return new Holderb(view);
    }

    @Override
    public void onBindViewHolder(Holderb holder, int position) {
        final Modelb story = stories.get(position);
        holder.UpdateUI(story);
        final String path = story.getPath();
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),ShortStories.class);
                i.putExtra("path",path);
                v.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }
}
