package com.ddk.ramenlab.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.ddk.ramenlab.data.ChatReplyData
import com.ddk.ramenlab.databinding.BoardReadChatItemBinding

class ChatReplyAdapter (val context: Context) : BaseAdapter() {

    private val dataset = ChatReplyData.newReply
    private var mBinding : BoardReadChatItemBinding? = null
    private val binding get() = mBinding!!

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        mBinding = BoardReadChatItemBinding.inflate(LayoutInflater.from(context))

        val name : TextView = binding.chatReplyName
        val content : TextView = binding.chatReplyContent

        val user = dataset[position]

        name.text = user.name
        content.text = user.content

        return mBinding!!.root
    }

    override fun getCount(): Int {
        return dataset.size
    }

    override fun getItem(position: Int): Any {
        return dataset[position]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }
}