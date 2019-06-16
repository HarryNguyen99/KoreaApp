package com.example.baihoc1.ontap1appkorea.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.PromotionAdapter;
import com.example.baihoc1.ontap1appkorea.Model.PlaceResult;
import com.example.baihoc1.ontap1appkorea.R;
import com.example.baihoc1.ontap1appkorea.Util.UtilDocJson;
import com.google.gson.Gson;

public class Promotion extends AppCompatActivity {

    RecyclerView rvKhachSan;
    com.example.baihoc1.ontap1appkorea.Model.Promotion result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotion_layout);

        init();
        docjson();
        setConfigRv_Khachsan();

    }

    private void setConfigRv_Khachsan() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvKhachSan.setLayoutManager(linearLayoutManager);
        PromotionAdapter adapter = new PromotionAdapter();
        adapter.setContext(this);
        adapter.setData(result.getResult());
        rvKhachSan.setAdapter(adapter);
        rvKhachSan.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    private void docjson() {
        String strPromotion = UtilDocJson.loadPromotion(this);
        Gson gson = new Gson();
        result = gson.fromJson(strPromotion, com.example.baihoc1.ontap1appkorea.Model.Promotion.class);
    }

    private void init() {

        rvKhachSan = findViewById(R.id.rv_khach_san);

    }
}
