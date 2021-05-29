package com.gama.task.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Filter (
    @SerializedName("assigned") val assigned: Boolean,
    @SerializedName("statuses") val statuses: List<Any>
    )