package com.gama.task.ui.fragments.favourites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import com.gama.task.AppExecutors
import com.gama.task.R
import com.gama.task.databinding.CardFavouritesItemBinding
import com.gama.task.databinding.CardMobilyItemBinding
import com.gama.task.models.Content

import com.gama.task.ui.base.DataBoundListAdapter
import kotlinx.android.synthetic.main.card_favourites_item.view.*
import kotlinx.android.synthetic.main.card_mobily_item.view.*
import kotlinx.android.synthetic.main.card_mobily_item.view.favourites


/**
 * Adapter that displays list of hotels.
 *
 * @property dataBindingComponent DataBindingComponent The DataBindingComponent to use in the binding.
 * @param appExecutors AppExecutors executor pools.
 * @property onHotelClicked Function1<Hotel, Unit> action to perform when hotel selected.
 */
class FavouritesAdapter(

    private val dataBindingComponent: DataBindingComponent,
    private val appExecutors: AppExecutors,

    private val onHotelClicked: (Content,it: View) -> Unit,
) : DataBoundListAdapter<Content, CardFavouritesItemBinding>(
    appExecutors,
    object : DiffUtil.ItemCallback<Content>() {
        override fun areItemsTheSame(oldItem: Content, newItem: Content) = false
        override fun areContentsTheSame(oldItem: Content, newItem: Content) = false
    }) {

    override fun createBinding(parent: ViewGroup): CardFavouritesItemBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.card_favourites_item,
        parent,
        false,
        dataBindingComponent
    )

    override fun bind(binding: CardFavouritesItemBinding, item: Content, position: Int) {
        binding.notification = item

//        binding.recyclerAmenities.adapter =
//            HotelAmenitiesAdapter(dataBindingComponent, appExecutors).apply {
//                submitList(item.amenities)
//            }


        binding.root.favourites1.setOnClickListener {
//            if(binding.root.favourites.drawable== resources.getDrawable(=R.drawable.favourites))
//            val contect=it.context.applicationContext.r
//            val model = ViewModelProvider(context).get(SharedViewModel::class.java)
//            model1.sendfavourites(item)
            onHotelClicked(item,it)
//            itemClick(layoutPosition)
        }


        binding.root.setOnClickListener {
            onHotelClicked(item,it)
//       onCardlClicked(item)
//            itemClick(layoutPosition)
        }
    }
}