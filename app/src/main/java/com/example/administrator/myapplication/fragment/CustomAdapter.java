package com.example.administrator.myapplication.fragment;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myapplication.R;


import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<Animal> mAnimals;
    private Context mContext;

    public CustomAdapter(Context context, List<Animal> animals) {
        this.mAnimals = animals;
        this.mContext = context;

    }

    @Override
    public int getCount() {
        return mAnimals.size();
    }

    @Override
    public Object getItem(int position) {
        return mAnimals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_simple_adapter, null);
            viewHolder = new ViewHolder();
            viewHolder.animalImg = view.findViewById(R.id.animal_img);
            viewHolder.animalName = view.findViewById(R.id.animal_name);
            viewHolder.animalEnterDate = view.findViewById(R.id.animal_enter_date);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Animal animal = mAnimals.get(position);
        viewHolder.animalImg.setImageResource(animal.getImgId());
        viewHolder.animalName.setText(animal.getName());
        viewHolder.animalEnterDate.setText(DateFormat.format("yyyy-MM-dd EEEE hh:mm", animal.getEnterDate()));
        return view;
    }

    class ViewHolder {
        ImageView animalImg;
        TextView animalName;
        TextView animalEnterDate;
    }
}
