package com.lemon.team.superhero.ui.fragment.information.groupAffiliation

import android.view.LayoutInflater
import com.lemon.team.superhero.databinding.FragmentGroupAffiliationBinding
import com.lemon.team.superhero.ui.fragment.base.BaseFragment
import com.lemon.team.superhero.ui.fragment.base.BasePresenter

class GroupAffiliationFragment : BaseFragment<FragmentGroupAffiliationBinding, GroupAffiliationPresenter>() {
    override val LOG_TAG: String = "Group_Affiliation_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentGroupAffiliationBinding =
        FragmentGroupAffiliationBinding::inflate
    override val getPresenter: BasePresenter = GroupAffiliationPresenter()

    override fun setUp() {

    }

    override fun callbacks() {

    }

}