package com.gama.task.ui.fragments.orders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.gama.task.AppExecutors
import com.gama.task.R
import com.gama.task.databinding.CardMobilyItemBinding
import com.gama.task.databinding.CategoryCardBinding
import com.gama.task.databinding.TableItemBinding
import com.gama.task.models.Content
import com.gama.task.models.Content1
import com.gama.task.models.Content6
import com.gama.task.ui.base.DataBoundListAdapter
import kotlinx.android.synthetic.main.table_item.view.*


/**
 * Adapter that displays list of hotels.
 *
 * @property dataBindingComponent DataBindingComponent The DataBindingComponent to use in the binding.
 * @param appExecutors AppExecutors executor pools.
 * @property onHotelClicked Function1<Hotel, Unit> action to perform when hotel selected.
 */
class OrdersDataAdapter(
    private val dataBindingComponent: DataBindingComponent,
    private val appExecutors: AppExecutors,
    private val onHotelClicked: (Content6,it: View) -> Unit
) : DataBoundListAdapter<Content6, TableItemBinding>(
    appExecutors,
    object : DiffUtil.ItemCallback<Content6>() {
        override fun areItemsTheSame(oldItem: Content6, newItem: Content6) = false
        override fun areContentsTheSame(oldItem: Content6, newItem: Content6) = false
    }) {

    override fun createBinding(parent: ViewGroup): TableItemBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.table_item,
        parent,
        false,
        dataBindingComponent
    )

    override fun bind(binding: TableItemBinding, item: Content6, position: Int) {
        binding.notification = item

//        binding.recyclerAmenities.adapter =
//            HotelAmenitiesAdapter(dataBindingComponent, appExecutors).apply {
//                submitList(item.amenities)
//            }

        binding.root.table_details_.setOnClickListener { onHotelClicked(item,it) }
    }
}