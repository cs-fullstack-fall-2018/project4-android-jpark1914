package com.example.student.recipebook;

import android.widget.ImageView;

class RecipeBook {
     private final int image;
     private String recipeName;
     private String description;
     private String date;
     private String ingredients;
     private String instruction;

     RecipeBook(int image, String recipeName, String description, String date, String ingredients, String instruction){
         this.recipeName = recipeName;
         this.image = image;
         this. description = description;
         this.date = date;
         this.ingredients = ingredients;
         this.instruction = instruction;
     }

     int getImage() {return image;}
     String getRecipeName() {return recipeName;}
     String getDescription() {return  description;}
     String getDate() {return date;}
     String getIngredients() {return ingredients;}
     String getInstruction() {return instruction;}


}
