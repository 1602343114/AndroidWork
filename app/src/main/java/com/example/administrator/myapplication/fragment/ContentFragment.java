package com.example.administrator.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.List;


public class ContentFragment extends Fragment {
    private List<String> weeks;

    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.fragment_content, container, false);
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        initData();
        ListView contentList = view.findViewById(R.id.content_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                weeks);
        contentList.setAdapter(adapter);
        //每个item的点击事件的监听与处理
        contentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String week = (String) parent.getItemAtPosition(position);
                Toast.makeText(ContentFragment.this.getActivity(), week, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void initData() {
        weeks = new ArrayList<>();
        weeks.add("周一");
        weeks.add("周二");
        weeks.add("周三");
        weeks.add("周四");
        weeks.add("周五");
        weeks.add("周六");
        weeks.add("周日");
    }
}
