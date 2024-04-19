package com.james.challenge3

import androidx.recyclerview.widget.RecyclerView
import com.james.challenge3.databinding.ItemViewBinding

class ListPlayerHolder (
    private val itemViewBinding: ItemViewBinding,
    private val listAdapterListener : ListPlayerListener,
) : RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bind(data: Player) {
        itemViewBinding.name.text = data.name
        itemViewBinding.root.setOnClickListener { listAdapterListener.onClickItem(data) }
    }
}