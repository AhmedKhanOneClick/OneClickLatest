package com.gama.task.ui.fragments.cinemacards.kitaabsawti

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import kotlinx.android.synthetic.main.card_kitaabsawti_item.view.*


class KitaabsawtiAdapter (private val KitaabsawtiList: List<KitaabsawtiData>):
    RecyclerView.Adapter<KitaabsawtiAdapter.KitaabsawtiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitaabsawtiViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_kitaabsawti_item,
            parent, false)
        return KitaabsawtiViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: KitaabsawtiViewHolder, position: Int) {
        val currentItem = KitaabsawtiList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = KitaabsawtiList.size

    class KitaabsawtiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
    }

}