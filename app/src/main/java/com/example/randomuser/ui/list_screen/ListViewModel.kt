package com.example.randomuser.ui.list_screen

import androidx.lifecycle.*
import com.example.randomuser.data.repository.contract.Repository
import com.example.randomuser.model.Gender
import com.example.randomuser.model.Resource
import com.example.randomuser.model.User
import com.example.randomuser.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: Repository
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>> = _users

    fun getUsers(gender: Gender, size: Int) {
        repository.getUsers(
            gender = gender,
            page = if (size <= 0) 1 else (size / Constants.RESULT_SIZE) + 1
        )
            .onEach { _users.postValue(it) }
            .launchIn(viewModelScope)
    }

}