package com.leogigant.dietynov;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter  extends ArrayAdapter<Recipe> {
    private Context context;
    private List<Recipe> dataRecipe = new ArrayList<>();

    public RecipeAdapter(Context context, ArrayList<Recipe> list){
        super(context, 0, list);
        this.context = context;
        this.dataRecipe = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;

        if(row == null){
            row = LayoutInflater.from(context).inflate(R.layout.recipe_list_template, parent, false);
        }

        Recipe currentRecipe = dataRecipe.get(position);

        TextView title = (TextView)row.findViewById(R.id.recipe_title_v);
        TextView time = (TextView)row.findViewById(R.id.recipe_time_total_v);

        if(currentRecipe != null){
            String timeTotal = String.valueOf(currentRecipe.getTimeTotal());

            title.setText(currentRecipe.getTitle());
            time.setText(timeTotal);
        }

        return row;
    }
}
