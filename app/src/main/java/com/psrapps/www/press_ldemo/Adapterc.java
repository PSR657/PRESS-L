package com.psrapps.www.press_ldemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by poornashekarreddy.p on 10-09-2017.
 */

public class Adapterc extends RecyclerView.Adapter<Holderc>{

    ArrayList<Modelc> quotes = new ArrayList();

    public Adapterc(ArrayList<Modelc> quotes) {
        this.quotes = quotes;
    }

    @Override
    public Holderc onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardqts,parent,false);
        return new Holderc(view);
    }

    @Override
    public void onBindViewHolder(Holderc holder, int position) {
        final Modelc quote = quotes.get(position);
        holder.UpdateUI(quote);
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }
}
