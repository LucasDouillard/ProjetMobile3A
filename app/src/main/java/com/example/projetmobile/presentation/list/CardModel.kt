package com.example.projetmobile.presentation.list

sealed class CardModel

data class CardSuccess(val cardList:List<Card>) :CardModel()
object CardLoader : CardModel()
object CardError : CardModel()