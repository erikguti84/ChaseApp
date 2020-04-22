package com.example.chaseapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chaseapp.databinding.RowItemBinding
import com.example.chaseapp.model.SchoolModel

class SchoolAdapter(val listener: (Int) -> Unit) : RecyclerView.Adapter<SchoolAdapter.SchoolViewHolder>(){


    private var dataList: List<SchoolModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder =
        SchoolViewHolder(RowItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val school = dataList.get(position)
        holder.bind.schoolModel = school
        holder.bind.rowLayout.setOnClickListener{listener(position)}
    }

    override fun getItemCount(): Int = dataList.size

    class SchoolViewHolder(binding: RowItemBinding):
        RecyclerView.ViewHolder(binding.root) {val bind = binding}

    fun loadData(data: List<SchoolModel>){
        dataList = data
        notifyDataSetChanged()
    }
}