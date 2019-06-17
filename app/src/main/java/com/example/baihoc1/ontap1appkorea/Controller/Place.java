package com.example.baihoc1.ontap1appkorea.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.PlaceAdapter;
import com.example.baihoc1.ontap1appkorea.Model.PlaceResult;
import com.example.baihoc1.ontap1appkorea.R;
import com.example.baihoc1.ontap1appkorea.Util.UtilDocJson;

import com.google.gson.Gson;

public class Place extends AppCompatActivity {
    RecyclerView rvTaxi;
    com.example.baihoc1.ontap1appkorea.Model.Place result;
    TextView tvChiTiet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_layout);
            init();
            docJson();
            setConfigRvTaxi();
    }

    private void setConfigRvTaxi() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvTaxi.setLayoutManager(linearLayoutManager);
        PlaceAdapter adapter = new PlaceAdapter();
        adapter.setContext(this);
        adapter.setData(result.getPlaceResult());
        rvTaxi.setAdapter(adapter);
        rvTaxi.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));



    }

    private void init() {
        rvTaxi = findViewById(R.id.rv_sdt_taxi);
        tvChiTiet = findViewById(R.id.tv_chi_tiet);

//        tvChiTiet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent chitiet = new Intent(Place.this,Detail.class);
//                startActivity(chitiet);
//
//            }
//        });


    }

    private void docJson() {
        String strPlace = UtilDocJson.loadPlace(this);
        Gson gson = new Gson();
        result = gson.fromJson(strPlace, com.example.baihoc1.ontap1appkorea.Model.Place.class);
    }


}
