package com.james.challenge3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.james.challenge3.databinding.ItemViewBinding

class ListNameAdapter(
    private val listAdapterListener: ListAdapterListener,
) : ListAdapter<Item, ListViewHolder>(ListDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            itemViewBinding = ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
            listAdapterListener,
        )
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}