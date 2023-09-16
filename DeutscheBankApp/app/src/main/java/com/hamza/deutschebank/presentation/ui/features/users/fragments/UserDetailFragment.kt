package com.hamza.deutschebank.presentation.ui.features.users.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hamza.deutschebank.BR
import com.hamza.deutschebank.data.users.domain.Users
import com.hamza.deutschebank.databinding.FragmentUserDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : Fragment() {
    lateinit var binding: FragmentUserDetailBinding
    private var user: Users? = null
    val args: UserDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentUserDetailBinding.inflate(inflater, container, false)
        binding.setVariable(BR.model,args.user)
        init()
        return binding.root
    }
    fun init(){
        binding.layHeader.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}