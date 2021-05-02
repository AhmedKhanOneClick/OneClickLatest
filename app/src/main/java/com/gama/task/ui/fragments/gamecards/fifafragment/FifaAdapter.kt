package com.gama.task.ui.fragments.gamecards.fifafragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemAdapter
import com.gama.task.ui.fragments.giftcards.careemfragment.CareemData
import kotlinx.android.synthetic.main.card_fifa_item.view.*

class FifaAdapter (private val fifaList: List<FifaData>):
    RecyclerView.Adapter<FifaAdapter.FifaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FifaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_fifa_item,
            parent, false)
        return FifaViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: FifaViewHolder, position: Int) {
        val currentItem = fifaList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = fifaList.size

    class FifaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value_1
        val textView2: TextView = itemView.card_value_2
        val textView3: TextView = itemView.card_value_3
        val textView4: TextView = itemView.card_value_4
    }

}