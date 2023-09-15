package com.hamza.deutschebank.presentation.ui.features.users.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.hamza.deutschebank.BR
import com.hamza.deutschebank.data.users.domain.Users
import com.hamza.deutschebank.databinding.FragmentUserDetailBinding
import com.hamza.deutschebank.presentation.ui.features.users.viewmodels.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@AndroidEntryPoint
class UserDetailFragment : Fragment() {
    lateinit var binding: FragmentUserDetailBinding
    private var user: Users? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val gson = Gson()
            user = gson.fromJson(it.getString("user"), Users::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =  FragmentUserDetailBinding.inflate(inflater, container, false)
        binding.setVariable(BR.model,user)

        return binding.root
    }

}