package com.psrapps.www.press_ldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by poornashekarreddy.p on 07-09-2017.
 */

public class Sixth extends Fragment {
    Spinner spinner;
    String selected;
    ArrayList<String> districtslist=new ArrayList();

    //String[] districtslist = {"Select state","Tamil Nadu"};
    String url="http://34.210.77.132:3009/psr/down/districts";
    View myview;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.sixth,container,false);
        spinner = (Spinner)myview.findViewById(R.id.spinner);
        districtslist.add("select district");
        getdistricts();
        load();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected=districtslist.get(position);
                Intent i = new Intent(getContext(),DoctorsList.class);
                i.putExtra("selected",selected);
                if(selected!="select district")
                {
                    startActivity(i);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return myview;
    }
    public void load()
    {
        ArrayAdapter<String> states = new ArrayAdapter<String>(
                getActivity(),android.R.layout.simple_expandable_list_item_1, districtslist);
        states.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(states);
    }
    public void getdistricts()
    {
        final JsonArrayRequest getModel=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                {try
                {
                    JSONArray array = response;
                                        for(int x=0;x<array.length();x++)
                    {
                        JSONObject model = array.getJSONObject(x);
                        String district = model.getString("district");
                        districtslist.add(district);
                    }
                }
                catch(JSONException e)
                {
                    Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
                }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        Volley.newRequestQueue(getContext()).add(getModel);
    }


}
