package com.example.android.muhammadsubhanalazmi_1202150012_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    //daftar variable
    TextView wTitle, wliter;
    ImageView wImager, wbattery;
    private int liter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //inisialisasi berdasarkan R.od
        wTitle = (TextView) findViewById(R.id.titleDetail);
        wImager = (ImageView) findViewById(R.id.ImageDetail);
        wliter = (TextView) findViewById(R.id.liter);
        wbattery = (ImageView) findViewById(R.id.battery);

        //mengambil intern pada activitas sebelumnya
        wTitle.setText(getIntent().getStringExtra("title"));
        Glide.with(this).load(getIntent().getIntExtra("img_source", 0)).into(wImager);
        //memanggil operasi untuk method botol
        botol();

    }

    //method untuk operasi kondisi botol
    private void botol() {
        if (liter==0){

            wliter.setText("1L");
            wbattery.setImageResource(R.drawable.ic_battery_20);
            Toast.makeText(this,"Air Sedikit", Toast.LENGTH_SHORT).show();
        }
        else if (liter==1){
            wliter.setText("2L");
            wbattery.setImageResource(R.drawable.ic_battery_50);

        }
        else if (liter==2){
            wliter.setText("3L");
            wbattery.setImageResource(R.drawable.ic_battery_60);

        }
        else if (liter==3){
            wliter.setText("4L");
            wbattery.setImageResource(R.drawable.ic_battery_80);
            ;
        }
        else if (liter==4){
            wliter.setText("5L");
            wbattery.setImageResource(R.drawable.ic_battery_90);

        }
        else if (liter==5){
            wliter.setText("6L");
            wbattery.setImageResource(R.drawable.ic_battery_full);
            Toast.makeText(this,"Air Sudah Penuh", Toast.LENGTH_SHORT).show();
        }

    }

    //method onclick listener untuk penambahan liter pengisian pada botol
    public void plus(View view) {
        liter++;
        botol();
    }

    //method onclick listener untuk pengurangan liter pengisian pada botol
    public void min(View view) {
        liter--;
        botol();
    }
}
