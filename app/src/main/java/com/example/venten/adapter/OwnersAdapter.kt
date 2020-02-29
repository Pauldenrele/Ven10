package com.example.venten.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.venten.models.CarOwners
import com.example.venten.databinding.ItemCarOwnersBinding




class OwnersAdapter :
    ListAdapter<CarOwners, OwnersAdapter.ViewHolder>(OwnersAdapter.LecturerDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OwnersAdapter.ViewHolder {
        return OwnersAdapter.ViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item!!)
    }

    // binding.root is the root view of the layout, in this case the constraint layout
    class ViewHolder private constructor(val binding: ItemCarOwnersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CarOwners) {
            binding.carOwners = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCarOwnersBinding.inflate(
                    layoutInflater
                    , parent, false
                )
                return ViewHolder(binding)
            }
        }

    }


    class LecturerDiffCallBack : DiffUtil.ItemCallback<CarOwners>() {
        override fun areItemsTheSame(oldItem: CarOwners, newItem: CarOwners): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CarOwners, newItem: CarOwners): Boolean {
            return oldItem == newItem
        }
    }


}