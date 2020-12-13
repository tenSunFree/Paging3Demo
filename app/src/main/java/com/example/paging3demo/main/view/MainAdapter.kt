package com.example.paging3demo.main.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3demo.R
import com.example.paging3demo.databinding.ItemMainBinding
import com.example.paging3demo.databinding.ItemMainSeparatorBinding
import com.example.paging3demo.main.model.MainCommentsModel
import com.example.paging3demo.main.model.id

class MainAdapter :
    PagingDataAdapter<MainCommentsModel, RecyclerView.ViewHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<MainCommentsModel>() {
            override fun areItemsTheSame(
                oldItem: MainCommentsModel, newItem: MainCommentsModel
            ): Boolean {
                return (oldItem is MainCommentsModel.CommentsItem &&
                        newItem is MainCommentsModel.CommentsItem &&
                        oldItem.id == newItem.id) ||
                        (oldItem is MainCommentsModel.SeparatorItem &&
                                newItem is MainCommentsModel.SeparatorItem &&
                                oldItem.description == newItem.description)
            }

            override fun areContentsTheSame(
                oldItem: MainCommentsModel, newItem: MainCommentsModel
            ): Boolean =
                oldItem == newItem
        }
    }

    class MovieViewHolder(val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root)

    class MovieSeparatorViewHolder(val binding: ItemMainSeparatorBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_main -> {
                MovieViewHolder(
                    ItemMainBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            else -> {
                MovieSeparatorViewHolder(
                    ItemMainSeparatorBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model: MainCommentsModel = getItem(position)!!
        model.let {
            when (model) {
                is MainCommentsModel.CommentsItem -> {
                    val viewHolder = holder as MovieViewHolder
                    viewHolder.binding.textViewId.text =
                        "ID: ${model.item.id}"
                    viewHolder.binding.textViewEmail.text =
                        "Email: ${model.item.email}"
                }
                is MainCommentsModel.SeparatorItem -> {
                    val viewHolder = holder as MovieSeparatorViewHolder
                    viewHolder.binding
                        .separatorDescription.text = model.description
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MainCommentsModel.CommentsItem -> R.layout.item_main
            is MainCommentsModel.SeparatorItem -> R.layout.item_main_separator
            null -> throw UnsupportedOperationException("Unknown view")
        }
    }
}