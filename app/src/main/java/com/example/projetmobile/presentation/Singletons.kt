package com.example.projetmobile.presentation

import com.example.projetmobile.presentation.CardApplication.Companion.context
import com.example.projetmobile.presentation.api.HsApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons{
    companion object {


        var cache = Cache(File(context?.cacheDir,"responses"),10 * 1024 * 1024)

        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()

        val hsApi: HsApi = Retrofit.Builder()
                .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(HsApi::class.java)



    }
}
