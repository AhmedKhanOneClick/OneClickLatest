package com.gama.task.ui.fragments.voicedatacharg.gofragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R

class GoAdapter (private val GoList:List<String>):RecyclerView.Adapter <GoAdapter.GoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_go_item,parent,false)
    return  GoViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: GoViewHolder, position: Int) {
val currentItem=GoList[position]


    }

    override fun getItemCount()=GoList.size

    class GoViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
}