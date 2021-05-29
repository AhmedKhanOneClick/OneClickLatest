package com.gama.task.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.annotations.RealmClass

/**
 * @author Wellington Costa on 30/12/2017.
 */
@Keep
//@RealmClass
open class Favourites (

    @SerializedName("price") val price: Double,
    @SerializedName("quantity") val quantity: Double,
    @SerializedName("createdAt") val createdAt: String,

)
