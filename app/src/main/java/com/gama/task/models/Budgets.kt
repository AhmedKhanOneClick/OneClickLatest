package com.gama.task.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * @author Wellington Costa on 30/12/2017.
 */
@Keep
data class Budgets(
    @SerializedName("budgets") val budgets: List<BudgetsResponse>,
    @SerializedName("default_budget") val default_budget: String
) {

    @Keep
    data class BudgetsResponse(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("last_modified_on") val type: String,
        @SerializedName("first_month") val first_month: String,
        @SerializedName("last_month") val last_month: String,
        @SerializedName("currency_format") val currency_format: CurrencyFormat,
        @SerializedName("accounts") val accounts: List<Accounts1>

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

        @Keep
        data class CurrencyFormat(
            @SerializedName("iso_code") val iso_code: String
        )
    }
}