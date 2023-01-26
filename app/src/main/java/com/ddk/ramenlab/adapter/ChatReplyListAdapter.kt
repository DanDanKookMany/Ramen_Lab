package com.ddk.ramenlab.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ddk.ramenlab.R
import com.ddk.ramenlab.data.ChatReplyData

class ChatReplyListAdapter : RecyclerView.Adapter<ChatReplyListAdapter.ChatReplyViewHolder>() {

    private val dataset = ChatReplyData.newReply

    class ChatReplyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name : TextView = view.findViewById(R.id.chat_reply_name)
        val content : TextView = view.findViewById(R.id.chat_reply_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatReplyViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.board_read_chat_item, parent, false)
        return ChatReplyViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ChatReplyViewHolder, position: Int) {
        val item = dataset[position]

        holder.name.text = item.name
        holder.content.text = item.content
    }


    override fun getItemCount() = dataset.size
}