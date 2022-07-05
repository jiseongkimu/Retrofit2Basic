package org.techtown.retrofit2basic

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.techtown.retrofit2basic.databinding.ItemViewBinding

class Adapter() : RecyclerView.Adapter<Adapter.ViewHolder>(){
    private var listItems : List<DataClass> ?= null

    fun submitList(list : List<DataClass>){
        listItems = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {
        val itemViewBinding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemViewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        listItems?.get(position)?.let{holder.bind(it)}
    }

    override fun getItemCount(): Int {
        return listItems?.size ?: 0
    }

    class ViewHolder(
        private val binding : ItemViewBinding
        ) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: DataClass){
            //  binding.data = item
        }
    }
}