package com.example.testapp3;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.testapp3.objects.Slug;
import com.example.testapp3.objects.SlugAdaptateur;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SlugByBrand extends AppCompatActivity {

    private ListView lv2;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.slugbybrand);

        lv2 = findViewById(R.id.listview2);

        RequestQueue requestQueue2 = Volley.newRequestQueue(SlugByBrand.this);
        String url2 = getIntent().getStringExtra("url2");



        StringRequest stringRequest2 = new StringRequest(Request.Method.GET, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response2) {
                Log.d("APPEL HTTP2",response2);
                List<Slug> ls = new ArrayList<>();
                try
                {

                    JSONObject jsonObject2 = new JSONObject(response2);
                    JSONObject jsonObject3 = jsonObject2.getJSONObject("data");
                    JSONArray phones = jsonObject3.getJSONArray("phones");
                    for ( int compt2 = 0; compt2<phones.length();compt2++)
                    {
                        JSONObject currentjson2 = phones.getJSONObject(compt2);
                        Slug phone = new Slug();
                        phone.setBrand(currentjson2.getString("image"));
                        phone.setPhone_name(currentjson2.getString("phone_name"));
                        phone.setSlug(currentjson2.getString("slug"));
                        ls.add(phone);
                    }
                    SlugAdaptateur slugAdaptateur = new SlugAdaptateur(ls,SlugByBrand.this);
                    lv2.setAdapter(slugAdaptateur);
                    lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent in2 = new Intent(SlugByBrand.this,PhoneDetail.class);
                            String url3 = "https://api-mobilespecs.azharimm.site/v2/"+ls.get(i).getSlug();
                            String slug = ls.get(i).getSlug();
                            in2.putExtra("url3",url3);
                            in2.putExtra("slug",slug);

                            startActivity(in2);
                        }
                    });
                }
                catch (Exception a)
                {
                    a.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                    Toast.makeText(SlugByBrand.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue2.add(stringRequest2);
    }
}
