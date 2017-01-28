package com.example.student.newsreader.Dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by teacher on 2016/05/28.
 */
public class NewsDto {
    private int id;
    private String name;
    private Date date;

    public void setDate(Date d){
        date = d;
    }

    public String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd H:mm:s");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        return format.format(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
