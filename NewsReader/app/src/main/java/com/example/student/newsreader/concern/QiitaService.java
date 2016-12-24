package com.example.student.newsreader.concern;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ohgi on 2016/12/18.
 */

public class QiitaService {

    static QiitaService INSTANCE;
    final QiitaAPI qiitaApi;

    public QiitaService() {
        this.qiitaApi = new Retrofit.Builder()
            .baseUrl("https://qiita.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QiitaAPI.class);
    }


    public static QiitaAPI get() {
        if(INSTANCE == null){
            INSTANCE = new QiitaService();
        }

        return INSTANCE.qiitaApi;
    }
}