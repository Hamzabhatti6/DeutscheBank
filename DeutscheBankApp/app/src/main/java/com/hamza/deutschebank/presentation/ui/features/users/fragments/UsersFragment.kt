package com.hamza.deutschebank.presentation.ui.features.users.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import com.hamza.deutschebank.R
import com.hamza.deutschebank.data.users.domain.Users
import com.hamza.deutschebank.databinding.FragmentUsersBinding
import com.hamza.deutschebank.presentation.ui.features.users.adapters.UsersAdapter
import com.hamza.deutschebank.presentation.ui.features.users.navigation.UserOnClick
import com.hamza.deutschebank.presentation.ui.features.users.viewmodels.UsersViewModel
import com.hamza.deutschebank.utils.LoaderDialogManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UsersFragment : Fragment(), UserOnClick {
    lateinit var binding: FragmentUsersBinding

    private val viewModel: UsersViewModel by viewModels()

    private val usersList = ArrayList<Users>()

    @Inject
    lateinit var adapter: UsersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentUsersBinding.inflate(inflater, container, false)
        binding.rvSuggetion.adapter = adapter
        adapter.setConfig(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        observer()
        viewModel.getUsers()
    }

    private fun observer() {
        viewModel.usersList.observe(viewLifecycleOwner) { users ->
            usersList.clear()
            users.usersList?.let { usersList.addAll(it) }
            adapter.setUsersList(usersList)
        }

        viewModel.showLoader.observe(viewLifecycleOwner) {
            if (it) {
                LoaderDialogManager.show(requireActivity())
            } else {
                LoaderDialogManager.dismiss()
            }
        }
    }

    override fun onClick(position: Int) {
     //   viewModel.setUser(usersList[position])

        val user = usersList[position]
        val gson = Gson()
        val userString = gson.toJson(user)

        findNavController().navigate(R.id.action_usersFragment_to_userDetailFragment, Bundle().apply {
            putString("user", userString)
        })
    }

}