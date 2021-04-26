package com.gama.task.ui.fragments.gamecards.nintendofragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import kotlinx.android.synthetic.main.card_nintendo_item.view.*


class NintendAdapter(private val nintendoList: List<NintendData>) :
        RecyclerView.Adapter<NintendAdapter.NintendoViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NintendoViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_nintendo_item,
                parent, false)
            return NintendoViewHolder(itemView)
        }
        override fun onBindViewHolder(holder: NintendoViewHolder, position: Int) {
            val currentItem = nintendoList[position]

            holder.textView1.text = currentItem.text1
            holder.textView2.text = currentItem.text2
            holder.textView3.text = currentItem.text3
            holder.textView4.text = currentItem.text4
        }
        override fun getItemCount() = nintendoList.size

        class NintendoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView1: TextView = itemView.giga_bytes_tv
            val textView2: TextView = itemView.card_value_tv
            val textView3: TextView = itemView.card_value2_tv
            val textView4: TextView = itemView.card_value3_tv
        }

}