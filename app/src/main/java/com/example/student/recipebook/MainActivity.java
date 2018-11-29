package com.example.student.recipebook;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<RecipeBook> mRecipeData;
    private RecipeAdapter mAdapter;
    private String mWebsiteEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecipeData = new ArrayList<>();

        mAdapter = new RecipeAdapter(this, mRecipeData);
        mRecyclerView.setAdapter(mAdapter);
        mWebsiteEditText = (String) "http://www.jpdevelops.com";

        initializeData();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.recipe_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "My Site", Toast.LENGTH_SHORT).show();
                openWebsite();
                break;
            case R.id.item2:
                Toast.makeText(this, "This App was created in Memphis, TN", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Item 3 Selected", Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
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

    public void openWebsite() {
        // Get the URL text.
        String url = mWebsiteEditText;

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
}
