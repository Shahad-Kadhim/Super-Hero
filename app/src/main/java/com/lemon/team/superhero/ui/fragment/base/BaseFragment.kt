package com.lemon.team.superhero.ui.fragment.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.viewbinding.ViewBinding
import com.lemon.team.superhero.util.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect

abstract class BaseFragment<VB : ViewBinding>() : Fragment() {

    abstract val layoutId: Int

    abstract val LOG_TAG: String
    lateinit var _binding: ViewBinding
    var binding: VB?
        get() = _binding as VB?
        set(value) = TODO()

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


//    suspend fun <T> collect(
//        repoValue: Flow<State<T?>>, liveValue: MutableLiveData<State<T?>>
//    ) {
//        repoValue
//            .catch { Log.i("ERROR", "Error Repo") }
//            .collect { liveValue.value = it }
//    }

}