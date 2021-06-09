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
//@Keep
//data class Pageable(
//    @SerializedName("data") val page: String,
//    @SerializedName("data") val size: String,
//    @SerializedName("data") val totalElements: Int
//): IdentityGeneralResponse()
//@Keep
//data class ProductCategory(
//    @SerializedName("data") val createdAt: String,
//    @SerializedName("data") val deletedAt: Any,
//    @SerializedName("data") val descriptionAr: String,
//    @SerializedName("data") val descriptionEn: String,
//    @SerializedName("data") val descriptionUr: String,
//    @SerializedName("data") val id: String,
//    @SerializedName("data") val imageURL: String,
//    @SerializedName("data") val isActive: Boolean,
//    @SerializedName("data") val isDeleted: Boolean,
//    @SerializedName("data") val nameAr: String,
//    @SerializedName("data") val nameEn: String,
//    @SerializedName("data") val nameUr: String,
//    @SerializedName("data") val parentId: Any,
//    @SerializedName("data") val updatedAt: String
//): IdentityGeneralResponse()
//@Keep
//data class Provider(
//    @SerializedName("data") val createdAt: String,
//    @SerializedName("data") val createdBy: Any,
//    @SerializedName("data") val credentialId: String,
//    @SerializedName("data") val deviceId: String,
//    @SerializedName("data") val firstName: String,
//    @SerializedName("data") val id: String,
//    @SerializedName("data") val imgUrl: Any,
//    @SerializedName("data") val isDeleted: Boolean,
//    @SerializedName("data") val isVerified: Any,
//    @SerializedName("data") val lastName: String,
//    @SerializedName("data") val latitude: Int,
//    @SerializedName("data") val longitude: Int,
//    @SerializedName("data") val phoneNumber: String,
//    @SerializedName("data") val posCode: String,
//    @SerializedName("data") val shopName: String,
//    @SerializedName("data") val shopNameArabic: String,
//    @SerializedName("data") val updatedAt: String,
//    @SerializedName("data") val username: String
//): IdentityGeneralResponse()


//}