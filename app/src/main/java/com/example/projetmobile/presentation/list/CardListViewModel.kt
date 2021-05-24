package com.example.projetmobile.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.projetmobile.presentation.Singletons
import com.example.projetmobile.presentation.api.HsListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CardListViewModel : ViewModel(){
    
    val cardList : MutableLiveData<List<Card>> = MutableLiveData()

    init{
        callApi()
    }

    private fun callApi() {
        Singletons.hsApi.getCardList("bf7c3ced5bmsh161ba77a16443fep14bcc7jsn294e5fd5606b", "frFR","1").enqueue(object:
            Callback<HsListResponse> {
            override fun onFailure(call: Call<HsListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<HsListResponse>, response: Response<HsListResponse>) {
                if(response.isSuccessful && response.body() !=null){
                    val hsListResponse : HsListResponse = response.body()!!

                    cardList.value = hsListResponse.Naxxramas
                    //adapter.updateList(hsResponse.Classic)
                //    adapter.updateList(hsListResponse.Naxxramas)
                }
            }
        })
    }


}

