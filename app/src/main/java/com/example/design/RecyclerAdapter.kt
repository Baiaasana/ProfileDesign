package com.example.design

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.design.data.Item
import com.example.design.data.listOfItems
import com.example.design.databinding.ActivityItemBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ProfileViewHolder>(){

    inner class ProfileViewHolder(private var binding: ActivityItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        private lateinit var person : Item

        fun bindFunction(){
            person = listOfItems[adapterPosition]
            binding.apply {
                imgStartIcon.setImageResource(person.startIcon)
                tvText.text = person.text
                imgEndIcon.setImageResource(person.endIcon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        return ProfileViewHolder(
            ActivityItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.bindFunction()
    }

    override fun getItemCount(): Int {
        return listOfItems.size
    }

}