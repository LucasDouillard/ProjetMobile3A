package com.example.projetmobile.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetmobile.presentation.Singletons
import com.example.projetmobile.presentation.api.HsListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardListViewModel() : ViewModel(){


    
    val cardList : MutableLiveData<CardModel> = MutableLiveData()

    var set:String = "classic"


   public fun callApi(set:String) {
        cardList.value = CardLoader
        Singletons.hsApi.getCardList(set,"bf7c3ced5bmsh161ba77a16443fep14bcc7jsn294e5fd5606b", "frFR","1").enqueue(object:
            Callback<List<Card>> {
            override fun onFailure(call: Call<List<Card>>, t: Throwable) {
                cardList.value = CardError
            }

            override fun onResponse(call: Call<List<Card>>, response: Response<List<Card>>) {
                if(response.isSuccessful && response.body() !=null){
                    val hsListResponse : List<Card> = response.body()!!

                    cardList.value = CardSuccess(hsListResponse)
                    //adapter.updateList(hsResponse.Classic)
                //    adapter.updateList(hsListResponse.Naxxramas)
                } else {
                    cardList.value = CardError
                }
            }
        })
    }


}

