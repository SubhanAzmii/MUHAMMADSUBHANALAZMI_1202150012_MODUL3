package com.example.android.muhammadsubhanalazmi_1202150012_modul3;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    //daftar variable
    EditText user,pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //inisialisasi view berdasarkan R.id
        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);
        login=(Button)findViewById(R.id.btnlogin);

    }

    public void login(View view) {
        //get data pada inputan R.id
        String userkey = user.getText().toString();
        String passkey = pass.getText().toString();

        //pengondisian untuk login
        if(userkey.equals("ead")&& passkey.equals("MOBILE") || userkey.equals("aan") && passkey.equals("123") ){
            Toast.makeText(getApplicationContext(),"login Sukses.. Selamat Datang di Toko", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(login.this, menu.class);
            login.this.startActivity(intent);
        }

        else{
           /* AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
            builder.setMessage("Username dan password Salah")
                    .setNegativeButton("retry...", null).create().show();*/
            Toast.makeText(getApplicationContext(),"Username atau Password salah. silahkan ulangi lagi", Toast.LENGTH_LONG).show();
        }

    }
}
