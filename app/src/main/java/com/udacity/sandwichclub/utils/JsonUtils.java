package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Log.i("JSON", json);
        try {
            JSONObject object = new JSONObject(json);
            JSONObject name = object.getJSONObject("name");
            String mainName = name.getString("mainName");
            JSONArray alsoKnownArray = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownNames = new ArrayList<>();
            if (alsoKnownArray.length() > 0) {
                for (int i = 0; i < alsoKnownArray.length(); i++) {
                    alsoKnownNames.add(alsoKnownArray.getString(i));
                }
            }
            String placeOfOrigin = object.getString("placeOfOrigin");
            String description = object.getString("description");
            String image = object.getString("image");
            JSONArray ingredientsArray = object.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();
            if (ingredientsArray.length() > 0) {
                for (int i = 0; i < ingredientsArray.length(); i++) {
                    ingredients.add(ingredientsArray.getString(i));
                }
            }
            return new Sandwich(mainName, alsoKnownNames, placeOfOrigin, description, image, ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
