package com.gama.databinding_validation

/**
 * data class that contains all the validation parameters and set it as a view's tag.
 *
 * @property required Boolean if this view is required that user must set it.
 * @property isWatch Boolean if it's a real time validation, validate after every input.
 * @property validationPattern String? the regex pattern to be used to match the input.
 * @property minLength Int the min length allowed for the input.
 * @property maxLength Int the max length allowed for the input.
 * @property mustMatchTxt String? the input txt must be the same as this txt.
 * @property errorText String? the error text that will be displayed in case of input not match.
 * @property emptyErrorTxt String? the error text that will be displayed in case of [isRequired] and the view is empty.
 */
data class ValidationTag(
    var required: Boolean = false,
    var isWatch: Boolean = false,
    var validationPattern: String? = null,
    var minLength: Int = 0,
    var maxLength: Int = Int.MAX_VALUE,
    var mustMatchTxt: String? = null,
    var errorText: String? = null,
    var emptyErrorTxt: String? = null
)