package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class Question {
    MainActivity FF;
    BD con;
    public ArrayList<Quest> array;
    Context cont = FF.getAppContext();
    Question(){
        con = new BD(FF.getAppContext());
        con.getNotes();
    }
    public int getlong(){
        return con.arrayList.size();
    }
    public String getQuestion(int a){

        String question =con.arrayList.get(a).getName();
        return question;
    }

    public String getchoice1(int a){
        String choice = con.arrayList.get(a).getq1();
        return choice;
    }

    public String getchoice2(int a){
        String choice = con.arrayList.get(a).getq2();
        return choice;
    }

    public String getchoice3(int a){
        String choice = con.arrayList.get(a).getq3();
        return choice;
    }

    public String getchoice4(int a){
        String choice = con.arrayList.get(a).getq4();
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = con.arrayList.get(a).getri();
        return answer;
    }
}
