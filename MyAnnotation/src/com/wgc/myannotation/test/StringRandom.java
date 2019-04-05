package com.wgc.myannotation.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class StringRandom {

    String str = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM0123456789";

    public String getStr(int length) {
        Random random = new Random();

        String substring = str.substring(0,random.nextInt(length * 10));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(substring);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());
        //System.out.println(instance.getTime().getMonth() + 1);

        Date time = GregorianCalendar.getInstance().getTime();
        System.out.println(time);


    }
}

