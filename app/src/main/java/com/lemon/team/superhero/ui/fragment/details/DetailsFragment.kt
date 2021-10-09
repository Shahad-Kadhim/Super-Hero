package com.lemon.team.superhero.ui.fragment.details

import android.util.Log
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.FragmentDetailsBinding
import com.lemon.team.superhero.model.reponse.Powerstats
import com.lemon.team.superhero.model.reponse.SuperHeroInfoResponse
import com.lemon.team.superhero.ui.fragment.base.BasePresenter
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.util.State

class DetailsFragment : BaseFragment<FragmentDetailsBinding,DetailsPresenter>(),IDetailsView {
    val args:DetailsFragmentArgs by navArgs()
    override val LOG_TAG: String = "DETAILS_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate
    override val getPresenter: BasePresenter =DetailsPresenter(this)

    override fun setUp() {
        presenter?.apply {
            getSuperHeroInfo(args.superHeroId)
        }
    }


    override fun callbacks() {

    }


    override fun onResponseSuperHeroInfo(state: State<SuperHeroInfoResponse?>) {
        when(state){
            is State.Error -> onError(state.message)
            State.Loading -> onLoading()
            is State.Success -> onSuccess(state.data)
        }
    }

    private fun onError(message: String) {
        Log.i("TAG","ERROR $message")
    }

    private fun onLoading() {
        Log.i("TAG","Loading")
    }

    private fun onSuccess(data: SuperHeroInfoResponse?) {
        data?.let {
            bindLayout(it)
        }
    }

    private fun bindLayout(data:SuperHeroInfoResponse){
        binding?.apply {
            superHeroName.text=data.name
            superHeroActor.text=data.biography?.fullName
            Glide.with(image).load(data.image?.url).centerCrop().into(image)
//            eyeColor.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.purple_500))
            data.powerstats?.let { powerState ->
                bindPowerState(powerState)
            }

        }
    }

    private fun bindPowerState(powerState:Powerstats){
        binding?.apply {
            powerState.speed?.toIntOrNull()?.let { speed ->
                speedProgress.progress=speed
            }
            powerState.durability?.toIntOrNull()?.let { durability ->
                durabilityProgress.progress=durability
            }
            powerState.power?.toIntOrNull()?.let { power ->
                powerProgress.progress=power
            }
            powerState.strength?.toIntOrNull()?.let { strength ->
                strengthProgress.progress=strength
            }
        }
    }


}