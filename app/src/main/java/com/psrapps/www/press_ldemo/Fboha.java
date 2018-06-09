package com.psrapps.www.press_ldemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class Fboha extends Fragment {

    String url="http://34.210.77.132:3009/psr/down/bohvid";
    ArrayList<Model> arrayList=new ArrayList();
    private Adaptera adaptera;
    View rootView;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fboha, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler);
        load();
        return rootView;
    }
    public void load(){
        final JsonArrayRequest getModel=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                {try
                {
                    JSONArray array = response;
                    //Toast.makeText(getContext(),response.toString(),Toast.LENGTH_LONG).show();
                    for(int x=0;x<array.length();x++)
                    {
                        JSONObject model = array.getJSONObject(x);
                        String Title = model.getString("name");
                        String description = model.getString("description");
                        String duration = model.getString("duration");
                        String link = model.getString("link");
                        String category = model.getString("category");
                        Model newmodel = new Model(Title,duration,category,description,link);
                        //Toast.makeText(getContext(),newmodel.getTitle().toString(),Toast.LENGTH_LONG).show();
                        arrayList.add(newmodel);

                    }
                }
                catch(JSONException e)
                {
                    Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
                }

                    recyclerView.setHasFixedSize(true);
                    recyclerView.addItemDecoration(new ItemDecorator(0,0,0,10));
                    adaptera = new Adaptera(arrayList);
                    recyclerView.setAdapter(adaptera);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recyclerView.setLayoutManager(layoutManager);
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
