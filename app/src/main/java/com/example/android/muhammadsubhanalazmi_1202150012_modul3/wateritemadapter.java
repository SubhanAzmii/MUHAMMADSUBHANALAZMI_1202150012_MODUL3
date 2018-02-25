package com.example.android.muhammadsubhanalazmi_1202150012_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Kizuna on 24-Feb-18.
 */


public class wateritemadapter extends  RecyclerView.Adapter<wateritemadapter.ViewHolder> {
    //daftar variable
    private ArrayList<wateritem> mwater;
    private Context mContext;

    //konstruktor untuk mwater dan mContext
    wateritemadapter(Context context, ArrayList<wateritem> waterdata) {
        this.mwater = waterdata;
        this.mContext = context;
    }


    @Override
    public wateritemadapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.menu_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //get current water
        wateritem currentwater = mwater.get(position);
        //membuat Gile untuk mendapatkan img resource untuk holderImg
        Glide.with(mContext).load(currentwater.getImageResource()).into(holder.mImage);
        //inisialisasi textview dengan data
        holder.binto(currentwater);
    }

    @Override
    //pengembalian data untuk mwater
    public int getItemCount() {
        return mwater.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //daftar variable
        private TextView mTitle;
        private TextView mInfo;
        private ImageView mImage;

        //konstruktor untuk view holder
        public ViewHolder(View itemView) {
            super(itemView);

            //inisialisasi textview berdasarkan R.id
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mInfo = (TextView) itemView.findViewById(R.id.infoTitle);
            mImage = (ImageView) itemView.findViewById(R.id.Image);

            //membuat onlcick listener
            itemView.setOnClickListener(this);
        }

        public void binto(wateritem currentwater) {
            //mengisi textview dengan data
            mTitle.setText(currentwater.getTitle());
            mInfo.setText(currentwater.getInfo());
        }

        @Override
        //method untuk onclick listener
        public void onClick(View view) {
            wateritem currentWater = mwater.get(getAdapterPosition());

            Intent detailIntent = new Intent(mContext, DetailActivity.class);

            //daftar item yang ikut di pindah aktifitas
            detailIntent.putExtra("title", currentWater.getTitle());
            detailIntent.putExtra("img_source", currentWater.getImageResource());

            //pindah activity berdasarkan informasi yang di klik
            mContext.startActivity(detailIntent);

        }
    }
}
