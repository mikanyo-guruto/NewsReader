package com.example.student.newsreader.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.student.newsreader.Dto.CustomerDto;
import com.example.student.newsreader.Dto.NewsDto;
import com.example.student.newsreader.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by student on 2016/12/10.
 */
public class ReaderAdapter extends BaseAdapter {

        private Context _context;
        private List<NewsDto> _lst;
        private LayoutInflater _layoutInflater;

        public ReaderAdapter(Context context){
            _context = context;
            _lst = new ArrayList<>();
            _layoutInflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        // リストをバインド
        public void add(List<NewsDto> lst){
            for(NewsDto dto : lst){
                _lst.add(dto);
            }
            notifyDataSetChanged();
        }

        public void listClear(){
            _lst.clear();
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return _lst.size();
        }

        @Override
        public Object getItem(int position) {
            return _lst.get(position);
        }

        @Override
        public long getItemId(int position) {
            return _lst.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder = null;
            if(convertView == null){
                convertView = _layoutInflater.inflate(R.layout.news_item,null);
                holder = new Holder();
                holder.txtName = (TextView) convertView.findViewById(R.id.txt_name);
                holder.txtDate = (TextView) convertView.findViewById(R.id.txt_date);
                convertView.setTag(holder);
            }else{
                holder = (Holder) convertView.getTag();
            }

            // 顧客の名前を表示
            holder.txtName.setText(_lst.get(position).getName());
            // 現在日時を表示
            holder.txtDate.setText(_lst.get(position).getDate());

            return convertView;
        }

        private class Holder{
            TextView txtName;
            TextView txtDate;
        }
}

