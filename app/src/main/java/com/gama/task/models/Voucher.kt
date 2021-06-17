package com.gama.task.models

data class Voucher(
    val code: String,
    val createdAt: String,
    val expireAt: Long,
    val id: String,
    val isDeleted: Boolean,
    val isUsed: Boolean,
    val orderId: String,
    val productId: String,
    val updatedAt: String
)