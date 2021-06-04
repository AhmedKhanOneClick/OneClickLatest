package com.gama.task.ui.auth.login

import android.content.ContentValues
import android.util.Log
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.core.os.bundleOf
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.fragment.findNavController

import com.gama.databinding_validation.validate

import com.gama.task.R
import com.gama.task.databinding.FragmentLoginBinding
import com.gama.task.ui.base.BaseFragment
import com.gama.task.ui.common.DialogType
import com.gama.task.ui.common.GeneralDialog
import com.gama.task.ui.main.MainActivity
import com.gama.task.util.EventObserver
import com.gama.task.util.extensions.openActivity
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import com.gama.task.models.Status

/**
 * Display login UI form.
 */
@AndroidEntryPoint
class LoginFragment :
    BaseFragment<LoginViewModel, FragmentLoginBinding>(LoginViewModel::class.java),
    ViewTreeObserver.OnGlobalLayoutListener {

    override fun getLayoutRes() = R.layout.fragment_login

    override fun init() {

        initScrollChildToMathScreenSize()
        initSignIn()
        initSignUp()
        initForgetPass()
    }


    /**
     * add view observer to add margin to footer img if it's not aligned with screen bottom.
     */
    private fun initScrollChildToMathScreenSize() {

        if (binding.loginForm.viewTreeObserver.isAlive) {
            binding.loginForm.viewTreeObserver.addOnGlobalLayoutListener(this@LoginFragment)
        }
    }


    /**
     * - validate on login with amazon form whe login btn clicked.
     * - onValid send login request.
     * - handle the request states and if success navigate to [MainActivity].
     * if request is reqistered before but not complete  navigate to [Confirm Signup].
     */
    fun initSignIn() {

        viewModel.loginResponse.observe(viewLifecycleOwner, ::handleApiStatus)
//
        viewModel.navigateToMainActivity.observe(viewLifecycleOwner, EventObserver {

//            viewModel.accept_statues()
//                .observe(viewLifecycleOwner) {
//                    handleApiStatus(it)
//                    if (it.status == Status.SUCCESS){
//
//                        Log.d(ContentValues.TAG, "accept_statues: "+it.toString())
//
//                    }else{
////                        handle401Error()
//                        Log.d(ContentValues.TAG, "accept_statues:1 ")
//                    }
//                }
            openActivity(MainActivity::class.java, true)
//            findNavController().navigate(
//                R.id.action_searchPagerFragment,
//
//            )
        })

        binding.btnLogin.root.setOnClickListener {
            if (binding.root.validate())
                viewModel.updateUserInfo(
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                )
                binding.setVariable(BR._all, true)





////            //init sign in with amazon with data email and password
//                Amplify.Auth.signIn(
//                    binding.etEmail.text.toString(),
//                    binding.etPassword.text.toString(),
//                    { result ->
//                        Log.d("AmplifyQuickstart", "AmplifyQuickstart initSignIn: ")
//                     //fetch session (access token ) from user logined
//                        Amplify.Auth.fetchAuthSession(
//                            { result ->
//                                binding.setVariable(BR.isLoading, false)
//                                Log.i(
//                                    "AmplifyQuickstart",
//                                    (result as AWSCognitoAuthSession).userPoolTokens.value?.accessToken.toString()
//                                )
//                                Log.i(
//                                    "AmplifyQuickstart",
//                                    Gson().toJson((result as AWSCognitoAuthSession).userPoolTokens.value)
//                                )
//
//                                (result as AWSCognitoAuthSession).userPoolTokens.value?.run {
//
//                                    val user = UserAuth(
//                                        accessToken = this.accessToken,
//                                        email = binding.etEmail.text.toString(),
//                                        password = binding.etPassword.text.toString()
//                                    )
//                                    //insert into database userauth )access token,email,password)
//                                    viewModel.updateUserDatabase(user)
//
//                                      //  _navigateToMainActivity.postValue(Event(Unit))
//                                    openActivity(MainActivity::class.java, true)
//                                }
//
//                            },
//                            { error ->
//                                binding.setVariable(BR.isLoading, false)
//                                Log.d("initSignIn: error", "initSignIn: error" +error.toString())
//
//                                //User is registered before but not confirmed code yet and move to dialog confirm signup
//                                if (error.cause?.localizedMessage.toString().contains("User is not confirmed")) {
//                                    ConfirmSignup.newInstance(binding.etEmail.text.toString())
//                                        .apply { isCancelable = false }
//                                        .show(childFragmentManager, ConfirmSignup.TAG)
//                                } else {
//
//                                    binding.setVariable(BR.isLoading, false)
//
//                                    // invalid username and password
//                                    activity?.runOnUiThread(java.lang.Runnable {
//                                        handle401Error()
//                                    })
//                                }
//                            })
//                    } ,
//                    { error ->
//                        binding.setVariable(BR.isLoading, false)
//
//                        Log.d("initSignIn: error", "initSignIn: error1" +error.toString())
//                        //User is registered before but not confirmed code yet and move to dialog confirm signup
//                        if (error.cause?.localizedMessage.toString().contains("User is not confirmed")) {
//                            ConfirmSignup.newInstance(binding.etEmail.text.toString())
//                                .apply { isCancelable = false }.show(childFragmentManager, ConfirmSignup.TAG)
//                        }else {
//
//                            binding.setVariable(BR.isLoading, false)
//                            // invalid username and password
//                            activity?.runOnUiThread(java.lang.Runnable {
//                                handle401Error()
//                            })
//                        }
//
//                        }
//                )
//            ConfirmSignup.newInstance(binding.etEmail.text.toString())
//                .apply { isCancelable = false }
//                .show(childFragmentManager, ConfirmSignup.TAG)

//            val user = UserAuth(
//                                        accessToken = "eyJraWQiOiJLam83b0JkSzFLV0V5ZW9cL0dnazhVemNVaXdcL3VrTHFZZDhYbklcL1g0V0JvPSIsImFsZyI6IlJTMjU2In0.eyJzdWIiOiJjMzllMGUyMS05OWUwLTQwN2ItYjEyOS03ZjI4YjYyODM1NDQiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiY3VzdG9tOkNvdW50cnlJZCI6IjEiLCJjdXN0b206SWJhbk51bWJlciI6IlNBMTc5MDk0MTMyNzExMTAwMDAwMDAwMiIsImlzcyI6Imh0dHBzOlwvXC9jb2duaXRvLWlkcC51cy1lYXN0LTIuYW1hem9uYXdzLmNvbVwvdXMtZWFzdC0yXzdDRnJackhDdCIsInBob25lX251bWJlcl92ZXJpZmllZCI6ZmFsc2UsImNvZ25pdG86dXNlcm5hbWUiOiJtb2hhbWVkbm9zaWVyMTIzQGdtYWlsLmNvbSIsImF1ZCI6IjExMnVwY25raTUwOHA4cG1hcmlnYjRkc3VoIiwiY3VzdG9tOkNvbXBhbnlOYW1lIjoiRGV2b3Bzb2x1dGlvbSIsImV2ZW50X2lkIjoiZTFiMzZiZjAtMWFkMi00MDIyLThiODUtZjBjNzZkZTNmYjJmIiwidG9rZW5fdXNlIjoiaWQiLCJhdXRoX3RpbWUiOjE2MDk3MjI3NjIsIm5hbWUiOiJtb2hhbWVkIG5vc2llciIsInBob25lX251bWJlciI6IisxMDEyODYwNzIzODUiLCJleHAiOjE2MDk3MjQwNDUsImlhdCI6MTYwOTcyMzc0NSwiZW1haWwiOiJtb2hhbWVkbm9zaWVyMTIzQGdtYWlsLmNvbSJ9.diL1plue0K2j_eaLN6O0yOKPslBZ-azuFw0rMYvLIrwo9ULyPhb9LikTJAoNghoF9rpNSp1RHh6mEQXcJeO9UFSmUsGa3vNLApjlNpHuk5u7yhUBNNt6cbYUbLfQ8ujelKKaAvnmNcVg1uoEKbAYCenrnDM6dQWX0ajRI_6OPgA5mHZsC5loQXDjdg88qu942ab13cDL3V134P6t4MVR0KptRswtWwtkMp1GZhPQBUD2CG7ez72rVmpCZA4zqRVZtNOTzbz53mV49A0OboiP_zJWJGWG85cI61R9tq7dlhV2JJFZNHYp6yhdoQP8CBPztjcBCeWJ7qmbFmYSflx09A",
//                                        email = binding.etEmail.text.toString(),
//                                        password = binding.etPassword.text.toString()
//                                    )
//                                    //insert into database userauth )access token,email,password)
//                                    viewModel.updateUserDatabase(user)
//
//                                      //  _navigateToMainActivity.postValue(Event(Unit))
//                                    openActivity(MainActivity::class.java, true)
        }
    }

    /**
     * override 401 error handling in login request to show error msg with invalid inputs.
     */
    override fun handle401Error() {
        GeneralDialog(DialogType.ERROR, getString(R.string.invalid_login_Data)).show(
            childFragmentManager,
            tag
        )
    }

    /**
     * init registerTxt click. open register screen on click.
     */
    private fun initSignUp() {
        binding.btnRegister.setOnClickListener {
//            findNavController().navigate(R.id.openRegister)
        }
    }

    /**
     * init forgetPass click. open forgetPass screen on click.
     */
    private fun initForgetPass() {
        binding.btnForgetPass.setOnClickListener {
//            findNavController().navigate(R.id.openForgetPass)
        }
    }

    /**
     * when view draw on screen and not fill the screen add top margin to the footer
     * to make it align the screen bottom.
     */
    override fun onGlobalLayout() {
        if (binding.loginForm.height < binding.root.height) {
            binding.imgFooter.layoutParams =
                (binding.imgFooter.layoutParams as ViewGroup.MarginLayoutParams).apply {
                    topMargin = binding.root.height - binding.loginForm.height
                }
        }

        if (binding.loginForm.viewTreeObserver.isAlive)
            binding.loginForm.viewTreeObserver.removeOnGlobalLayoutListener(this@LoginFragment)
    }

}