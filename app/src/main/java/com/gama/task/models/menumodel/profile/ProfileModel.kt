package com.gama.task.models.menumodel.profile

import com.gama.task.models.menumodel.profile.Data

data class ProfileModel(
    val `data`: Data,
    val errors: List<Any>,
    val msg: String,
    val status: Int
)