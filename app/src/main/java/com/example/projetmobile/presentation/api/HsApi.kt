package com.example.projetmobile.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface HsApi {
    @GET("cards")
    fun getCardList(@Query("rapidapi-key") key : String,@Query("locale") lang : String,@Query("collectible") collectible : String): Call<HsResponse>
}