package com.ddk.ramenlab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ddk.ramenlab.R
import com.ddk.ramenlab.data.BoardData

class BoardListAdapter : RecyclerView.Adapter<BoardListAdapter.BoardListViewHolderClass>() {

    private val dataset = BoardData.newBoard

    class BoardListViewHolderClass(view: View) : RecyclerView.ViewHolder(view) {
        val boardTitle: TextView = view.findViewById(R.id.title)
        val boardContent : TextView = view.findViewById(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardListViewHolderClass {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.board_list_item, parent, false)

        return BoardListViewHolderClass(adapterLayout)
    }

    override fun onBindViewHolder(holder: BoardListViewHolderClass, position: Int) {
        val item = dataset[position]

        holder.boardTitle.text = item.title
        holder.boardContent.text = item.content
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}