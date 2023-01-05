package com.ddk.ramenlab.data

import com.ddk.ramenlab.R
import com.ddk.ramenlab.model.Ramen

object RamenData {
    val topRamen: List<Ramen> = listOf(
        Ramen(R.drawable.ramen1, "진라면", ranking = 1),
        Ramen(R.drawable.ramen2, "신라면", ranking = 2),
        Ramen(R.drawable.ramen3, "불닭볽음면", ranking = 3),
        Ramen(R.drawable.ramen1, "진라면", ranking = 4),
        Ramen(R.drawable.ramen2, "신라면", ranking = 5),
        Ramen(R.drawable.ramen3, "불닭볽음면", ranking = 6),
    )
    val newRamen: List<Ramen> = listOf(
        Ramen(R.drawable.ramen1, "진라면"),
        Ramen(R.drawable.ramen2, "신라면"),
        Ramen(R.drawable.ramen3, "불닭볽음면"),
        Ramen(R.drawable.ramen1, "진라면"),
        Ramen(R.drawable.ramen2, "신라면"),
        Ramen(R.drawable.ramen3, "불닭볽음면"),
    )
    val ranking: List<Ramen> = listOf(
        Ramen(R.drawable.ramen1, "진라면", share = "19.6"),
        Ramen(R.drawable.ramen2, "신라면", share = "19.6"),
        Ramen(R.drawable.ramen3, "불닭볽음면", share = "19.6"),
        Ramen(R.drawable.ramen1, "진라면", share = "19.6"),
        Ramen(R.drawable.ramen2, "신라면", share = "19.6"),
        Ramen(R.drawable.ramen3, "불닭볽음면", share = "19.6"),
        Ramen(R.drawable.ramen1, "진라면", share = "19.6"),
        Ramen(R.drawable.ramen2, "신라면", share = "19.6"),
        Ramen(R.drawable.ramen3, "불닭볽음면", share = "19.6"),
        Ramen(R.drawable.ramen1, "진라면", share = "19.6"),
        Ramen(R.drawable.ramen2, "신라면", share = "19.6"),
        Ramen(R.drawable.ramen3, "불닭볽음면", share = "19.6"),
    )
}