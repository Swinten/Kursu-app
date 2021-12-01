package com.example.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class questAdapter extends AppCompatActivity implements View.OnClickListener {
    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;
    private Question question = new Question();
    private String answer;
    private int questionLength;
    private int num=-1;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        System.out.println();
        random = new Random();
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button) findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);
        tv_question = (TextView) findViewById(R.id.tv_question);
        questionLength = question.getlong();
        NextQuestion(getnext());


    }
    public int getnext(){
        if (num < questionLength) {
            num = num + 1;
        }else{
            num=0;
            return -2;
        }
        return num;
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                if (btn_one.getText().equals(answer)) {
                    Toast.makeText(questAdapter.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    NextQuestion(getnext());
                } else {
                    GameOver();
                }

                break;

            case R.id.btn_two:
                if (btn_two.getText().equals(answer)) {
                    Toast.makeText(questAdapter.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    NextQuestion(getnext());
                } else {
                    GameOver();
                }

                break;

            case R.id.btn_three:
                if (btn_three.getText().equals(answer)) {
                    Toast.makeText(questAdapter.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    NextQuestion(getnext());
                } else {
                    GameOver();
                }

                break;

            case R.id.btn_four:

                if (btn_four.getText().equals(answer)) {
                    Toast.makeText(questAdapter.this, "You Are Correct", Toast.LENGTH_SHORT).show();
                    NextQuestion(getnext());
                } else {
                    GameOver();
                }

                break;
        }
    }

    public void NextQuestion(int num) {
        if(num==-2){
            GameWin();
        }
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));
        answer = question.getCorrectAnswer(num);
    }
    private void GameWin() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(questAdapter.this);
        alertDialogBuilder
                .setMessage("Вы прошли все вопросы")
                .setCancelable(false)
                .setPositiveButton("Начать по новой", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), questAdapter.class));
                    }
                })
                .setNegativeButton("выход", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();
    }

    private void GameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(questAdapter.this);
        alertDialogBuilder
                .setMessage("Конец игры")
                .setCancelable(false)
                .setPositiveButton("По новой", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), questAdapter.class));
                    }
                })
                .setNegativeButton("Выход", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
        alertDialogBuilder.show();
    }
}

