package com.gama.task.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass


@Keep
//@RealmClass
open class Products (
                     //@SerializedName("accounts") val accounts: List<Accounts1>,

@SerializedName("data") val data: Data,
//    @SerializedName("data") val errors: List<Any>,
@SerializedName("msg") val msg: String,
@SerializedName("status") val status: Int
): IdentityGeneralResponse()
@Keep
data class Data(
    @SerializedName("content") val content: List<Content>
//    ,
//    @SerializedName("pageable") val pageable: Pageable
): IdentityGeneralResponse()
@Keep
//@RealmClass
data class Content(
    @SerializedName("id") val id: String,
    @SerializedName("nameEn") val nameEn: String,
    @SerializedName("nameUr") val nameUr: String,
    @SerializedName("nameAr") val nameAr: String,

    @SerializedName("descriptionEn") val descriptionEn: String,
    @SerializedName("descriptionUr") val descriptionUr: String,
    @SerializedName("descriptionAr") val descriptionAr: String,


    @SerializedName("price") val price: Double,
    @SerializedName("defaultImageURL") val defaultImageURL: String,
//    @SerializedName("data") val productCategory: ProductCategory,
//    @SerializedName("data") val provider: Provider,
//    @SerializedName("data") val providerId: String,
    @SerializedName("quantity") val quantity: Double,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,

//    @SerializedName("data") val tags: Any,
//    @SerializedName("data") val updatedAt: Long,
//    @SerializedName("data") val weight: String
) : RealmModel {

    @PrimaryKey
    var databaseID: Int = 2
}

//}