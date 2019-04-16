package com.leogigant.dietynov;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WeightAdapter extends ArrayAdapter<Weight> {
    private Context context;
    private List<Weight> weightList = new ArrayList<>();

    public WeightAdapter(Context context, ArrayList<Weight> list){
        super(context, 0, list);
        this.context = context;
        this.weightList = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;

        if(row == null){
            row = LayoutInflater.from(context).inflate(R.layout.weight_list_template, parent, false);
        }

        Weight currentWeight = weightList.get(position);

        TextView date = row.findViewById(R.id.weight_date_v);
        TextView value = row.findViewById(R.id.weight_value_v);

        if(currentWeight != null){
            date.setText(currentWeight.getDate());
            value.setText(Float.toString(currentWeight.getValue()));
        }

        return row;
    }
}
