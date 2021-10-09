package com.lemon.team.superhero.ui.fragment.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.ItemHomeSuperHeroBinding
import com.lemon.team.superhero.model.reponse.SuperHeroInfoResponse
import com.lemon.team.superhero.ui.fragment.SuperHeroInteractionListener
import com.lemon.team.superhero.ui.fragment.base.BaseRecyclerAdapter

class HomeRecyclerAdapter(items:List<SuperHeroInfoResponse>,  listener: SuperHeroInteractionListener)
    :BaseRecyclerAdapter<SuperHeroInfoResponse,SuperHeroInteractionListener>(items,listener){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_home_super_hero, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if(holder is ItemViewHolder){
            bindItem( getItems()[position] , holder )
        }
    }

    class ItemViewHolder(view: View):BaseViewHolder(view) {
        val binding=ItemHomeSuperHeroBinding.bind(view)
    }

    private fun bindItem(superHero:SuperHeroInfoResponse,holder:ItemViewHolder){
        holder.binding.apply {
            name.text=superHero.name
            Glide.with(image).load(superHero.image?.url).into(image)
            root.setOnClickListener {
                superHero.id?.let { id ->
                    listener.onClickItem(id)
                }
            }
        }

    }

}

