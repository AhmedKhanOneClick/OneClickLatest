package com.gama.task.models.menumodel.profile

import com.gama.task.models.menumodel.profile.Credential

data class Data(
    val createdAt: Long,
    val createdBy: Any,
    val credential: Credential,
    val credentialId: String,
    val deviceId: String,
    val firstName: String,
    val id: String,
    val imgUrl: Any,
    val isDeleted: Boolean,
    val isVerified: Any,
    val language: Any,
    val lastName: String,
    val latitude: Int,
    val longitude: Int,
    val phoneNumber: String,
    val posCode: String,
    val shopName: String,
    val shopNameArabic: String,
    val updatedAt: Long,
    val username: String,
    val vat: Int
)