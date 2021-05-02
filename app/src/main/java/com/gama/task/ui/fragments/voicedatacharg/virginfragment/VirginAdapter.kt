package com.gama.task.ui.fragments.voicedatacharg.virginfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.card_virgin_item2.view.*

class VirginAdapter (private val virginList: List<VirginData>):
    RecyclerView.Adapter<VirginAdapter.VirginViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VirginViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_virgin_item2,
            parent, false)
        return VirginViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: VirginViewHolder, position: Int) {
        val currentItem = virginList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = virginList.size

    class VirginViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
    }

}