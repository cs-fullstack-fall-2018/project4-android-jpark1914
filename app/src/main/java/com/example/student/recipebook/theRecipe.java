package com.example.student.recipebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class theRecipe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_recipe);

        TextView recipeName = findViewById(R.id.recipeNameViewDetail);
        ImageView image = findViewById(R.id.imageViewDetail);
        TextView description = findViewById(R.id.descriptionViewDetail);
        TextView ingredients = findViewById(R.id.ingredientsViewDetail);
        TextView date = findViewById(R.id.dateViewDetail);
        TextView instruction = findViewById(R.id.instructionViewDetail);

        recipeName.setText(getIntent().getStringExtra("recipeName"));
        description.setText(getIntent().getStringExtra("description"));
        ingredients.setText(getIntent().getStringExtra("ingredients"));
        date.setText(getIntent().getStringExtra("date"));
        instruction.setText(getIntent().getStringExtra("instruction"));
        Glide.with(this).load(getIntent().getIntExtra("image",0)).into(image);
    }
}
