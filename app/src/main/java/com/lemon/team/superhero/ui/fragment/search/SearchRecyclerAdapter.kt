package com.lemon.team.superhero.ui.fragment.search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.ItemSearchOfSuperHeroBinding
import com.lemon.team.superhero.model.reponse.SuperHeroInfoResponse
import com.lemon.team.superhero.ui.fragment.SuperHeroInteractionListener
import com.lemon.team.superhero.ui.fragment.base.BaseRecyclerAdapter

class SearchRecyclerAdapter(items:List<SuperHeroInfoResponse>, listener: SuperHeroInteractionListener)
    :BaseRecyclerAdapter<SuperHeroInfoResponse,SuperHeroInteractionListener>(items,listener){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_search_of_super_hero, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if(holder is ItemViewHolder){
            bindItem(holder, getItems()[position] )
        }
    }

    class ItemViewHolder(view: View):BaseViewHolder(view) {
        val binding=ItemSearchOfSuperHeroBinding.bind(view)
    }

    private fun bindItem(holder:ItemViewHolder,superHero:SuperHeroInfoResponse){
        holder.binding.apply {
            characterName.text=superHero.name
            actor.text=superHero.biography?.fullName
            Glide.with(image).load(superHero.image?.url).centerCrop().into(image)
            image.transitionName=superHero.id
            Log.i("TRANSTION NAME >>>>>>",image.transitionName)
            root.setOnClickListener {
                superHero.id?.let { id ->
                    listener.onClickItem(id,image)
                }
            }
        }

    }

}

