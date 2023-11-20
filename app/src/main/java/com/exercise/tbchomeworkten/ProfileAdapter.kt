package com.exercise.tbchomeworkten

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewbinding.ViewBinding
import com.exercise.tbchomeworkten.databinding.DarkModeRecyclerviewBinding
import com.exercise.tbchomeworkten.databinding.ItemsRecyclerviewBinding
import com.exercise.tbchomeworkten.databinding.LogoutRecyclerviewBinding

class ProfileAdapter: ListAdapter<Info, ViewHolder>(ChoiceDiffCallback()){

    class ChoiceDiffCallback: DiffUtil.ItemCallback<Info>(){
        override fun areItemsTheSame(oldItem: Info, newItem: Info): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Info, newItem: Info): Boolean {
            return oldItem == newItem
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(ItemType.values()[viewType]){
            ItemType.ARROW -> {
                val binding = ItemsRecyclerviewBinding.inflate(inflater,parent,false)
                InfoViewHolder(binding)
            }
            ItemType.CHECKBOX -> {
                val binding = DarkModeRecyclerviewBinding.inflate(inflater,parent,false)
                InfoViewHolder(binding)
            }
            ItemType.DEFAULT -> {
                val binding = LogoutRecyclerviewBinding.inflate(inflater,parent,false)
                InfoViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (holder is InfoViewHolder){
            holder.bind(item)
        }
    }

    inner class InfoViewHolder(private val binding: ViewBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item: Info){
            when(binding){
                is ItemsRecyclerviewBinding -> {
                    binding.image.setImageResource(item.icon)
                    binding.textDescription.text = item.title
                    binding.AdditionalTV.text = item.additionalTextView
                    binding.arrow.setImageResource(item.arrowIcon)
                }
                is DarkModeRecyclerviewBinding -> {
                    binding.image.setImageResource(item.icon)
                    binding.textDescription.text = item.title
                    binding.switchBtn.isChecked = item.checkboxValue ?: false
                }
                is LogoutRecyclerviewBinding -> {
                    binding.image.setImageResource(item.icon)
                    binding.textView.text = item.title
                }
            }
        }
    }
}