package com.ddk.ramenlab.model

import androidx.annotation.DrawableRes

class RecipeImage (
    @DrawableRes
    val recipeImageResourceId: Int,
    val content: String
)