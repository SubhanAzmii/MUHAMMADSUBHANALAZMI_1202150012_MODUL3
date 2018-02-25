package com.example.android.muhammadsubhanalazmi_1202150012_modul3;

/**
 * Created by Kizuna on 24-Feb-18.
 */

public class wateritem {
    //daftar variable
    private String title;
    private String info;
    private final int imgResources;

    //konstruktor untuk variable sebagai model data
    wateritem(String title, String info, int imgResources){
        this.title = title;
        this.info = info;
        this.imgResources = imgResources;

    }

    //pengambilan data beserta return typenya
    public int getImageResource() {
        return imgResources;
    }

    String getTitle() {
        return title;
    }

    String getInfo() {
        return info;
    }
}
