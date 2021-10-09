package com.lemon.team.superhero.ui.fragment.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.lemon.team.superhero.R
import com.lemon.team.superhero.databinding.FragmentDetailsBinding
import com.lemon.team.superhero.model.reponse.Biography
import com.lemon.team.superhero.model.reponse.Powerstats
import com.lemon.team.superhero.ui.IView
import com.lemon.team.superhero.ui.fragment.base.BasePresenter
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.ui.fragment.information.relarives.RelativesFragmentArgs

class DetailsFragment : BaseFragment<FragmentDetailsBinding,DetailsPresenter>(),IDetailsView {
    val args:DetailsFragmentArgs by navArgs()
    override val LOG_TAG: String = "DETAILS_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentDetailsBinding =
        FragmentDetailsBinding::inflate
    override val getPresenter: BasePresenter =DetailsPresenter(this)

    override fun callbacks() {

    }

    override fun setUp() {
        presenter?.apply {
            getBiography(args.superHeroId)
            getPowerStats(args.superHeroId)
        }
//        val navHostFragment =
//            requireActivity().supportFragmentManager.findFragmentById(R.id.info_host) as NavHostFragment
//        val navController = navHostFragment.navController
//        val navGraph = navController.navInflater.inflate(R.navigation.info_nav_graph)
//        navGraph.startDestination = R.id.relativesFragment
//        navController.graph = navGraph
//        binding?.infoHost?.setupWithNavController(navController)


//        binding?.infoHost?.findNavController()?.setGraph(
//            R.navigation.info_nav_graph,
//            RelativesFragmentArgs("your values").toBundle()
//        )

        //    java.lang.NullPointerException: null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment
//        (requireActivity().supportFragmentManager.findFragmentById(R.id.info_host) as NavHostFragment)
//            .navController.setGraph(
//                R.navigation.info_nav_graph,
//                RelativesFragmentArgs("your values").toBundle()
//            )

        //work
        requireActivity().findNavController(R.id.info_host)
            .setGraph(
                R.navigation.info_nav_graph,
                RelativesFragmentArgs("your values").toBundle()
            )


    }

    override fun onSuccessBiography(data: Biography?) {
        binding?.apply {
            data?.let {
                superHeroName.text=it.name
                superHeroActor.text=it.fullName
            }
        }
    }

    override fun onSuccessPowerState(data: Powerstats?) {
        binding?.apply {
            data?.let {
                it.speed?.toIntOrNull()?.let { speed ->
                    speedProgress.progress=speed
                }
                it.durability?.toIntOrNull()?.let { durability ->
                    durabilityProgress.progress=durability
                }
                it.power?.toIntOrNull()?.let { power ->
                    powerProgress.progress=power
                }
                it.strength?.toIntOrNull()?.let { strength ->
                    strengthProgress.progress=strength
                }
            }
        }
    }

    override fun onError(message: String) {
        Log.i("TAG","ERROR")
    }

    override fun onLoading() {
        Log.i("TAG","Loading")
    }

}