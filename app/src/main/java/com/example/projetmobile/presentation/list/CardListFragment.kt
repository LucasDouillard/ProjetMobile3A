package com.example.projetmobile.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetmobile.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CardListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CardAdapter(listOf())
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

        val cardList = arrayListOf<Card>().apply {
            add(Card("Nat paggle"))
            add(Card("Le roi liche"))
            add(Card("Chasse marée murloc"))
        }


        adapter.updateList(cardList)
    }
}