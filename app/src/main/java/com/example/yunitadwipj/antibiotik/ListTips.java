package com.example.yunitadwipj.antiobiotik;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.yunitadwipj.antiobiotik.AsyncTask.AdapterList;
import com.example.yunitadwipj.antiobiotik.AsyncTask.AppController;
import com.example.yunitadwipj.antiobiotik.AsyncTask.Helper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ListTips extends Helper {
    private RecyclerView lvberita;

    private ArrayList<HashMap<String, String>> list_data;
    private String tag_json = "tag_json";

    private String url = Helper.BASE_URL + "tips.php";

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tips);
	getSupportActionBar().setTitle("Tips");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pd = new ProgressDialog(this);

        lvberita = (RecyclerView) findViewById(R.id.lvberita);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lvberita.setLayoutManager(linearLayoutManager);

        list_data = new ArrayList<HashMap<String, String>>();

        showData();
    }

    private void showData() {

        pd.setMessage("Loading...");
        pd.setCancelable(false);
        showDialog();

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("RESPONSE ", response.toString());
                hideDialog();
                try {
                    JSONArray jray = response.getJSONArray("data");
                    for (int a = 0; a < jray.length(); a++) {
                        JSONObject json = jray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<>();
                        map.put("id_tips", json.getString("id_tips"));
                        map.put("judul", json.getString("judul"));
                        map.put("deskripsi", json.getString("deskkripsi"));
                        map.put("waktu", json.getString("waktu"));
                        map.put("link", json.getString("link"));
                        map.put("gambar", json.getString("gambar"));
                        list_data.add(map);
                        AdapterList adapter = new AdapterList(ListTips.this, list_data);
                        lvberita.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("ERROR", error.getMessage());
                hideDialog();
            }
        });

        AppController.getAppController().addToRequestQueue(jsonRequest, tag_json);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            //end the activity
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showDialog() {
        if (!pd.isShowing())
            pd.show();
    }

    private void hideDialog() {
        if (pd.isShowing())
            pd.dismiss();
    }
}