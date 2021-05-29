package com.gama.task.ui.auth.login

import android.content.ContentValues.TAG
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*

import com.gama.task.models.UserAuth
//import com.gama.task.ui.common.DialogType
//import com.gama.task.ui.common.GeneralDialog
import com.gama.task.util.Event
import com.gama.task.data.repository.AuthRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * perform business logic and store ui states for [LoginFragment].
 */
class LoginViewModel @ViewModelInject constructor(private val authRepository: AuthRepository) :
    ViewModel() {

    /**
     * Pair of entered email and password entered by user.
     */
    private val userInfo: MutableLiveData<Pair<String, String>> = MutableLiveData()




    /**
     *  event to navigate to the main activity after the login completed successfully and stored.
     */
    private val _navigateToMainActivity = MutableLiveData<Event<Unit>>()

    /**
     * Immutable version of [_navigateToMainActivity]
     */
    val navigateToMainActivity = _navigateToMainActivity as LiveData<Event<Unit>>

    /**
     * send login request with user inputs every update of [userInfo].
     */
    val loginResponse = userInfo.switchMap {
        authRepository.login(it.first, it.second)
    }.apply {
        observeForever { resource ->

            if (resource.data != null)
                viewModelScope.launch(Dispatchers.IO) {
                    resource.data.run {
                       this.data. email = userInfo.value!!.first
                        this.data. password = userInfo.value!!.second
                        authRepository.insertUserAuth(this.data)
                    }
                    _navigateToMainActivity.postValue(Event(Unit))
                }
        }
    }

    fun updateUserDatabase( authdata: UserAuth) {
        authRepository.insertUserAuth(authdata)
    }

    /**
     * store user inputs as [Pair] of two strings.
     *
     * @param email String entered email.
     * @param password String entered password.
     */
    fun updateUserInfo(email_edit: String, password_edit: String) {
        userInfo.value = Pair(email_edit, password_edit)
    }
    fun accept_statues()= authRepository.getAllCategoriesdata().apply {
        Log.d(TAG, "accept_statues: "+this.toString())

    }
}