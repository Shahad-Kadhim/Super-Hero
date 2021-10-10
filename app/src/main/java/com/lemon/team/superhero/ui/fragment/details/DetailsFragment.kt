package com.lemon.team.superhero.ui.fragment.details

import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.lemon.team.superhero.databinding.FragmentDetailsBinding
import com.lemon.team.superhero.model.domain.Info
import com.lemon.team.superhero.model.domain.Type
import com.lemon.team.superhero.model.reponse.Powerstats
import com.lemon.team.superhero.model.reponse.SuperHeroInfoResponse
import com.lemon.team.superhero.ui.fragment.base.BasePresenter
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.util.State

class DetailsFragment : BaseFragment<FragmentDetailsBinding,DetailsPresenter>(),IDetailsView ,InfoInteractionListener{
    private val args:DetailsFragmentArgs by navArgs()
    override val LOG_TAG: String = "DETAILS_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate
    override val getPresenter: BasePresenter =DetailsPresenter(this)

    override fun setUp() {
        presenter.apply {
            getSuperHeroInfo(args.superHeroId)
        }
    }


    override fun callbacks() {
        binding.backBtn.setOnClickListener {view ->
            view.findNavController().popBackStack()
        }
    }


    override fun onResponseSuperHeroInfo(state: State<SuperHeroInfoResponse?>) {
        when(state){
            is State.Error -> onError(state.message)
            State.Loading -> onLoading()
            is State.Success -> onSuccess(state.data)
        }
    }

    private fun onError(message: String) {
        Toast.makeText(requireContext(),"ERROR $message",Toast.LENGTH_SHORT).show()
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
        binding.apply {
            superHeroName.text=data.name
            superHeroActor.text=data.biography?.fullName
            Glide.with(image).load(data.image?.url).centerCrop().into(image)
            data.powerstats?.let { powerState ->
                bindPowerState(powerState)
            }
            bindInfoRecycler(getInfoList(data))
        }
    }

    private fun bindPowerState(powerState:Powerstats){
        binding.apply {
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


    private fun bindInfoRecycler(info:List<Info<Any>>) {
        binding.recycleInfo.apply {
            layoutManager = getUnScrolledLayoutManger()
            adapter= InfoRecyclerAdapter(info,this@DetailsFragment)
        }
    }

    private fun getUnScrolledLayoutManger() =
        object: LinearLayoutManager(requireContext(),HORIZONTAL,false){
            override fun canScrollHorizontally() =
                false
        }

    private fun getInfoList(data: SuperHeroInfoResponse) =
        listOf(
            Info(data.appearance, Type.APPEARANCE),
            Info(data.connections?.relatives,Type.Relatives),
            Info(data.connections?.groupAffiliation,Type.GroupAffiliation),
            Info(listOf(
                data.biography?.aliases.toString(),
                data.biography?.placeOfBirth
            ),Type.Aliases)
        ) as List<Info<Any>>


    override fun onClickNext(position:Int) {
        binding.recycleInfo.scrollToPosition(position+1)
    }

    override fun onClickPrevious(position:Int) {
        binding.recycleInfo.scrollToPosition(position-1)
    }


}