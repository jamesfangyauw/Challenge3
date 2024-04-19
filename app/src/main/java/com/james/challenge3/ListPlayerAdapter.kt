package com.james.challenge3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.james.challenge3.databinding.ItemViewBinding

class ListPlayerAdapter(
    private val listAdapterListener: ListPlayerListener,
) : ListAdapter<Player, ListPlayerHolder>(ListPlayerDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPlayerHolder {
        return ListPlayerHolder(
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

    override fun onBindViewHolder(holder: ListPlayerHolder, position: Int) {
        holder.bind(getItem(position))
    }
}