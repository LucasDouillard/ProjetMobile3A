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
class SetListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = SetAdapter(listOf(), ::onClickedSet)



    private val viewModel:CardListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_list, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.set_recyclerview)


        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@SetListFragment.adapter
        }

        val setList: ArrayList<String> = arrayListOf<String>().apply{
            add("Classique")
            add("Naxxramas")
            add("Goblins vs Gnomes")
            add("Le Mont Rochenoire")
            add("Le Grand Tournoi")
            add("La Ligue des Explorateurs")
            add("Les Murmures des Dieux très anciens")
            add("Une nuit à Karazhan")
            add("Main basse sur Gadgetzan")
            add("Voyage au centre d’Un’Goro")
            add("Chevaliers du Trône de glace")
            add("Kobolds et catacombes")
            add("Bois Maudit")
            add("Projet Armageboum")
            add("Les Jeux de Rastakhan")
            add("L'Éveil des ombres")
            add("Les Aventuriers d’Uldum")
            add("L'Envol des Dragons")
            add("Les Cendres de l'Outreterre")
            add("L'Académie Scholomance")
            add("Folle journée à Sombrelune")
            add("Forgés dans les Tarides")
        }

        adapter.updateList(setList)
    }


private fun onClickedSet(set: String) {
    val set2:String
    when (set) {
        "Classique" -> set2 = "classic"
        "Le Mont Rochenoire" -> set2 = "Blackrock Mountain"
        "Le Grand Tournoi" -> set2 = "The Grand Tournament"
        "La Ligue des Explorateurs" -> set2 = "The League of Explorers"
        "Les Murmures des Dieux très anciens" -> set2 = "Whispers of the Old Gods"
        "Une nuit à Karazhan" -> set2 = "One Night in Karazhan"
        "Main basse sur Gadgetzan" -> set2 = "Mean Streets of Gadgetzan"
        "Voyage au centre d’Un’Goro" -> set2 = "Journey to Un'Goro"
        "Chevaliers du Trône de glace" -> set2 = "Knights of the Frozen Throne"
        "Kobolds et catacombes" -> set2 = "Kobolds & Catacombs"
        "Bois Maudit" -> set2 = "The WitchWood"
        "Projet Armageboum" -> set2 = "Boomsday Project"
        "Les Jeux de Rastakhan" -> set2 = "Rastakhan's Rumble"
        "L'Éveil des ombres" -> set2 = "Rise of Shadows"
        "Les Aventuriers d’Uldum" -> set2 = "Saviors of Uldum"
        "Le Mont Rochenoire" -> set2 = "Blackrock Mountain"
        "Le Mont Rochenoire" -> set2 = "Blackrock Mountain"
        "Le Mont Rochenoire" -> set2 = "Blackrock Mountain"
        "Le Mont Rochenoire" -> set2 = "Blackrock Mountain"
        else -> set2 = set
    }
    findNavController().navigate(R.id.navigateToCardListFragment, bundleOf(
        "set" to set2
    ))
}
}