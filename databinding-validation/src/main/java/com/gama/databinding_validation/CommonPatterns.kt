package com.gama.databinding_validation


/**
 * The common regex patterns to be used to validate inputs.
 */
object CommonPatterns {

    /**
     * Email address regex pattern.
     */
    @JvmField
    val EMAIL = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+"

    /**
     * phone number regex pattern.
     */
    @JvmField
    val PHONE = "(\\+[0-9]+[\\- \\.]*)?" + "(\\([0-9]+\\)[\\- \\.]*)?" + "([0-9][0-9\\- \\.]+[0-9])"

    /**
     * Regex pattern for chars and numbers and don't accept special chars.
     */
    @JvmField
    val NO_SPECIAL_CHARS = "[a-zA-Z0-9]+"

    /**
     * Regex pattern for chars and numbers and don't accept special chars  except space.
     */
    @JvmField
    val ONLY_CHARS_WITH_SPACE = "[a-zA-Z/\\s]+"

    /**
     * Regex pattern that enforce input length to be from 8 to 16 and must contains at least:
     * - 1 small letter.
     * - 1 capital letter.
     * - 1 number.
     * - 1 special char.
     */
    @JvmField
    val COMPLEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$"

    /**
     * Regex pattern for arabic chars only.
     */
    @JvmField
    val ARABIC_CHARS = "\u0621-\u064A\u0660-\u0669"

    /**
     * Regex pattern for accept date in format dd/mm/yyyy.
     */
    @JvmField
    val DATE = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$" // dd/mm/yyyy

    @JvmField
    val iban = "^SA\\s" // dd/mm/yyyy

}