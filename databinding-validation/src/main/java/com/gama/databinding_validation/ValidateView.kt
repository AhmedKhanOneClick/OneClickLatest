package com.gama.databinding_validation

import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

/**
 * validate view and its children views and return true if the the view and all children is valid.
 */
fun View.validate(): Boolean {

    var isValid = true

    // if the view not visible to user don't validate it.
    if (visibility != VISIBLE)
        return isValid

    // if it's a viewGroup validate all children
    if (this is ViewGroup) {
        this.forEach { childView ->
            if (!childView.validate())
                isValid = false
        }
    }

    // get the validation tag from the view
    val validationTag = tag ?: ValidationTag()

    // if you set the tag of the view to be any thing then don't validate it.
    if (validationTag !is ValidationTag)
        return isValid

    // no validate only editText
    // more types can be added later.
    return when (this) {
        is EditText -> validate(validationTag)
        else -> isValid
    }

}

/**
 * loop to all children views of the viewGroup and perform some action.
 */
private inline fun ViewGroup.forEach(action: (view: View) -> Unit) {

    for (index in 0 until childCount) {
        action(getChildAt(index))
    }
}

/**
 * validate the edit text and return true if it's valid or set error and return false.
 */
private fun EditText.validate(validationTag: ValidationTag): Boolean {

    // if empty and it's required set error and return false.
    // if empty and not required return true.
    if (text.isNullOrBlank()) {
        return if (validationTag.required) {
            setMaterialError(
                validationTag.emptyErrorTxt ?: context.getString(
                    R.string.error_empty_general

                )
            )
            false
        } else
            return true
    }

    // if input type is password don't trim the input
    val txtToValidate =
        if (inputType == TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD) text else text.trim()

    // if user set validation pattern to validate input with.
    if (validationTag.validationPattern != null) {

        if (!isInputTxtMatch(txtToValidate.toString(), validationTag.validationPattern ?: "")
            || txtToValidate.length < validationTag.minLength
            || txtToValidate.length > validationTag.maxLength
        ) {
            setMaterialError(validationTag.errorText)
            return false
        }
    }

    // validate if txt must match with another text.
    if (validationTag.mustMatchTxt != null && txtToValidate.toString() != validationTag.mustMatchTxt) {
        setMaterialError(validationTag.errorText)
        return false
    }

    return true
}

/**
 * if editText's parent view is TextInputLayout set error to it else set error to editText itself.
 */
fun EditText.setMaterialError(errorStr: String?) {
    if (parent.parent is TextInputLayout) {
        (parent.parent as TextInputLayout).error = errorStr
    } else
        error = errorStr
}

/**
 * match the text with the validation regex pattern.
 */
fun isInputTxtMatch(inputTxt: String, pattern: String) = inputTxt.matches(pattern.toRegex())