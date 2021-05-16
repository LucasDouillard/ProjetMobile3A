package com.example.projetmobile.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.R
import com.example.projetmobile.presentation.api.*
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CardListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CardAdapter(listOf(), ::onClickedCard)



    private val layoutManager = LinearLayoutManager(context)


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_list, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.card_recyclerview)


        recyclerView.apply {
            layoutManager = this@CardListFragment.layoutManager
            adapter = this@CardListFragment.adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://omgvamp-hearthstone-v1.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val hsApi: HsApi = retrofit.create(HsApi::class.java)

        hsApi.getCardList("bf7c3ced5bmsh161ba77a16443fep14bcc7jsn294e5fd5606b", "frFR","1").enqueue(object:Callback<HsResponse>{
            override fun onFailure(call: Call<HsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<HsResponse>, response: Response<HsResponse>) {
                if(response.isSuccessful && response.body() !=null){
                    val hsResponse : HsResponse = response.body()!!
                    //adapter.updateList(hsResponse.Classic)
                    adapter.updateList(hsResponse.Naxxramas)
                }
            }

        })


//        val cardList = arrayListOf<Card>().apply {
//            add(Card("Nat paggle"))
//            add(Card("Le roi liche"))
//            add(Card("Chasse marée murloc"))
//        }


//        adapter.updateList(cardList)
    }
    private fun onClickedCard(card: Card) {
            findNavController().navigate(R.id.navigateToCardDetailFragment)
    }
}