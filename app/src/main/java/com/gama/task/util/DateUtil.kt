package com.gama.task.util

import java.text.SimpleDateFormat
import java.util.*


object DateUtil {

    //    private const val SERVER_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
    private const val SERVER_DATE_FORMAT = "yyyy-MM-dd"

    /**
     * convert time in millis to the date in [SERVER_DATE_FORMAT] (2020-09-15T10:30:50).
     * @receiver Long
     * @return String the formatted date
     *
     * @see fromServerDateFormat
     */
    fun Long.toServerDate(): String =
        SimpleDateFormat(SERVER_DATE_FORMAT, Locale.ENGLISH).format(this)

    /**
     * convert date in [SERVER_DATE_FORMAT] to time in millis
     * @receiver String
     * @return Long? time in millis
     *
     * @see toServerDate
     */
    fun String.fromServerDateFormat() =
        SimpleDateFormat(SERVER_DATE_FORMAT, Locale.ENGLISH).parse(this)?.time
}