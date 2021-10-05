package com.lemon.team.superhero.ui.fragment.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>() : Fragment() {

    abstract val layoutId: Int

    abstract val LOG_TAG: String
    lateinit var _binding: ViewBinding
    var binding: VB?
        get() = _binding as VB?
        set(value) = TODO()


    abstract val presenter:BasePresenter

    abstract val bindingInflater: (LayoutInflater) -> VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        bindingInflater(inflater).apply { _binding = this }.root

    abstract fun setUp()


}