package com.example.student.recipebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private ArrayList<RecipeBook> mRecipeData;
    private Context mContext;

    RecipeAdapter(Context context, ArrayList<RecipeBook> recipeData){
        this.mRecipeData = recipeData;
        this.mContext = context;
    }

    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.recipe_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(RecipeAdapter.ViewHolder holder, int position) {
        RecipeBook currentRecipeBook = mRecipeData.get(position);
        holder.bindTo(currentRecipeBook);
    }

    @Override
    public int getItemCount() {return mRecipeData.size();}

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mRecipeNameView;
        private TextView mDescriptionView;
        private TextView mDateView;
        private TextView mIngredientsView;
        private TextView mInstructionView;
        ViewHolder(View itemView){
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            mRecipeNameView = (TextView) itemView.findViewById(R.id.recipeNameView);
            mDescriptionView = (TextView) itemView.findViewById(R.id.descriptionView);
            mDateView = (TextView) itemView.findViewById(R.id.dateView);
            mIngredientsView = (TextView) itemView.findViewById(R.id.ingredientsView);
            mInstructionView = (TextView) itemView.findViewById(R.id.instructionView);
        }

        void bindTo(RecipeBook currentRecipeBook) {
            mRecipeNameView.setText(currentRecipeBook.getRecipeName());
            mDescriptionView.setText(currentRecipeBook.getDescription());
            mDateView.setText(currentRecipeBook.getDate());
            mIngredientsView.setText(currentRecipeBook.getIngredients());
            mInstructionView.setText(currentRecipeBook.getInstruction());


        }
    }
}
