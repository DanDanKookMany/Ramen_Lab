package com.ddk.ramenlab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ddk.ramenlab.R
import com.ddk.ramenlab.data.RamenData


class NewRamenAdapter : RecyclerView.Adapter<NewRamenAdapter.NewRamenViewHolder>() {

    private val dataset = RamenData.newRamen

    /**
     * Initialize view elements
     */
    class NewRamenViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ramenImage: ImageView = view.findViewById(R.id.ramen_image)
        val ramenName: TextView = view.findViewById(R.id.ramen_name)
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewRamenViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.new_ramen_item, parent, false)

        return NewRamenViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: NewRamenViewHolder, position: Int) {
        val item = dataset[position]

        holder.ramenImage.setImageResource(item.imageResourceId)
        holder.ramenName.text = item.name
    }

    /**
     * Return the size of your dataset
     */
    override fun getItemCount() = dataset.size
}