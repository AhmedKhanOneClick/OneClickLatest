package com.gama.task.ui.pager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.gama.task.R
import com.gama.task.models.CategoryItem
import kotlinx.android.synthetic.main.category_card.view.*

/*
    created by Abdallah.elsyd.sh@gmail.com
 */
class CategoriesListAdaptor : RecyclerView.Adapter<CategoriesListAdaptor.CategoryViewHolder>() {

    private var items: List<CategoryItem> = ArrayList()

    private val diffCallback = object : DiffUtil.ItemCallback<CategoryItem>() {
        override fun areItemsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryItem, newItem: CategoryItem): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)
    var itemsList: List<CategoryItem>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.apply {
            tv_catogory_name.text = item.title
            tv_categoryCard_des.text = item.description
            iv_categoryCard.setImageResource(item.ImageSrc)
        }
        holder.itemView.setOnClickListener {
            var action: NavDirections? = null
            when (item.id) {
//                0 -> action =
//                    MainCategoriesFragmentDirections.actionSearchPagerFragmentToDataRechargeFragment()
//                1 -> action =
//                    MainCategoriesFragmentDirections.actionSearchPagerFragmentToVoiceRechargeFragment()
//                2 -> action = MainCategoriesFragmentDirections.actionSearchPagerFragmentToGameCard()
//                3 -> action =
//                    MainCategoriesFragmentDirections.actionSearchPagerFragmentToCinemaCardFragment()
//                4 -> action =
//                    MainCategoriesFragmentDirections.actionSearchPagerFragmentToGiftCardFragment()
            }
            if (action != null) {
                holder.itemView.findNavController().navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(categoryItem: List<CategoryItem>) {
        items = categoryItem
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}