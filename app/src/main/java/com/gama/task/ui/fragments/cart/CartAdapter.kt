package com.gama.task.ui.fragments.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.cart_item.view.*

class CartAdapter(private val cartList: List<CartItem>,private val  onItemClickListener: OnItemClickListener) :RecyclerView.Adapter<CartAdapter.CartViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.cart_item,
            parent, false)
        return CartViewHolder(itemView,onItemClickListener)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = cartList[position]
       holder.cardImage.setImageResource(currentItem.text1)
        holder.cardPrice.text = currentItem.text3
        holder.cardName.text = currentItem.text4
    }

    override fun getItemCount()=cartList.size


    class CartViewHolder(itemView : View,onItemClickListener: OnItemClickListener):RecyclerView.ViewHolder(itemView){

        val cardImage: ImageView=itemView.card_image
        val cardName: TextView=itemView.card_name
        val cardPrice: TextView=itemView.card_price
        val cardDelete: ImageView=itemView.delet_item_btn
        init {

            itemView.delet_item_btn.setOnClickListener {
                onItemClickListener.onClick(adapterPosition)
            }
        }
    }

    interface  OnItemClickListener{
        fun onClick(position: Int)

    }
}