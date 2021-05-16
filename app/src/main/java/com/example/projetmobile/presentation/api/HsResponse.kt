package com.example.projetmobile.presentation.api

import com.example.projetmobile.presentation.list.Card

data class HsResponse(
    val Classic :List<Card>,
    val Naxxramas :List<Card>
)