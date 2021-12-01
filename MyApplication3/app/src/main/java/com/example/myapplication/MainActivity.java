package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        st = findViewById(R.id.Start);
        //PreCreateDB.copyDB(this);
        //databaseAdapter = new DatabaseAdapter(this);
        //ListView lvContact = findViewById(R.id.lvContact);
        //final SimpleCursorAdapter simpleCursorAdapter = databaseAdapter.populateListViewFromDB();
        //lvContact.setAdapter(simpleCursorAdapter);
        //lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        st.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, questAdapter.class);
                startActivity(intent);
            }
        });
    }
}
