package com.gama.task.ui.fragments.voicedatacharg.gofragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.card_go_item2.view.*

class GoAdapter (private val goList: List<GoData>):
    RecyclerView.Adapter<GoAdapter.GoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_go_item2,
            parent, false)
        return GoViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: GoViewHolder, position: Int) {
        val currentItem = goList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = goList.size

    class GoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
    }

}