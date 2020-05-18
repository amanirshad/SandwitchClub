package com.amanirshad.sandwitchclub.Utils;

import com.amanirshad.sandwitchclub.model.Sandwitch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtils {
    public static Sandwitch parseSandwichJson(String json) {

        Sandwitch sandwitch = null;

        try {
            JSONObject obj = new JSONObject(json);
            JSONObject nameObject = new JSONObject(String.valueOf(obj.getJSONObject("name")));
            JSONArray alsoKnownAs = nameObject.getJSONArray("alsoKnownAs");

            JSONArray ingredients = obj.getJSONArray("ingredients");
            String mainName = nameObject.getString("mainName");
            String placeOfOrigin = obj.getString("placeOfOrigin");
            String description = obj.getString("description");
            String image = obj.getString("image");

            sandwitch = new Sandwitch(mainName, alsoKnownAs, ingredients, placeOfOrigin, description, image);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwitch;
    }
}
