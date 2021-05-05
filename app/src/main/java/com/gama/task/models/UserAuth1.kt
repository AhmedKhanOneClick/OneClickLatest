package com.gama.task.models


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


@Keep
open class UserAuth1(
    @SerializedName("msg") val msg: String,
    @SerializedName("data") val data: UserAuth
) : IdentityGeneralResponse()
