package com.amanirshad.sandwitchclub.model;

import org.json.JSONArray;

import java.util.List;

public class Sandwitch {
    private String mainName;
    private JSONArray alsoKnownAs = null;
    private String placeOfOrigin;
    private String description;
    private String image;
    private JSONArray ingredients = null;

    /**
     * No args constructor for use in serialization
     */
    public Sandwitch() {
    }
    public Sandwitch(String mainName, JSONArray alsoKnownAs, JSONArray ingredients, String placeOfOrigin, String description, String image) {
        this.mainName = mainName;
        this.alsoKnownAs = alsoKnownAs;
        this.placeOfOrigin = placeOfOrigin;
        this.description = description;
        this.image = image;
        this.ingredients = ingredients;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public JSONArray getAlsoKnownAs() {
        return alsoKnownAs;
    }

    public void setAlsoKnownAs(JSONArray alsoKnownAs) {
        this.alsoKnownAs = alsoKnownAs;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public JSONArray getIngredients() {
        return ingredients;
    }

    public void setIngredients(JSONArray ingredients) {
        this.ingredients = ingredients;
    }
}
