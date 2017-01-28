package com.example.student.newsreader.concern;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ohgi on 2016/12/17.
 */

public interface  QiitaAPI{
    /** 記事一覧の取得 */
    //@GET("/api/v2/items?query=ゆゆ式&per_page=5")
    @GET("/api/v2/items")
    Call<ArrayList<QiitaResponse>> getItems(//@Query("query") String query,
                                            @Query("page") Integer page,
                                            @Query("per_page") Integer per_page);
//    void getItems(@Query("query") String query,
//                  @Query("per_page") Integer per_page,
//                  Callback<ArrayList<QiitaResponse>> callback);
}
