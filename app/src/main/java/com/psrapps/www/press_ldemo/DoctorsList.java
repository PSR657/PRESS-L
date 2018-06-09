package com.psrapps.www.press_ldemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class DoctorsList extends AppCompatActivity {

    public static ArrayList<Modeldoctors> k = new ArrayList();
    private static Adapterdoctors adapterdoctors;
    static RecyclerView recyclerView;
    String link;
    //public static int done;
    static ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        k.clear();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctors_list);
        link=getIntent().getStringExtra("selected");
        progress = ProgressDialog.show(this, "Please Wait", "Loading the content please wait", true);
        //Toast.makeText(this,link,Toast.LENGTH_LONG).show();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerdoctors);

        registeruser(link,getBaseContext(),registerInterface);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
                /*Log.i("QQQQQ", k.toString());

                Toast.makeText(DoctorsList.this, k.toString(), Toast.LENGTH_SHORT).show();

                recyclerView.setHasFixedSize(true);
                recyclerView.addItemDecoration(new ItemDecorator(0, 0, 0, 10));
                adapterdoctors = new Adapterdoctors(k);
                recyclerView.setAdapter(adapterdoctors);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager);
                progress.dismiss();*/



    }
    public static void callback(){

        //Log.i("QQQQQ", k.toString());

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new ItemDecorator(0, 0, 0, 10));
        adapterdoctors = new Adapterdoctors(k);
        recyclerView.setAdapter(adapterdoctors);
        progress.dismiss();

    }
    RegisterInterface registerInterface=new RegisterInterface() {
        @Override
        public void success(Boolean success)
        {

        }

    };
    public interface RegisterInterface
    {
        void success(Boolean success);
    }


    public static void registeruser(String district, Context context, RegisterInterface registerInterface) {
        final ArrayList<Modeldoctors> list =new ArrayList();
        //done=0;
        try {
            String url ="http://34.210.77.132:3009/psr/down/docdistrict";
            JSONObject jsonbody = new JSONObject();
            jsonbody.put("upp", district);
            final String mRequestBody = jsonbody.toString();
            final JsonArrayRequest request = new JsonArrayRequest(Request.Method.POST,url,null,new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        JSONArray array = response;
                        for (int x = 0; x < array.length(); x++) {
                            JSONObject model = array.getJSONObject(x);
                            //Toast.makeText(DoctorsList.this,res,Toast.LENGTH_SHORT).show();
                            String Title = model.getString("title");
                            String name = model.getString("name");
                            String docname = Title + "." + name;
                            String email = model.getString("email");
                            String city = model.getString("city");
                            String address = model.getString("address");
                            Modeldoctors newdoctor = new Modeldoctors(docname, email, city, address);

                            k.add(newdoctor);
                        }
                        callback();
                        //adapterdoctors = new Adapterdoctors(k);
                        //Toast.makeText(,list.toString(),Toast.LENGTH_LONG).show();
                        //Log.i("Bye Bye",k.toString());
                        //done =1;
                    }

                    catch (JSONException e) {

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() {
                    try {
                        return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encodig", mRequestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
                    if (response.statusCode == 200 || response.statusCode == 409) {
                        //registerInterface.success(true);
                    }

                    return super.parseNetworkResponse(response);
                }

            };
            Volley.newRequestQueue(context).add(request);
            //Log.i("Bye Bye 2nd time",list.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
