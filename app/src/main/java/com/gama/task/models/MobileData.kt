package com.gama.task.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

/**
 * @author Wellington Costa on 30/12/2017.
 */
@Keep
data class MobileData (
//        @SerializedName("accounts") val accounts: List<Accounts1>,
//        @SerializedName("server_knowledge") val server_knowledge: Int
//) {
@SerializedName("data") val data: List<MobileData1>
) : IdentityGeneralResponse()

//}