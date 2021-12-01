package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    BD d;
    Quest getdata;
    auth logDB;
    private static Context context;
    Button st,sw,au,Re;
    private TextView Stud,fir,sec,Guy,Key,Password2,login,Password,Nick,keys;
    Button Reg,log,ex,b,b1;
    String allow = "-1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getdata= new Quest();
        MainActivity.context = getApplicationContext();
        logDB =new auth(MainActivity.this);
        setContentView(R.layout.activity_main);
        st = findViewById(R.id.Start);
        sw = findViewById(R.id.ADDDDD);
        au = findViewById(R.id.au);
        Re = findViewById(R.id.Re);
        ex = findViewById(R.id.ex);
        d = new BD(this);
        sw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                allow=logDB.getk();
                if (allow.equals("admin")) {
                    showDialog();
                }else {
                    Toast.makeText(context, "У вас недостаточно прав", Toast.LENGTH_SHORT).show();
                }
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                allow=logDB.getk();
                if (!allow.equals("-1")) {
                    Intent intent;
                    intent = new Intent(MainActivity.this, questAdapter.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(context, "Войдите для прохождения", Toast.LENGTH_SHORT).show();
                }
            }
        });
        au.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                Auth();
            }
        });
        Re.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                Registration();
            }
        });
        ex.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                allow="0";
                logDB.setData();
                au.setVisibility(View.VISIBLE);
                ex.setVisibility(View.GONE);
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
        q = dialog.findViewById(R.id.login);
        q1 = dialog.findViewById(R.id.Password);
        q2 = dialog.findViewById(R.id.q2);
        q3 = dialog.findViewById(R.id.q3);
        q4 = dialog.findViewById(R.id.q4);
        ri = dialog.findViewById(R.id.ri);
        Nick = findViewById(R.id.Nick);
        add = (Button)dialog.findViewById(R.id.log);
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

    public void Registration() {
        System.out.println("открыт");
        final EditText q, q1, q2, q3, q4, ri;
        Button close, add, b;
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        dialog.setContentView(R.layout.dialogreg);
        params.copyFrom(dialog.getWindow().getAttributes());
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        close = (Button) dialog.findViewById(R.id.close);

        Key = dialog.findViewById(R.id.Key);
        log = dialog.findViewById(R.id.log);
        Reg = dialog.findViewById(R.id.Reg);
        login = dialog.findViewById(R.id.login);
        Password = dialog.findViewById(R.id.Password);
        Password2 = dialog.findViewById(R.id.Password2);

        close.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        Reg.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                if (login.getText().toString().isEmpty()) {
                    login.setError("Введите логин");
                }else if(Password.getText().toString().isEmpty()) {
                    Password.setError("Введите пароль");
                }else if(!Password2.getText().toString().equals(Password.getText().toString())) {
                    Password2.setError("Пароли не совпадают");
                }else {
                    logDB.addUser(login.getText().toString(),Password.getText().toString(),Key.getText().toString());
                    dialog.cancel();
                }
            }
        });
    }
    public void Auth() {
        final EditText q, q1, q2, q3, q4, ri;
        Button close, add, b;
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams();
        dialog.setContentView(R.layout.dialoglog);
        params.copyFrom(dialog.getWindow().getAttributes());
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.gravity = Gravity.CENTER;
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        close = (Button) dialog.findViewById(R.id.close);

        b = dialog.findViewById(R.id.Reg);


        Key = dialog.findViewById(R.id.Key);
        log = dialog.findViewById(R.id.log);
        Reg = dialog.findViewById(R.id.Reg);
        login = dialog.findViewById(R.id.login);
        Password = dialog.findViewById(R.id.Password);
        Password2 = dialog.findViewById(R.id.Password2);

        close.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        log.setOnClickListener(new View.OnClickListener() {;
            @Override
            public void onClick(View v) {
                if (login.getText().toString().isEmpty()) {
                    login.setError("Введите логин");
                }else if(Password.getText().toString().isEmpty()) {
                    Password.setError("Введите пароль");
                }else {
                    int temp = logDB.auth(login.getText().toString(), Password.getText().toString());
                    if (temp==0) {
                        au.setVisibility(View.GONE);
                        ex.setVisibility(View.VISIBLE);
                        //Nick.setText(login.getText());
                        dialog.cancel();
                    }
                }
            }
        });
    }
}
