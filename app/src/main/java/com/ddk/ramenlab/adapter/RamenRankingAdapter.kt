package com.ddk.ramenlab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ddk.ramenlab.R
import com.ddk.ramenlab.data.RamenData


class RamenRankingAdapter : RecyclerView.Adapter<RamenRankingAdapter.RamenRankingViewHolder>() {

    private val dataset = RamenData.ranking

    /**
     * Initialize view elements
     */
    class RamenRankingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ranking: TextView = view.findViewById(R.id.ramen_ranking_item_ranking)
        val name: TextView = view.findViewById(R.id.rament_ranking_item_name)
        val image: ImageView = view.findViewById(R.id.ramen_ranking_item_image)
        val share: TextView = view.findViewById(R.id.rament_ranking_item_share)
    }

    /**
     * Create new views
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RamenRankingViewHolder {
        // Create a new view, which defines the UI of the list item
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.ramen_ranking_item, parent, false)

        return RamenRankingViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view
     */
    override fun onBindViewHolder(holder: RamenRankingViewHolder, position: Int) {
        val item = dataset[position + 3]

        holder.ranking.text = "#${position + 4}"
        holder.name.text = item.name
        holder.image.setImageResource(item.imageResourceId)
        holder.share.text = "${item.share}%"
    }

    /**
     * Return the size of your dataset
     */
    override fun getItemCount() = dataset.size - 3
}
