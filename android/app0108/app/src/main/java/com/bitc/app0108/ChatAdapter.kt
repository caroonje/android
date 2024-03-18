package com.bitc.app0108

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitc.app0108.databinding.ItemChatBinding

class ChatAdapter(val items: MutableList<ChatData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return ChatViewHolder(ItemChatBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun getItemCount(): Int {
    return items.size
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    val bind = (holder as ChatViewHolder).binding
    bind.tvChatName.text = items[position].userName
    bind.tvChatMsg.text = items[position].userMsg
    bind.tvChatTime.text = items[position].userTime
  }
}










