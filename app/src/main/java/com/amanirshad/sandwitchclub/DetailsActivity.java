package com.amanirshad.sandwitchclub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amanirshad.sandwitchclub.Utils.JSONUtils;
import com.amanirshad.sandwitchclub.model.Sandwitch;

import org.json.JSONException;

public class DetailsActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ImageView ingredients = findViewById(R.id.image);
        TextView mainName= findViewById(R.id.mainName);
        TextView placeOfOrigin = findViewById(R.id.placeOfOrigin);
        TextView description = findViewById(R.id.description);
        TextView alsoKnownAs = findViewById(R.id.alsoKnownAs);
        TextView ingredientsText = findViewById(R.id.ingredients);


        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwitches = getResources().getStringArray(R.array.sandwitch_details);
        String json = sandwitches[position];
        Sandwitch sandwitch = JSONUtils.parseSandwichJson(json);
        if (sandwitch == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }
        Log.v("URL",sandwitch.getImage());
        mainName.setText(sandwitch.getMainName());
        placeOfOrigin.setText(sandwitch.getPlaceOfOrigin());
        description.setText(sandwitch.getDescription());
        for (int i = 0; i <sandwitch.getAlsoKnownAs().length(); i++){

            String space = ", ";
            if (i == sandwitch.getAlsoKnownAs().length()-1){
                space = ""; // to avoid comma at the end
            }
            try {
                alsoKnownAs.append(sandwitch.getAlsoKnownAs().get(i) +space);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        for (int i = 0; i <sandwitch.getIngredients().length(); i++){

            String space = ", ";
            if (i == sandwitch.getIngredients().length()-1){
                space = ""; // to avoid comma at the end
            }
            try {
                ingredientsText.append(sandwitch.getIngredients().get(i).toString()+space);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


        GlideApp.with(this).load(sandwitch.getImage()).into(ingredients);

        setTitle(sandwitch.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }


}

