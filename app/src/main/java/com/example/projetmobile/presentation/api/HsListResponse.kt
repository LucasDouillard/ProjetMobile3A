package com.example.projetmobile.presentation.api

import com.example.projetmobile.presentation.list.Card

data class HsListResponse(
    val Classic :List<Card>,
    val Naxxramas :List<Card>
)