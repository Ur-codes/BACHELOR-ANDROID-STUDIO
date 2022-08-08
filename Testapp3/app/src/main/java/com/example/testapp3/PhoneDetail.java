package com.example.testapp3;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.testapp3.objects.PhoneFav;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PhoneDetail extends AppCompatActivity {


    @Override
    public void onCreate( Bundle savedInstanceState)    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.detailphone);

        TextView tv1 = findViewById(R.id.phone_name2);
        TextView tv2 = findViewById(R.id.phone_os);
        ImageView iv1 = findViewById(R.id.IV2);

        RequestQueue requestQueue3 = Volley.newRequestQueue(PhoneDetail.this);
        String url3 = getIntent().getStringExtra("url3");

        StringRequest stringRequest3 = new StringRequest(Request.Method.GET, url3, new Response.Listener<String>() {
            @Override
            public void onResponse(String response3) {
                Log.d("APPEL HTTP3",response3);


                try
                {

                    JSONObject jsonObject3 = new JSONObject(response3);
                    JSONObject jsonObject4 = jsonObject3.getJSONObject("data");
                    JSONArray image = jsonObject4.getJSONArray("phone_images");



                        tv1.setText(jsonObject4.getString("phone_name"));
                        tv2.setText(jsonObject4.getString("os"));
                    Picasso.get().load(image.getString(0)).into(iv1);
                    setTitle(jsonObject4.getString("phone_name"));



                  //  DetailAdaptateur detailAdaptateur = new DetailAdaptateur(ld,PhoneDetail.this);


                }catch (Exception o)
                {
                    o.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(PhoneDetail.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue3.add(stringRequest3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(PhoneDetail.this);
        inflater.inflate(R.menu.menu_detail,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.button_ring_phone:
                savePhone();
                break;
            default:
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    public void savePhone(){
        PhoneFav pf = new PhoneFav(getIntent().getStringExtra("slug"),getTitle().toString());
        DBPhone db = new DBPhone(PhoneDetail.this);
        db.open();
        db.insertFavori(pf);
        db.close();
    }
}
