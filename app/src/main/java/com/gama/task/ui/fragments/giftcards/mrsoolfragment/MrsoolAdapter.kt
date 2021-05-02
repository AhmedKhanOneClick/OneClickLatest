package com.gama.task.ui.fragments.giftcards.mrsoolfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.card_careem_item.view.*

class MrsoolAdapter(private val mrsoolList: List<MrsoolData>):
    RecyclerView.Adapter<MrsoolAdapter.MrsoolViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MrsoolViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_mrsool_item,
            parent, false)
        return MrsoolViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MrsoolViewHolder, position: Int) {
        val currentItem = mrsoolList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = mrsoolList.size

    class MrsoolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
    }

}