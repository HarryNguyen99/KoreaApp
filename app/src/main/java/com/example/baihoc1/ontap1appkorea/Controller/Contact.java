package com.example.baihoc1.ontap1appkorea.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.baihoc1.ontap1appkorea.Controller.Adapter.ContactAdapter;
import com.example.baihoc1.ontap1appkorea.R;
import com.example.baihoc1.ontap1appkorea.Util.UtilDocJson;
import com.google.gson.Gson;


public class Contact extends AppCompatActivity {

   RecyclerView rvSdtKhanCap;
   com.example.baihoc1.ontap1appkorea.Model.Contact result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        init();
        docJson();
        setConfigRvSdtKhanCap();

    }

    private void init() {
        rvSdtKhanCap = findViewById(R.id.rv_sdt_khancap);
    }

    private void docJson() {
        String strContact = UtilDocJson.loadContact(this);
        Gson gson = new Gson();
        result = gson.fromJson(strContact, com.example.baihoc1.ontap1appkorea.Model.Contact.class);
    }

    private void setConfigRvSdtKhanCap() {
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvSdtKhanCap.setLayoutManager(linearLayoutManager);
        ContactAdapter adapter = new ContactAdapter();
        adapter.setContext(this);
        adapter.setData(result.getContactresult());
        rvSdtKhanCap.setAdapter(adapter);
        rvSdtKhanCap.addItemDecoration
                (new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));

    }


}
