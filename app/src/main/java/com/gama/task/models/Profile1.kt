package com.gama.task.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@Keep
@RealmClass
open class Profile1 (
    @SerializedName("id") var id: String? = ""
) : RealmModel