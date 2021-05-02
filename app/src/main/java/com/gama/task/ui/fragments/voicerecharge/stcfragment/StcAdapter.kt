package com.gama.task.ui.fragments.voicerecharge.stcfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiAdapter
import com.gama.task.ui.fragments.voicedatacharg.friendfragment.FriendiData
import kotlinx.android.synthetic.main.card_stc_item2.view.*

class StcAdapter (private val stcList: List<StcData>):
    RecyclerView.Adapter<StcAdapter.StcViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StcViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_stc_item2,
            parent, false)
        return StcViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: StcViewHolder, position: Int) {
        val currentItem = stcList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = stcList.size

    class StcViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
    }

}