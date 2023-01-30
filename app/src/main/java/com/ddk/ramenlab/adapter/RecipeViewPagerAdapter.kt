package com.ddk.ramenlab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ddk.ramenlab.R
import com.ddk.ramenlab.data.recipeImageData

class RecipeViewPagerAdapter: RecyclerView.Adapter<RecipeViewPagerAdapter.RecipeViewPagerViewHolder>(){
    private val dataset = recipeImageData.newRecipeImg

    class RecipeViewPagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.recipe_item_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewPagerViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.board_read_img_item, parent, false)

        return RecipeViewPagerViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: RecipeViewPagerViewHolder, position: Int) {
        val item = dataset[position]

        holder.image.setImageResource(item.recipeImageResourceId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}