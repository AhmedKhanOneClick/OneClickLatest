package com.gama.task.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import java.io.Serializable



@Keep
data class Order(
    @SerializedName("purchasedDate") val purchasedDate: Double,
    @SerializedName("total") val total: Double,
    @SerializedName("totalWithVAT") val totalWithVAT: Double,
    @SerializedName("discount") val discount: Double,
    @SerializedName("vat") val vat: Double,
    @SerializedName("subTotal") val subTotal: Double,
    @SerializedName("status") val status: String,
    @SerializedName("vendorId") val vendorId: String,
    @SerializedName("products") val products: List<Products11>,

) : Serializable {


    @Keep
    data class Products11(
        @SerializedName("productId") var productId: String,
        @SerializedName("productQuantity") var productQuantity: Double,
    ) : Serializable
}