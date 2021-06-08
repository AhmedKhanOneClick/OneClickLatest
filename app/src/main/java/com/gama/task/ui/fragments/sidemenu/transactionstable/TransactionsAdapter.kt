package com.gama.task.ui.fragments.sidemenu.transactionstable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import kotlinx.android.synthetic.main.table_item.view.*
import kotlinx.android.synthetic.main.table_receipt_item.view.id_table

class TransactionsAdapter(var transactionsList:ArrayList<TransactionTableData>,private val onItemClickListener: OnItemClickListener)
    : RecyclerView.Adapter<TransactionsAdapter.TransactionsViewHolder> (){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.table_item,
            parent, false)
        return TransactionsViewHolder(itemView, onItemClickListener)
    }

    override fun getItemCount(): Int =transactionsList.size



    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {
        val transctionsList=transactionsList[position]
        holder.bind(transctionsList)
    }

    class TransactionsViewHolder(itemView: View, onItemClickListener: OnItemClickListener):RecyclerView.ViewHolder(itemView){

        fun bind(transactionTableData: TransactionTableData){

            itemView.id_table.text=transactionTableData.text1
            itemView.date_.text=transactionTableData.text2
            itemView.amount_.text=transactionTableData.text3
            itemView.statues_.text=transactionTableData.text4

        }
        init {
            itemView.table_details_.setOnClickListener {
                onItemClickListener.onClick(absoluteAdapterPosition)
            }
            itemView.setOnLongClickListener {
                onItemClickListener.onLongClick(adapterPosition)

                return@setOnLongClickListener true
            }

        }
    }

    interface OnItemClickListener{
        fun onClick(position: Int)
        fun onLongClick(position: Int)
    }


}