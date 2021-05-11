package com.gama.saudi2go.ui.common.image_gallery

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.gama.task.AppExecutors
import com.gama.task.R
import com.gama.task.databinding.ItemImageViewerBinding
import com.gama.task.ui.base.DataBoundListAdapter

class ImagesGalleryAdapter(
    private val dataBindingComponent: DataBindingComponent,
    appExecutors: AppExecutors
) : DataBoundListAdapter<String, ItemImageViewerBinding>(
    appExecutors,
    object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem == newItem
    }) {

    override fun createBinding(parent: ViewGroup): ItemImageViewerBinding = DataBindingUtil.inflate(
        LayoutInflater.from(parent.context),
        R.layout.item_image_viewer,
        parent,
        false,
        dataBindingComponent
    )

    @SuppressLint("CheckResult")
    override fun bind(binding: ItemImageViewerBinding, item: String, position: Int) {

        binding.image.showImage(Uri.parse(item))

    }

}