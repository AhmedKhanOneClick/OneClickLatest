package com.gama.task.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * @author Wellington Costa on 30/12/2017.
 */
@Keep
data class Accounts(
    @SerializedName("accounts") val accounts: List<Accounts1>,
    @SerializedName("server_knowledge") val server_knowledge: Int
) {

    @Keep
    data class Accounts1(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("type") val type: String,
        @SerializedName("on_budget") val on_budget: Boolean,
        @SerializedName("closed") val closed: Boolean,
        @SerializedName("note") val note: String,
        @SerializedName("balance") val balance: Int,
        @SerializedName("cleared_balance") val cleared_balance: Int,
        @SerializedName("uncleared_balance") val uncleared_balance: Int,
        @SerializedName("transfer_payee_id") val transfer_payee_id: String,
        @SerializedName("deleted") val deleted: Boolean
    )
}