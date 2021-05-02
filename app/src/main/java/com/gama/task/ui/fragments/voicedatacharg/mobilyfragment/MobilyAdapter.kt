package com.gama.task.ui.fragments.voicedatacharg.mobilyfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.card_mobily_item2.view.*

class MobilyAdapter (private val mobilyList: List<MobilyData>):
    RecyclerView.Adapter<MobilyAdapter.MobilyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MobilyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_mobily_item2,
            parent, false)
        return MobilyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MobilyViewHolder, position: Int) {
        val currentItem = mobilyList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = mobilyList.size

    class MobilyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
    }

}