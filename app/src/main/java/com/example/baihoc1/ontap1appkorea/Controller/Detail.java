package com.example.baihoc1.ontap1appkorea.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baihoc1.ontap1appkorea.R;

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

    void getdata() {


        GetListPromotionBody getListPromotionBody = new GetListPromotionBody(0, 0, "");

        //khai bao va khoi tao Retrofit

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(Api.class).getListPlace(getListPromotionBody)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(Detail.this, "ok", Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(Detail.this, "cuc xi lau", Toast.LENGTH_SHORT).show();

                    }
                });

    }

    class GetListPromotionBody {
        int cateID, placeID;
        String searchKey;

        public GetListPromotionBody(int cateID, int placeID, String searchKey) {
            this.cateID = cateID;
            this.placeID = placeID;
            this.searchKey = searchKey;
        }
    }

}
