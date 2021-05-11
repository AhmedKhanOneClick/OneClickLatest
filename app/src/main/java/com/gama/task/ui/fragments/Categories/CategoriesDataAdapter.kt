package com.gama.task.ui.fragments.Categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.gama.task.AppExecutors
import com.gama.task.R
import com.gama.task.databinding.CardMobilyItemBinding
import com.gama.task.databinding.CategoryCardBinding
import com.gama.task.models.Content
import com.gama.task.models.Content1
import com.gama.task.ui.base.DataBoundListAdapter


/**
 * Adapter that displays list of hotels.
 *
 * @property dataBindingComponent DataBindingComponent The DataBindingComponent to use in the binding.
 * @param appExecutors AppExecutors executor pools.
 * @property onHotelClicked Function1<Hotel, Unit> action to perform when hotel selected.
 */
class CategoriesDataAdapter(
    private val dataBindingComponent: DataBindingComponent,
    private val appExecutors: AppExecutors,
    private val onHotelClicked: (Content1) -> Unit
) : DataBoundListAdapter<Content1, CategoryCardBinding>(
    appExecutors,
    object : DiffUtil.ItemCallback<Content1>() {
        override fun areItemsTheSame(oldItem: Content1, newItem: Content1) = false
        override fun areContentsTheSame(oldItem: Content1, newItem: Content1) = false
    }) {

    override fun createBinding(parent: ViewGroup): CategoryCardBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.category_card,
        parent,
        false,
        dataBindingComponent
    )

    override fun bind(binding: CategoryCardBinding, item: Content1, position: Int) {
        binding.categories = item

//        binding.recyclerAmenities.adapter =
//            HotelAmenitiesAdapter(dataBindingComponent, appExecutors).apply {
//                submitList(item.amenities)
//            }

        binding.root.setOnClickListener { onHotelClicked(item) }
    }
}