package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    BD d;
    Quest getdata;
    private static Context context;
    Button st,sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getdata= new Quest();
        MainActivity.context = getApplicationContext();
        setContentView(R.layout.activity_main);
        st = findViewById(R.id.Start);
        sw = findViewById(R.id.ADDDDD);
        d = new BD(this);
        sw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog();
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this, questAdapter.class);
                startActivity(intent);
            }
        });
    }
    public static Context getAppContext() {
        return MainActivity.context;
    }

    public void showDialog() {
        final EditText q,q1,q2,q3,q4,ri;
        Button close,add,b;
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        dialog.setContentView(R.layout.dialog);
        params.copyFrom(dialog.getWindow().getAttributes());
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        q = dialog.findViewById(R.id.qest);
        q1 = dialog.findViewById(R.id.q1);
        q2 = dialog.findViewById(R.id.q2);
        q3 = dialog.findViewById(R.id.q3);
        q4 = dialog.findViewById(R.id.q4);
        ri = dialog.findViewById(R.id.ri);
        add = (Button)dialog.findViewById(R.id.addBD);
        close = (Button) dialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                System.out.println("ABOBA");
                long ABOBA = d.addquest(q.getText().toString(), q1.getText().toString(),q2.getText().toString(),q3.getText().toString(), q4.getText().toString(),ri.getText().toString());
                if (ABOBA==0) {
                    dialog.cancel();
                }
            }
        });
    }
}
