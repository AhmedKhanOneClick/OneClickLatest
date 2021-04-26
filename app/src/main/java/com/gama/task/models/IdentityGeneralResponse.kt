package com.gama.task.models


import androidx.annotation.Keep

import com.google.gson.annotations.SerializedName
import io.realm.annotations.Ignore

@Keep
open class IdentityGeneralResponse(
    @Ignore
    @SerializedName("success", alternate = ["isSuccess"]) val success: Boolean? = null,
    @Ignore
    @SerializedName("errorMessage", alternate = ["message"]) val errorMessage: String? = null,
    @Ignore
    @SerializedName("errors") val errors: List<String>? = null
)

@Keep
open class GeneralResponse<T>(
    @Ignore
    @SerializedName("data") val `data`: T?

)