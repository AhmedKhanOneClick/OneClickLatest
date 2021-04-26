package com.gama.databinding_validation

import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Extension function to update [ValidationTag.errorText]
 *
 * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
 *  ```xml
 *      <View
 *       ...
 *       validation:errorTxt:"@{`error txt`}"/>
 *  ```
 *
 */
@BindingAdapter("validation:errorTxt")
fun View.setError(error: String) {
    val validationTag = tag ?: ValidationTag()
    if (validationTag is ValidationTag) {
        validationTag.errorText = error
    }
    this.tag = validationTag
}

/**
 * Extension function to update [ValidationTag.validationPattern]
 *
 * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
 *  ```xml
 *      <View
 *       ...
 *       validation:pattern:"@{`regex pattern`}"/>
 *  ```
 * @see CommonPatterns
 */
@BindingAdapter("validation:pattern")
fun View.setPattern(validationPattern: String) {
    val validationTag = tag ?: ValidationTag()
    if (validationTag is ValidationTag) {
        validationTag.validationPattern = validationPattern
    }
    this.tag = validationTag
}

/**
 * Extension function to update [ValidationTag.emptyErrorTxt]
 *
 * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
 *  ```xml
 *      <View
 *       ...
 *       validation:emptyErrorTxt:"@{`error txt`}"/>
 *  ```
 *
 */
@BindingAdapter("validation:emptyErrorTxt")
fun View.setEmpty(empty: String) {
    val validationTag = tag ?: ValidationTag()
    if (validationTag is ValidationTag) {
        validationTag.emptyErrorTxt = empty
    }
    this.tag = validationTag
}

/**
 * Extension function to update [ValidationTag.required]
 *
 * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
 *  ```xml
 *      <View
 *       ...
 *       validation:isRequired:"@{true}"/>
 *  ```
 *
 */
@BindingAdapter("validation:isRequired")
fun View.isRequired(isRequired: Boolean) {
    val validationTag = tag ?: ValidationTag()
    if (validationTag is ValidationTag) {
        validationTag.required = isRequired
    }
    this.tag = validationTag
}

/**
 * Extension function to update [ValidationTag.minLength]
 *
 * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
 *  ```xml
 *      <View
 *       ...
 *       validation:minLength:"@{5}"/>
 *  ```
 *
 */
@BindingAdapter("validation:minLength")
fun View.minLength(minLength: Int) {
    val validationTag = tag ?: ValidationTag()
    if (validationTag is ValidationTag) {
        validationTag.minLength = minLength
    }
    this.tag = validationTag
}

/**
 * Extension function to update [ValidationTag.maxLength]
 *
 * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
 *  ```xml
 *      <View
 *       ...
 *       validation:maxLength:"@{50}"/>
 *  ```
 *
 */
@BindingAdapter("validation:maxLength")
fun View.maxLength(maxLength: Int) {
    val validationTag = tag ?: ValidationTag()
    if (validationTag is ValidationTag) {
        validationTag.maxLength = maxLength

        if (this is TextView)
            this.filters = arrayOf<InputFilter>(LengthFilter(maxLength))
    }
    this.tag = validationTag
}

/**
 * Extension function to update [ValidationTag.mustMatchTxt]
 *
 * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
 *  ```xml
 *      <View
 *       ...
 *       validation:mustMatch:"@{`the text that must be matched with`}"/>
 *  ```
 *
 */
@BindingAdapter("validation:mustMatch")
fun View.mustMatch(mustMatchTxt: String) {

    val validationTag = tag ?: ValidationTag()
    if (validationTag is ValidationTag) {
        validationTag.mustMatchTxt = mustMatchTxt
    }
    this.tag = validationTag
}


/**
 * Extension function to update [ValidationTag.isWatch]
 *
 * Because it's a [BindingAdapter](https://developer.android.com/topic/libraries/data-binding/binding-adapters), it can be used as a XML attribute:
 *  ```xml
 *      <View
 *       ...
 *       validation:watch:"@{true}"/>
 *  ```
 *
 */
@BindingAdapter("validation:watch")
fun View.enableWatching(watch: Boolean) {
    val validationTag = tag ?: ValidationTag()
    if (validationTag is ValidationTag) {
        validationTag.isWatch = watch
    }
    this.tag = validationTag
}