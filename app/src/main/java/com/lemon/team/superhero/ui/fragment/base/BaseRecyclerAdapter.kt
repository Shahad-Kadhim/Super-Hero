package com.lemon.team.superhero.ui.fragment.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lemon.team.superhero.ui.fragment.SuperHeroInteractionListener

abstract class BaseRecyclerAdapter<T>(
    private val items: List<T>,
    val listener: SuperHeroInteractionListener,
) :RecyclerView.Adapter<BaseRecyclerAdapter.BaseViewHolder>() {

    fun getItems() =items
    override fun getItemCount() = items.size
    abstract class BaseViewHolder(view: View):RecyclerView.ViewHolder(view)

}