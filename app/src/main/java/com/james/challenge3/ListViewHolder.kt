package com.james.challenge3

import androidx.recyclerview.widget.RecyclerView
import com.james.challenge3.databinding.ItemViewBinding

class ListViewHolder (
    private val itemViewBinding: ItemViewBinding,
    private val listAdapterListener : ListAdapterListener,
) : RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bind(data: Item) {
        itemViewBinding.name.text = data.name
        itemViewBinding.root.setOnClickListener { listAdapterListener.onClickItem(data) }
    }
}
