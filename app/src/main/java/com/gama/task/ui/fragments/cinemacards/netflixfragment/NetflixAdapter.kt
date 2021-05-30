package com.gama.task.ui.fragments.cinemacards.netflixfragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.cinemacards.kitaabsawti.KitaabsawtiAdapter
import kotlinx.android.synthetic.main.card_xbox_item.view.*

//class StarzplayAdapter {
//}
class NetflixAdapter(private val netflixList: List<NetflixData>,private val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<NetflixAdapter.NetflixViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetflixViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.card_netflix_item,
            parent, false)
        return NetflixViewHolder(itemView,onItemClickListener)
    }
    override fun onBindViewHolder(holder: NetflixViewHolder, position: Int) {
        val currentItem = netflixList[position]

        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2.toString()
        holder.textView3.text = currentItem.text3
        holder.textView4.text = currentItem.text4
    }
    override fun getItemCount() = netflixList.size

    class NetflixViewHolder(itemView: View,onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val textView1: TextView = itemView.card_value1_tv
        val textView2: TextView = itemView.card_value2_tv
        val textView3: TextView = itemView.card_value3_tv
        val textView4: TextView = itemView.card_value4_tv
        init {
            itemView.setOnClickListener {
                onItemClickListener.onClick(absoluteAdapterPosition)
            }
            itemView.setOnLongClickListener {
                onItemClickListener.onLongClick(adapterPosition)

                return@setOnLongClickListener true
            }

        }
    }

    interface OnItemClickListener {
        fun onClick(position: Int)
        fun onLongClick(position: Int)
    }
}