package com.gama.task.ui.fragments.gamecards.playstationfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import kotlinx.android.synthetic.main.card_nintendo_item.view.*
import kotlinx.android.synthetic.main.card_playstation_item.view.*


class PlayStationAdapter(private val playsationList: List<PlayStationData>) :
        RecyclerView.Adapter<PlayStationAdapter.PlayStationViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayStationViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_playstation_item,
                parent, false)
            return PlayStationViewHolder(itemView)
        }
        override fun onBindViewHolder(holder: PlayStationViewHolder, position: Int) {
            val currentItem = playsationList[position]

            holder.textView1.text = currentItem.text1
            holder.textView2.text = currentItem.text2
            holder.textView3.text = currentItem.text3
            holder.textView4.text = currentItem.text4
        }
        override fun getItemCount() = playsationList.size

        class PlayStationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textView1: TextView = itemView.card_value_1
            val textView2: TextView = itemView.card_value_2
            val textView3: TextView = itemView.card_value_3
            val textView4: TextView = itemView.card_value_4
        }

}