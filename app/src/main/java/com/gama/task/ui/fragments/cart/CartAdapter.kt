package com.gama.task.ui.fragments.cart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gama.task.R
import com.gama.task.ui.fragments.cart.models.CartItem
import kotlinx.android.synthetic.main.cart_item.view.*

class CartAdapter(private val  context:Context,private val cartList: List<CartItem>,private val  onItemClickListener: OnItemClickListener) :RecyclerView.Adapter<CartAdapter.CartViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.cart_item,
            parent, false)
        return CartViewHolder(itemView,onItemClickListener)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem = cartList[position]
      // holder.cardImage.setImageResource(currentItem.img_id)
      //  Glide.with(context)
        //    .load(Uri.parse("file:///android_asset/"+fileName))
          //  .into(imageView);

        val url="http://143.198.117.2:8080/api/files/"+currentItem.img_id
        Glide
            .with(context)
            .load(url)
            .centerCrop()
            .into(holder.cardImage);

        holder.cardPrice.text = currentItem.Price.toString()
        holder.cardName.text = currentItem.Title
        holder.cardCount.text=currentItem.quanty.toString()
    }

    override fun getItemCount()=cartList.size


    class CartViewHolder(itemView : View,onItemClickListener: OnItemClickListener):RecyclerView.ViewHolder(itemView){

        val cardImage: ImageView=itemView.card_image
        val cardName: TextView=itemView.card_name
        val cardPrice: TextView=itemView.card_price
        val cardDelete: ImageView=itemView.delet_item_btn
        val add:Button=itemView.findViewById(R.id.add_item)
        val remove:Button=itemView.findViewById(R.id.remove_item)
        val cardCount: TextView=itemView.findViewById(R.id.cart_counter)

        init {

            itemView.delet_item_btn.setOnClickListener {
                onItemClickListener.onClick(adapterPosition)
            }
            itemView.add_item.setOnClickListener {  onItemClickListener.onAddClick(adapterPosition)}
            itemView.remove_item.setOnClickListener {  onItemClickListener.onRemoveClick(adapterPosition)}
        }
    }

    interface  OnItemClickListener{
        fun onClick(position: Int)

        fun onAddClick(position: Int)
        fun onRemoveClick(position: Int)

    }
}