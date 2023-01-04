package com.ddk.ramenlab.model

import androidx.annotation.DrawableRes

data class Ramen(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val ranking: Int? = null,
    val share: String? = null
)