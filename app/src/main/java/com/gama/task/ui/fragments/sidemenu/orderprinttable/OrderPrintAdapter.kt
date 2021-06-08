package com.gama.task.ui.fragments.sidemenu.orderprinttable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import kotlinx.android.synthetic.main.table_receipt_item.view.*

class OrderPrintAdapter (var oderPrintList:ArrayList<OrderPrintTableData>,private val onItemClickListener: OnItemClickListener  ):RecyclerView.Adapter<OrderPrintAdapter.OrderPrinterViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderPrinterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.table_receipt_item,
            parent, false)
        return OrderPrinterViewHolder(itemView,onItemClickListener)

    }


    override fun onBindViewHolder(holder: OrderPrinterViewHolder, position: Int) {

        val orderPrintReciptList=oderPrintList[position]
        holder.bind(orderPrintReciptList)


    }

    override fun getItemCount(): Int = oderPrintList.size


    class OrderPrinterViewHolder(itemView: View,onItemClickListener: OnItemClickListener):RecyclerView.ViewHolder(itemView){

        fun bind(orderPrintTableData: OrderPrintTableData){

            itemView.id_table.text=orderPrintTableData.text1
            itemView.date.text=orderPrintTableData.text2
            itemView.amount.text=orderPrintTableData.text3

        }
        init {
            itemView.table_receipt.setOnClickListener {
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
