package com.example.testapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.testapp3.objects.Brand;
import com.example.testapp3.objects.BrandAdaptateur;
import com.example.testapp3.objects.Slug;
import com.example.testapp3.objects.SlugAdaptateur;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private ListView lv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button1 = findViewById(R.id.B1);
        this.lv1 = findViewById(R.id.listview1);





                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://api-mobilespecs.azharimm.site/v2/brands";


                StringRequest requestString = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("APPEL HTTP",response);
                        List<Brand> lb = new ArrayList<Brand>();
                        try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("data");

                        for(int compt = 0; compt<jsonArray.length();compt++){
                            JSONObject currentjson = jsonArray.getJSONObject(compt);
                            Brand marque = new Brand();
                            marque.setName(currentjson.getString("brand_name"));
                            marque.setBrand_slug(currentjson.getString("brand_slug"));
                            marque.setDevice_count(currentjson.getInt("device_count"));
                            lb.add(marque);
                        }
                            BrandAdaptateur brandAdaptateur = new BrandAdaptateur(lb,MainActivity.this);
                            lv1.setAdapter(brandAdaptateur);
                            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                    Intent in = new Intent(MainActivity.this, SlugByBrand.class);
                                    String url2 = url +"/"+lb.get(i).getBrand_slug();
                                    in.putExtra("url2",url2);

                                    startActivity(in);
                                }
                            });
                        }
                        catch (Exception e){
                            e.printStackTrace();

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                requestQueue.add(requestString);

                this.button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent in3 = new Intent(MainActivity.this,PhoneFavorisActivity.class);
                        startActivity(in3);
                    }
                });
            }

}





