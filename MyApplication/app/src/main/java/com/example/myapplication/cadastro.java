package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class cadastro extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

    }



    public void irParaTela5(View view){
        Intent intent2 = new Intent(getApplicationContext(), MainActivity5.class);
        startActivity(intent2);
    }

    public void voltarTela1(View view){
        Intent intent2 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent2);

    }



}
