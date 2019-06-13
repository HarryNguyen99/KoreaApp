package com.example.baihoc1.ontap1appkorea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Contact extends AppCompatActivity {

    ListView lvSđtKhanCap;
    ArrayList<String> arraySdtKhanCap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_layout);

        lvSđtKhanCap = findViewById(R.id.lv_sdt_khan_cap);
        arraySdtKhanCap = new ArrayList<>();



    }
}
