package com.example.baihoc1.ontap1appkorea.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.baihoc1.ontap1appkorea.Controller.Adapter.DetailApi;
import com.example.baihoc1.ontap1appkorea.Model.Place;
import com.example.baihoc1.ontap1appkorea.Model.PlaceResult;
import com.example.baihoc1.ontap1appkorea.R;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detail extends AppCompatActivity {

    TextView tvTesst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        init();
        getdata();
    }

    private void init() {
        tvTesst = findViewById(R.id.tv_test);

    }

    void getdata(){


        GetListPlacebody getListPlacebody = new GetListPlacebody( 6,  0,  "" );

        //khai bao va khoi tao Retrofit

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(DetailApi.class).getListPlace(getListPlacebody)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        String strjoson = null;
                        try {
                            strjoson = response.body().string();
                            Gson gson = new Gson();
                            PlaceResult placeResult = gson.fromJson(strjoson,PlaceResult.class);

                            Log.d("abc","abc");

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        tvTesst.setText(strjoson);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("abc","abc");

                    }
                });

    }

    class GetListPlacebody {
        int cateID,placeID;
        String searchKey;
        public  GetListPlacebody (int cateID,int placeID, String searchKey){
            this.cateID = cateID;
            this.placeID = placeID;
            this.searchKey = searchKey;
        }
    }

}
