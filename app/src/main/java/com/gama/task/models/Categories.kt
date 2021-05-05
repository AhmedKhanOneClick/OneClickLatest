package com.gama.task.models


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data  class Categories(
//    @SerializedName("data") val `data`: Data,
//    @SerializedName("server_knowledge")  val errors: List<Any>,
    @SerializedName("msg")   val msg: String,
//    @SerializedName("server_knowledge")  val status: Int
)
//
//data class Data(
//    @SerializedName("content")   val content: List<Content>
//)
//
//data class Content(
//    val createdAt: String,
//    val deletedAt: Any,
//    val descriptionAr: String,
//    val descriptionEn: String,
//    val descriptionUr: String,
//    val id: String,
//    val imageURL: Any,
//    val isActive: Boolean,
//    val isDeleted: Boolean,
//    val key: String,
//    val nameAr: String,
//    val nameEn: String,
//    val nameUr: String,
//    val parentId: Any,
//    val subcategories: List<Subcategory>,
//    val updatedAt: String
//)
//
//data class Subcategory(
//    val createdAt: String,
//    val deletedAt: Any,
//    val descriptionAr: String,
//    val descriptionEn: String,
//    val descriptionUr: String,
//    val id: String,
//    val imageURL: Any,
//    val isActive: Boolean,
//    val isDeleted: Boolean,
//    val key: String,
//    val nameAr: String,
//    val nameEn: String,
//    val nameUr: String,
//    val parentId: String,
//    val subcategories: List<SubcategoryX>,
//    val updatedAt: String
//)
//
//data class SubcategoryX(
//    val createdAt: String,
//    val deletedAt: Any,
//    val descriptionAr: String,
//    val descriptionEn: String,
//    val descriptionUr: String,
//    val id: String,
//    val imageURL: Any,
//    val isActive: Boolean,
//    val isDeleted: Boolean,
//    val key: String,
//    val nameAr: String,
//    val nameEn: String,
//    val nameUr: String,
//    val parentId: String,
//    val subcategories: List<Any>,
//    val updatedAt: String
//)