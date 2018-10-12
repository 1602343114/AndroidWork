package com.example.administrator.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.fragment.ContentFragment;
import com.example.administrator.myapplication.fragment.SimpleAdapterFragment;
import com.example.administrator.myapplication.fragment.StaticArrayFragment;

public class ListViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initFragment();
        changeFragment(new StaticArrayFragment());
    }

    private SparseArray<Fragment> fragments;

    public void onClick(View view) {
        changeFragment(fragments.get(view.getId()));

    }

    private void initFragment() {
        fragments = new SparseArray<>();
        fragments.put(R.id.btn_array, new ContentFragment());
        fragments.put(R.id.btn_simple, new SimpleAdapterFragment());
        fragments.put(R.id.btn_custom, new CustomAdapterFragment());
    }

    private void changeFragment(Fragment fragment) {
        //1.获取FragmentManager
        FragmentManager manager = getSupportFragmentManager();
        //2.获取FragmentTransaction
        FragmentTransaction transaction = manager.beginTransaction();
        //3.加载
        transaction.replace(R.id.list_fragment, fragment);
        //4.提交
        transaction.commit();
    }

}
