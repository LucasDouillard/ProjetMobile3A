package com.example.projetmobile.presentation

import android.app.Application
import android.content.Context

class CardApplication : Application(){

    companion object{
        var context: Context? = null
    }

    override fun onCreate(){
        super.onCreate()
        context = this
    }
}