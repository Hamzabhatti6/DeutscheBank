package com.hamza.deutschebank.presentation.ui.features.users.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamza.deutschebank.data.users.domain.UsersData
import com.hamza.deutschebank.domain.usecases.users.UsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val usersUseCase: UsersUseCase
) : ViewModel() {

    private val _usersList: MutableLiveData<UsersData> = MutableLiveData()
    private val _showLoader: MutableLiveData<Boolean> = MutableLiveData(false)

    val usersList: MutableLiveData<UsersData> = _usersList
    val showLoader: MutableLiveData<Boolean> = _showLoader

    fun getUsers() {
        _showLoader.value = true
        viewModelScope.launch {
            val result = usersUseCase.execute()
            when (result) {
                is UsersUseCase.Result.Success -> {
                    _showLoader.value = false
                    _usersList.value = result.Users
                }
                is UsersUseCase.Result.Error -> {
                    _showLoader.value = false
                }
            }
        }
    }
}