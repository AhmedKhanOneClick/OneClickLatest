package com.gama.task.util.extensions


import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Inflate a layout to a viewGroup.
 *
 * @receiver ViewGroup
 * @param resourceId Int the layout res to be inflated
 * @return [View]? the inflated view or null
 *
 * @see bindingInflate
 */
fun ViewGroup.inflate(@LayoutRes resourceId: Int) =
    LayoutInflater.from(context).inflate(
        resourceId,
        this,
        false
    )

/**
 * Inflate a layout to a viewGroup using data-binding.
 *
 * @receiver ViewGroup
 * @param resourceId Int the layout res to be inflated
 * @return (T..T?) the inflated [ViewDataBinding] or null
 *
 * @see inflate
 */
fun <T : ViewDataBinding?> ViewGroup.bindingInflate(@LayoutRes resourceId: Int) =
    DataBindingUtil.inflate<T>(
        LayoutInflater.from(context),
        resourceId,
        this,
        true
    )


/**
 * Set view visibility to [GONE]
 * @receiver View
 */
fun View.hide() {
    visibility = GONE
}

/**
 * Set view visibility to [VISIBLE]
 * @receiver View
 */
fun View.show() {
    visibility = VISIBLE
}


fun View.doOnApplyWindowInsets(f: (View, WindowInsetsCompat, ViewPaddingState) -> Unit) {
    // Create a snapshot of the view's padding state
    val paddingState = createStateForView(this)
    ViewCompat.setOnApplyWindowInsetsListener(this) { v, insets ->
        f(v, insets, paddingState)
        insets
    }
    requestApplyInsetsWhenAttached()
}

/**
 * Call [View.requestApplyInsets] in a safe away. If we're attached it calls it straight-away.
 * If not it sets an [View.OnAttachStateChangeListener] and waits to be attached before calling
 * [View.requestApplyInsets].
 */
fun View.requestApplyInsetsWhenAttached() {
    if (isAttachedToWindow) {
        requestApplyInsets()
    } else {
        addOnAttachStateChangeListener(object : View.OnAttachStateChangeListener {
            override fun onViewAttachedToWindow(v: View) {
                v.requestApplyInsets()
            }

            override fun onViewDetachedFromWindow(v: View) = Unit
        })
    }
}

private fun createStateForView(view: View) = ViewPaddingState(
    view.paddingLeft,
    view.paddingTop, view.paddingRight, view.paddingBottom, view.paddingStart, view.paddingEnd
)

data class ViewPaddingState(
    val left: Int,
    val top: Int,
    val right: Int,
    val bottom: Int,
    val start: Int,
    val end: Int
)

