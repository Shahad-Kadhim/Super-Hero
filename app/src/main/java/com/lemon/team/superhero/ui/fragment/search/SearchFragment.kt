package com.lemon.team.superhero.ui.fragment.search

import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.lemon.team.superhero.databinding.FragmentSearchBinding
import com.lemon.team.superhero.model.reponse.SuperHeroSearchResultResponse
import com.lemon.team.superhero.ui.fragment.SuperHeroInteractionListener
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.util.*


class SearchFragment : BaseFragment<FragmentSearchBinding,SearchPresenter>(),SearchView ,SuperHeroInteractionListener{
    private val args:SearchFragmentArgs by navArgs()
    override val LOG_TAG: String = "SEARCH_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
    override val getPresenter=SearchPresenter(this)

    private fun search(query:String){
        presenter.searchByName(query)
    }

    override fun setUp() {
        setupTransition()
        args.query.also {
            binding.searchField.setText(it)
            search(it)
        }
    }

    private fun setupTransition() {
        sharedElementEnterTransition=TransitionInflater.from(activity).inflateTransition(android.R.transition.move)
    }


    override fun callbacks() {
        binding.apply {
            searchField.onClickSearch { query->
                search(query)
            }
            backBtn.setOnClickListener {view ->
                view.findNavController().popBackStack()
            }
        }
    }


    override fun  onResponseSearchingResult(state: State<SuperHeroSearchResultResponse?>) {
        when(state){
            is State.Error -> onError(state.message)
            State.Loading -> onLoading()
            is State.Success -> onSuccess(state.data)
        }
    }

    private fun onSuccess(data: SuperHeroSearchResultResponse?) {
        Log.i("TAG","SUCCESS")
        binding.apply {
            data?.results?.let {
                recycler.apply {
                    adapter = SearchRecyclerAdapter(it,this@SearchFragment)
                    this.show()
                }
            }
            error.hide()
            loading.hide()
        }
    }

    private fun onError(message: String) {
        Log.i("TAG","ERROR $message")
        binding.apply {
            error.show()
            loading.hide()
            recycler.hide()
        }
    }

    private fun onLoading() {
        Log.i("TAG","Loading")
        binding.apply {
            loading.show()
            error.hide()
            recycler.hide()
        }
    }

    override fun onClickItem(superHeroId: String) {
        binding.root.goToFragment(SearchFragmentDirections.actionSearchFragmentToDetailsFragment(superHeroId))
    }

}