package com.example.administrator.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomAdapterFragment extends Fragment {


    public CustomAdapterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_custom_adapter, container, false);

        initData();
        initView(view);
        return view;
    }

    private void initView(View view) {
        ListView animalListView = view.findViewById(R.id.animal_list);
        final CustomAdapter adapter = new CustomAdapter(getActivity(), animals);
        animalListView.setAdapter(adapter);

        animalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Animal animal = (Animal) parent.getItemAtPosition(position);

                animal.setName("猴子");
                adapter.notifyDataSetChanged();
            }
        });
    }

    private List<Animal> animals;

    private void initData() {
        animals = new ArrayList<>();
        animals.add(new Animal(R.mipmap.ic_launcher, "狮子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "狗子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "虎子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "马子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "牛子", new Date()));

    }

}
