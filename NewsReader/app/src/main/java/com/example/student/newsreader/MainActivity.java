package com.example.student.newsreader;

import android.app.Fragment;
import android.content.ClipData;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.student.newsreader.adapters.ItemsAdapter;
import com.example.student.newsreader.concern.ItemFragment;
import com.example.student.newsreader.concern.ItemFragmentStatePagerAdapter;
import com.example.student.newsreader.concern.QiitaAPI;
import com.example.student.newsreader.concern.QiitaResponse;
import com.example.student.newsreader.concern.QiitaService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;

    /*
    @InjectView(R.id.items_list)
    ListView mItemsList;
    */

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

//  final String[] foods = {"hoge", "fuga", "piyo"};
//  ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);

//  mItemsList.setAdapter(arrayAdapter);

        getItems();

        // リストリフレッシュスワイプのリスナーを登録
        initSwipeRefresh();
    }


    /**
     * リストリフレッシュスワイプのリスナーを登録用メソッド
     */
    private void initSwipeRefresh(){
        // mSwipeRefresh.setColorSchemeResources("#4DD0E1", "#00ACC1","#006064");
        mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // スワイプ時に実行される
                getItems();

                Toast.makeText(MainActivity.this, "テスト", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void getItems(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://qiita.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        QiitaAPI service = QiitaService.get();
        service.getItems(5).enqueue(new Callback<ArrayList<QiitaResponse>>() {

            @Override
            public void onResponse(Call<ArrayList<QiitaResponse>> call, Response<ArrayList<QiitaResponse>> response) {
                if (mSwipeRefresh.isRefreshing()) {
                    mSwipeRefresh.setRefreshing(false);
                }

                /*
                ArrayList<QiitaResponse> items = response.body();
                ItemsAdapter itemsAdapter = new ItemsAdapter(items, MainActivity.this);
                mItemsList.setAdapter(itemsAdapter);
                */

                mViewPager = (ViewPager)findViewById(R.id.viewPager);

                ArrayList<QiitaResponse> items = response.body();
                FragmentManager fm = getSupportFragmentManager();
                ItemFragmentStatePagerAdapter adapter = new ItemFragmentStatePagerAdapter(fm);
                adapter.addAll(items);

                mViewPager.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<QiitaResponse>> call, Throwable t) {

            }
        });
    }

//    if (mSwipeRefresh.isRefreshing()) {
//        mSwipeRefresh.setRefreshing(false);
//    }
}
