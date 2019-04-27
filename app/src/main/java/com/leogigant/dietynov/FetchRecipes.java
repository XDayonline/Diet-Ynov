package com.leogigant.dietynov;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FetchRecipes extends AsyncTask<Void, Void, Void> {
    public String data = "";
    public RecipeAdapter adapter;

    @Override
    protected Void doInBackground(Void... voids){
        try{
            URL url = new URL("http://dev.audreybron.fr/flux/flux_recettes.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while (line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject dataObj = new JSONObject(data);
            JSONArray dataArray = dataObj.getJSONArray("result");

            ArrayList<Recipe> listRecipe = new ArrayList<Recipe>();

            for(int i=0; i<dataArray.length(); i++){
                JSONObject mySingleData = (JSONObject) dataArray.get(i);
                JSONObject mySingleDataTime = mySingleData.getJSONObject("time");
                JSONObject mySingleDataNutrition = mySingleData.getJSONObject("nutrition");
                JSONArray dataIngredients = mySingleData.getJSONArray("ingredients");
                JSONArray dataSteps = mySingleData.getJSONArray("steps");

                String name = mySingleData.get("title").toString();
                int portions =  Integer.parseInt(mySingleData.get("portions").toString());
                String pictureUrl = mySingleData.get("picture_url").toString();
                int timeTotal = Integer.parseInt(mySingleDataTime.get("total").toString());
                int timePrep = Integer.parseInt(mySingleDataTime.get("prep").toString());
                int timeBaking = Integer.parseInt(mySingleDataTime.get("baking").toString());
                float kcal = Float.valueOf(mySingleDataNutrition.get("kcal").toString());
                float protein = Float.valueOf(mySingleDataNutrition.get("protein").toString());
                float fat = Float.valueOf(mySingleDataNutrition.get("fat").toString());
                float carbohydrate = Float.valueOf(mySingleDataNutrition.get("carbohydrate").toString());
                float sugar = Float.valueOf(mySingleDataNutrition.get("sugar").toString());
                float satFat = Float.valueOf(mySingleDataNutrition.get("sat_fat").toString());
                float fiber = Float.valueOf(mySingleDataNutrition.get("fiber").toString());
                float sodium = Float.valueOf(mySingleDataNutrition.get("sodium").toString());

                ArrayList<RecipeIngredients> ingredientsList = new ArrayList<RecipeIngredients>();
                ArrayList<RecipeSteps> stepsList = new ArrayList<RecipeSteps>();

                for (int j=0; j<dataIngredients.length(); j++){
                    JSONObject mySingleDataIngredients = (JSONObject) dataIngredients.get(i);
                    int quantity = Integer.parseInt(mySingleDataIngredients.get("quantity").toString());
                    String unit = mySingleDataIngredients.get("unit").toString();
                    String nameIngredient = mySingleDataIngredients.get("name").toString();

                    RecipeIngredients myIngredient = new RecipeIngredients(quantity, unit, nameIngredient);
                    ingredientsList.add(myIngredient);
                }

                for(int k=0; k<dataSteps.length(); k++){
                    JSONObject mySingleDataSteps = (JSONObject) dataSteps.get(i);

                    int order = Integer.parseInt(mySingleDataSteps.get("order").toString());
                    String step = mySingleDataSteps.get("step").toString();

                    RecipeSteps myStep = new RecipeSteps(order, step);
                    stepsList.add(myStep);
                }

                Recipe myRecipe = new Recipe(name, portions, pictureUrl, timeTotal, timePrep, timeBaking, ingredientsList,
                        stepsList, kcal, protein, fat, carbohydrate, sugar, satFat, fiber, sodium);

                listRecipe.add(myRecipe);
            }

            Log.i("TEST", "" + MyRecipeActivity.layout);
            adapter = new RecipeAdapter(MyRecipeActivity.layout.getContext(), listRecipe);

        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        MyRecipeActivity.listRecipe.setAdapter(adapter);
    }
}
