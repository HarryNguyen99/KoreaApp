package com.example.baihoc1.ontap1appkorea.Controller.Adapter;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DetailApi {
    //Khai baos: ten api, kieu,du lieu truyen len, du lieu tra ve

    @POST("Service/GetListPlace")
    Call<ResponseBody> getListPlace (@Body Object object);

}
