package com.gama.task.util.extensions

import android.text.SpannableStringBuilder
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.View
import androidx.core.text.inSpans


/**
 * Extension function that append text in [builder] and make it clickable to perform some action.
 *
 * @receiver SpannableStringBuilder
 * @param builderAction SpannableStringBuilder
 * @param onClick Function1<View, Unit>
 * @return SpannableStringBuilder
 *
 * @see link
 */
inline fun SpannableStringBuilder.clickable(
    crossinline onClick: (View) -> Unit,
    builderAction: SpannableStringBuilder.() -> Unit
): SpannableStringBuilder {

    return inSpans(object : ClickableSpan() {
        override fun onClick(widget: View) {
            onClick(widget)
        }
    }) { builderAction() }
}

/**
 * Extension function that Wrap appended text in [builderAction] in an [URLSpan].
 *
 * @receiver SpannableStringBuilder
 * @param url String the url to be opened on click
 * @param builderAction [@kotlin.ExtensionFunctionType] Function1<SpannableStringBuilder, Unit>
 * @return SpannableStringBuilder
 *
 * @see clickable
 */
inline fun SpannableStringBuilder.link(
    url: String,
    builderAction: SpannableStringBuilder.() -> Unit
) = inSpans(URLSpan(url), builderAction)