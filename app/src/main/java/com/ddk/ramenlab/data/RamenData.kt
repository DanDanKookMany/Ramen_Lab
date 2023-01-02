package com.ddk.ramenlab.data

import com.ddk.ramenlab.R
import com.ddk.ramenlab.model.Ramen

object RamenData {
    val topRamen: List<Ramen> = listOf(
        Ramen(R.drawable.ramen1, "진라면", 1),
        Ramen(R.drawable.ramen2, "신라면", 2),
        Ramen(R.drawable.ramen3, "불닭볽음면", 3),
        Ramen(R.drawable.ramen1, "진라면", 4),
        Ramen(R.drawable.ramen2, "신라면", 5),
        Ramen(R.drawable.ramen3, "불닭볽음면", 6),
    )
    val newRamen: List<Ramen> = listOf(
        Ramen(R.drawable.ramen1, "진라면"),
        Ramen(R.drawable.ramen2, "신라면"),
        Ramen(R.drawable.ramen3, "불닭볽음면"),
        Ramen(R.drawable.ramen1, "진라면"),
        Ramen(R.drawable.ramen2, "신라면"),
        Ramen(R.drawable.ramen3, "불닭볽음면"),
    )
}