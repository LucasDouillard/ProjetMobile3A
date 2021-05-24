package com.example.projetmobile.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.R
import com.example.projetmobile.presentation.Singletons
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
    private lateinit var loader: ProgressBar
    private lateinit var errorText: TextView

    val set: String = arguments?.getString("set")?:"NULL"

    private val adapter = CardAdapter(listOf(), ::onClickedCard)



    private val viewModel:CardListViewModel by viewModels()





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
        loader = view.findViewById(R.id.card_loader)
        errorText = view.findViewById(R.id.card_error)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@CardListFragment.adapter
        }

        viewModel.callApi(arguments?.getString("set")?:"NULL")

        viewModel.cardList.observe(viewLifecycleOwner, Observer { cardModel->
            loader.isVisible = cardModel is CardLoader
            errorText.isVisible = cardModel is CardError

            if(cardModel is CardSuccess) {
                adapter.updateList(cardModel.cardList)
            }


        })

    }
    private fun onClickedCard(cardId: String) {
            findNavController().navigate(R.id.navigateToCardDetailFragment, bundleOf(
                    "cardId" to cardId
            ))
    }
}