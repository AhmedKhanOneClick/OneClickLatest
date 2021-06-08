package com.gama.task.models


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@Keep
@RealmClass
open class UserAuth(
    @SerializedName("token") var token: String = "",
    @SerializedName("id") var id: String = "",
//    @SerializedName("expires_in") var expiresIn: Int = 0,
//    @SerializedName("refresh_token") var refresh_token: String = "",
//    @SerializedName("scope") var scope: String = "",

//    @SerializedName("token_type") var tokenType: String = "Bearer ",
//    var email: String = "",
//    var password: String = "",
//    var access_token: String = "",
//    @SerializedName("profile") val profile: User_Profile,
    var email: String = "",
    var password: String = "",
) : RealmModel {

    @PrimaryKey
    var databaseID: Int = 1
}
