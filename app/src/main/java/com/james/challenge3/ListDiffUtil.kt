package com.james.challenge3

import androidx.recyclerview.widget.DiffUtil

class ListDiffUtil : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name == newItem.name
    }
    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.name == newItem.name
    }
}