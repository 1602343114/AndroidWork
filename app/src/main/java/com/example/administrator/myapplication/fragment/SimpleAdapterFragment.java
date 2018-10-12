package com.example.administrator.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.administrator.myapplication.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleAdapterFragment extends Fragment {


    public SimpleAdapterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_adapter, container, false);

        initData();

        initView(view);
        return view;
    }

    private void initView(View view) {
        ListView animalListView = view.findViewById(R.id.animal_list);
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), datas, R.layout.item_simple_adapter,
                new String[]{"img_id", "name", "enter_date"},
                new int[]{R.id.animal_img, R.id.animal_name, R.id.animal_enter_date});
        animalListView.setAdapter(adapter);

    }

    private List<HashMap<String, Object>> datas;

    private void initData() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(R.mipmap.ic_launcher, "狮子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "狗子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "虎子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "马子", new Date()));
        animals.add(new Animal(R.mipmap.ic_launcher, "牛子", new Date()));

        datas = new ArrayList<>();
        for (Animal animal : animals) {
            HashMap<String, Object> tmp = new HashMap<>();
            String enterDate = String.format(Locale.CANADA, "%tF %tT",
                    animal.getEnterDate(), animal.getEnterDate());
            tmp.put("img_id", animal.getImgId());
            tmp.put("name", animal.getName());
            tmp.put("enter_date", enterDate);
            datas.add(tmp);
        }
    }

}
