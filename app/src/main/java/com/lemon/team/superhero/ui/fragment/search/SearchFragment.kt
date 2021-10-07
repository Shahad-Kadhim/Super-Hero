package com.lemon.team.superhero.ui.fragment.search

import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.FragmentSearchBinding
import com.lemon.team.superhero.model.reponse.SuperHeroSearchResultResponse
import com.lemon.team.superhero.ui.IView
import com.lemon.team.superhero.ui.fragment.SuperHeroInteractionListener
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.util.goToFragment
import com.lemon.team.superhero.util.hide
import com.lemon.team.superhero.util.onClickSearch
import com.lemon.team.superhero.util.show


class SearchFragment : BaseFragment<FragmentSearchBinding,SearchPresenter>(),IView ,SuperHeroInteractionListener{
    private val args:SearchFragmentArgs by navArgs()
    override val LOG_TAG: String = "SEARCH_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
    override val getPresenter=SearchPresenter(this)

    private fun search(query:String){
        presenter?.searchByName(query)
    }

    override fun setUp() {
        args.query.also {
            binding?.searchField?.setText(it)
            search(it)
        }
    }

    override fun callbacks() {
        binding?.apply {
            searchField.onClickSearch { query->
                search(query)
            }
            backBtn.setOnClickListener {view ->
                view.findNavController().popBackStack()
            }
        }
    }

    override fun <T> onSuccess(data: T) {
        Log.i("TAG","SUCCESS")
        binding?.apply {
            (data as SuperHeroSearchResultResponse).results?.let {
                recycler.apply {
                    adapter = SearchRecyclerAdapter(it,this@SearchFragment)
                    this.show()
                }
            }
            error.hide()
            loading.hide()
        }
    }

    override fun onError(message: String) {
        Log.i("TAG","ERROR")
        requireActivity().runOnUiThread {
            binding?.apply {
                error.show()
                loading.hide()
                recycler.hide()
            }
        }
    }

    override fun onLoading() {
        Log.i("TAG","Loading")
        binding?.apply {
            loading.show()
            error.hide()
            recycler.hide()
        }
    }


    override fun onClickItem(superHeroId: String) {
        binding?.root?.goToFragment(SearchFragmentDirections.actionSearchFragmentToDetailsFragment(superHeroId))
    }

}