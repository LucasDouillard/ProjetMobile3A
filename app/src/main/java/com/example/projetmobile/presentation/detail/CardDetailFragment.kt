package com.example.projetmobile.presentation.detail

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.projetmobile.R
import com.example.projetmobile.presentation.Singletons
import com.example.projetmobile.presentation.api.HsDetailResponse
import com.example.projetmobile.presentation.api.HsListResponse
import com.example.projetmobile.presentation.list.Card
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("DEPRECATION")
class CardDetailFragment : Fragment() {


    private lateinit var textViewName: TextView
    private lateinit var imageView: ImageView





    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.card_detail_name)
        imageView = view.findViewById(R.id.card_img)
        callApi()
        }

    private fun callApi()
    {
        val cardId: String = arguments?.getString("cardId")?:"NULL"
        Singletons.hsApi.getCardDetail(cardId,"bf7c3ced5bmsh161ba77a16443fep14bcc7jsn294e5fd5606b", "frFR","1").enqueue(object:
            Callback<List<HsDetailResponse>> {
            override fun onFailure(call: Call<List<HsDetailResponse>>, t: Throwable) {
            }

            override fun onResponse(call: Call<List<HsDetailResponse>>, response: Response<List<HsDetailResponse>>) {
                if(response.isSuccessful && response.body() !=null){
                    //textViewName.text = "Coût en mana : "+response.body()!!.get(0).cost+"\nTexte : "+response.body()!!.get(0).text
                    textViewName.setText(Html.fromHtml("<h2>"+response.body()!!.get(0).name+"</h2><br><p>"+response.body()!!.get(0).text+"</p>"+"<br>Cout en Mana : "+response.body()!!.get(0).cost));
                    Glide
                        .with(imageView)
                        .load(response.body()!!.get(0).img)
                        .centerCrop()
                        .into(imageView);

                }
            }

        })
    }

}