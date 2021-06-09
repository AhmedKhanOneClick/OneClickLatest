package com.gama.task.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName



@Keep
open class OrdersDetails (
//        @SerializedName("accounts") val accounts: List<Accounts1>,

    @SerializedName("data") val data: Data7,
//    @SerializedName("data") val errors: List<Any>,
    @SerializedName("msg") val msg: String,
    @SerializedName("status") val status: Int
): IdentityGeneralResponse()
@Keep
data class Data7(
    @SerializedName("content") val content: Content7
//    ,
//    @SerializedName("pageable") val pageable: Pageable
): IdentityGeneralResponse()
@Keep

data class Content7(

    @SerializedName("id") val id: String,
    @SerializedName("purchasedDate") val purchasedDate: Double,
    @SerializedName("total") val total: Double,
    @SerializedName("totalWithVAT") val totalWithVAT: Double,
    @SerializedName("discount") val discount: Double,
    @SerializedName("vat") val vat: Double,
    @SerializedName("subTotal") val subTotal: Double,
    @SerializedName("status") val status: String,
    @SerializedName("vendorId") val vendorId: String,
    @SerializedName("isDeleted") val isDeleted: Boolean,



    @SerializedName("createdAt") val createdAt: String,
     @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("products") val products: List<Prodcut>,
) : IdentityGeneralResponse()
@Keep
data class Prodcut(
//    @SerializedName("data") val SKU: Any,
//    @SerializedName("data") val brand: String,
//    @SerializedName("data") val categoryId: String,
//    @SerializedName("data") val cityId: Any,
//    @SerializedName("data") val createdAt: Long,
//    @SerializedName("data") val defaultImageURL: String,
//    @SerializedName("data") val deletedAt: Any,
//    @SerializedName("data") val descriptionAr: String,
//    @SerializedName("data") val descriptionEn: String,
//    @SerializedName("data") val descriptionUr: String,
//    @SerializedName("data") val events: Any,
//    @SerializedName("data") val gender: String,
//    @SerializedName("data") val id: String,
//    @SerializedName("data") val isActive: Boolean,
//    @SerializedName("data") val isDeleted: Boolean,
//    @SerializedName("data") val isFeatured: Boolean,
//    @SerializedName("data") val keywords: Any,
//    @SerializedName("data") val nameAr: String,
//    @SerializedName("data") val nameEn: String,
//    @SerializedName("data") val nameUr: String,
    @SerializedName("price") val price: Double,
//    @SerializedName("data") val productCategory: ProductCategory,
//    @SerializedName("data") val provider: Provider,
//    @SerializedName("data") val providerId: String,
    @SerializedName("quantity") val quantity: Double,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("name") val name: String,

//    @SerializedName("data") val tags: Any,
//    @SerializedName("data") val updatedAt: Long,
//    @SerializedName("data") val weight: String
) : IdentityGeneralResponse()
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