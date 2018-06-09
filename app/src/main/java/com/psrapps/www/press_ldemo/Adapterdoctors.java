package com.psrapps.www.press_ldemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by poornashekarreddy.p on 14-09-2017.
 */

public class Adapterdoctors extends RecyclerView.Adapter<Holderdoctors> {

    ArrayList<Modeldoctors> doctors = new ArrayList();

    public Adapterdoctors(ArrayList<Modeldoctors> doctors) {
        this.doctors = doctors;
    }

    @Override
    public Holderdoctors onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carddoctors,parent,false);
        return new Holderdoctors(view);
    }

    @Override
    public void onBindViewHolder(Holderdoctors holder, int position) {
        final Modeldoctors doctor = doctors.get(position);
        holder.UpdateUI(doctor);
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }
}
