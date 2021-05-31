package com.gama.task.models


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data  class Categories(
//        @SerializedName("accounts") val accounts: List<Accounts1>,

    @SerializedName("data") val data: Data1,
//    @SerializedName("data") val errors: List<Any>,
    @SerializedName("msg") val msg: String,
    @SerializedName("status") val status: Int
): IdentityGeneralResponse()
@Keep
data class Data1(
    @SerializedName("content") val content: List<Content1>
//    ,
//    @SerializedName("pageable") val pageable: Pageable
): IdentityGeneralResponse()
@Keep
data class Content1(
    @SerializedName("id") val id: String,
    @SerializedName("nameEn") val nameEn: String,
    @SerializedName("nameUr") val nameUr: String,
    @SerializedName("nameAr") val nameAr: String,

    @SerializedName("descriptionEn") val descriptionEn: String,
    @SerializedName("descriptionUr") val descriptionUr: String,
    @SerializedName("descriptionAr") val descriptionAr: String,
    @SerializedName("imageURL") val imageURL: String,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String

): IdentityGeneralResponse()
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