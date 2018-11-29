package com.example.student.recipebook;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<RecipeBook> mRecipeData;
    private RecipeAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecipeData = new ArrayList<>();

        mAdapter = new RecipeAdapter(this, mRecipeData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        TypedArray image = getResources().obtainTypedArray(R.array.image);
        String[] recipeName = getResources().getStringArray(R.array.recipeName);
        String[] description = getResources().getStringArray(R.array.description);
        String[] date = getResources().getStringArray(R.array.date);
        String[] ingredients  =getResources().getStringArray(R.array.ingredients);
        String[] instruction = getResources().getStringArray(R.array.instruction);

        mRecipeData.clear();

        for(int i=0; i < recipeName.length; i++){
            mRecipeData.add(new RecipeBook(image.getResourceId(i,0),recipeName[i], description[i], date[i], ingredients[i], instruction[i]));
        }
        image.recycle();
        mAdapter.notifyDataSetChanged();
    }
}
