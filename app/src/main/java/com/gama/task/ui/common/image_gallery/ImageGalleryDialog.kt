package com.gama.saudi2go.ui.common.image_gallery

import android.content.DialogInterface
import androidx.viewpager2.widget.ViewPager2
import com.gama.task.R
import com.gama.task.databinding.DialogImageGalleryBinding
import com.gama.task.ui.base.BaseDialogFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Display the images in viewPager with zoom in/out controls
 * @property images List<String> the list of images to be displayed
 * @property position Int the selected position of image to be displayed by default
 * @property onDismiss Function0<Unit> action to be performed when dialog dismiss
 */
@AndroidEntryPoint
class ImageGalleryDialog(
    private val images: List<String>,
    private val position: Int = 0,
    private val onDismiss: () -> Unit = {}
) : BaseDialogFragment<DialogImageGalleryBinding>() {

    override fun isFullScreenDialog() = true

    override fun getLayoutRes() = R.layout.dialog_image_gallery

    override fun init() {

        // set indicators count
        binding.indicator.count = images.size

        //change selected indicator when image swiped
        binding.pagerImage.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.indicator.selection = position
            }
        })


        binding.pagerImage.adapter =
            ImagesGalleryAdapter(dataBindingComponent, appExecutors).apply {
                submitList(images)
            }

        //display default image
        binding.pagerImage.currentItem = position

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismiss()
    }
}