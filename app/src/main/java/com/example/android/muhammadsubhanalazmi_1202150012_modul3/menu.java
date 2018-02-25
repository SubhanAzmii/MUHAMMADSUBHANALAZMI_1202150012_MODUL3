package com.example.android.muhammadsubhanalazmi_1202150012_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class menu extends AppCompatActivity {

    //daftar variable
    private RecyclerView mRecView;
    private ArrayList<wateritem> mwateritems;
    private wateritemadapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //inisialisasi view pada R.id
        mRecView = (RecyclerView) findViewById(R.id.recyclerView);

        //mengeset layout pada recycleview
        mRecView.setLayoutManager(new LinearLayoutManager(this));

        //inisialisasi array pada variable
        mwateritems = new ArrayList<>();

        //inisialisasi adapater dan mengeset adapter pada recycleview
        madapter = new wateritemadapter(this, mwateritems);
        mRecView.setAdapter(madapter);

        //pengambilan data
        initializeData();

        //inisialisasi resource untuk gridColumnCount
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        //mengeset laypout berdasarkan resource pada recycleview
        mRecView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
    }

    private void initializeData() {
        //mengambil data resource array pada strings.xml
        String[] waterdata = getResources().getStringArray(R.array.water);
        String[] waterinfo = getResources().getStringArray(R.array.water_Desc);
        TypedArray WaterImgResources = getResources().obtainTypedArray(R.array.water_img);

        //menghapus data yang terjadi duplikasi
        mwateritems.clear();

        //membuat daftar array
        for (int i=0;i<waterdata.length;i++){
            mwateritems.add(new wateritem(waterdata[i],waterinfo[i], WaterImgResources.getResourceId(i,0)));
        }
        //notifikasi perubahan data
        madapter.notifyDataSetChanged();


        WaterImgResources.recycle();
    }
}
