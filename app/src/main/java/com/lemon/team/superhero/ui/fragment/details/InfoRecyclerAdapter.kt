package com.lemon.team.superhero.ui.fragment.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.*
import com.lemon.team.superhero.model.domain.Info
import com.lemon.team.superhero.model.domain.Type
import com.lemon.team.superhero.model.reponse.Appearance
import com.lemon.team.superhero.ui.fragment.base.BaseRecyclerAdapter

class InfoRecyclerAdapter(items:List<Info<Any>>, listener:InfoInteractionListener)
    : BaseRecyclerAdapter<Info<Any>,InfoInteractionListener>(items,listener){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
       return when(viewType){
            APPEARANCE_KEY ->{
                AppearanceViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_appearance, parent, false)
                )
            }
            Aliases_KEY ->{
                AliasesViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_aliases, parent, false)
                )
            }
            else ->{
                ConnectionsViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_connections, parent, false)
                )
            }
       }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        position
        when(holder){
            is AppearanceViewHolder ->{
                bindAppearanceItem(holder,position)
            }
            is AliasesViewHolder ->{
                bindAliasesItem(holder ,position)
            }
            is ConnectionsViewHolder ->{
                bindConnectionsItem(holder,position)
            }
        }
    }

    private fun bindAppearanceItem(holder: AppearanceViewHolder, position: Int) {
        val currentItem=getItems()[position] as Info<Appearance>
        holder.binding.apply {
            //TODO
        }
    }

    private fun bindAliasesItem(holder: AliasesViewHolder, position: Int) {
        val currentItem=getItems()[position] as Info<List<String?>>
        holder.binding.apply {
            //TODO
        }
    }

    private fun bindConnectionsItem(holder: ConnectionsViewHolder, position: Int) {
        val currentItem=getItems()[position] as Info<String?>
        holder.binding.apply {
            if(currentItem.type==Type.GroupAffiliation){
                //TODO
            }
            else{
                //TODO
            }

        }
    }


    override fun getItemViewType(position: Int) =
        when(getItems()[position].type){
            Type.APPEARANCE -> APPEARANCE_KEY
            Type.Relatives , Type.GroupAffiliation -> Connections_KEY
            Type.Aliases -> Aliases_KEY
        }


    class AppearanceViewHolder(view: View):BaseViewHolder(view) {
        val binding= ItemAppearanceBinding.bind(view)
    }

    class AliasesViewHolder(view: View):BaseViewHolder(view) {
        val binding=ItemAliasesBinding.bind(view)
    }

    class ConnectionsViewHolder(view: View):BaseViewHolder(view) {
        val binding=ItemConnectionsBinding.bind(view)
    }

    companion object{
        const val APPEARANCE_KEY =0
        const val Connections_KEY =1
        const val Aliases_KEY =3
    }

}