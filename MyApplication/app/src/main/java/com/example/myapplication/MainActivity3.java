package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class MainActivity3 extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);
        }

    public void voltarTela1(View view){
        Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent4);
    }

    public void irParaTela4(View view){
        Intent intent5 = new Intent(getApplicationContext(), MainActivity4.class);
        startActivity(intent5);
    }



}
