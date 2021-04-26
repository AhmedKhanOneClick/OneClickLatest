package com.gama.task.ui.base

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gama.task.AppExecutors
import com.gama.task.R
import com.gama.task.binding.FragmentDataBindingComponent
import com.gama.task.models.Resource
import com.gama.task.models.Status
import com.gama.task.ui.main.NavigationHost
import com.gama.task.util.autoCleared
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding>(viewModelClass: Class<VM>) :
    Fragment(), BaseView {

    @Inject
    lateinit var appExecutors: AppExecutors

    @Inject
    lateinit var preferences: SharedPreferences


    private var navigationHost: NavigationHost? = null


    val viewModel: VM by lazy {
        ViewModelProvider(if (isSharedViewModel()) requireActivity() else this).get(viewModelClass)
    }


    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    var binding by autoCleared<DB>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationHost) {
            navigationHost = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigationHost = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initDataBinding(inflater, container)
        initBindingLifeCycleOwner()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        val mainToolbar: Toolbar = view.findViewById(R.id.toolbar) ?: return
        // If we have a toolbar and we are not attached to a navigation host, set up the toolbar
        // navigation icon.
        if (navigationHost == null) {
            mainToolbar.setNavigationOnClickListener { findNavController().navigateUp() }
            return
        }

        // If we have a toolbar and we are attached to a proper navigation host, set up the toolbar
        // navigation icon.
        mainToolbar.apply {
            navigationHost?.registerToolbarWithNavigation(this)
        }
    }

    private fun initDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(
            inflater,
            getLayoutRes(),
            container,
            false,
            dataBindingComponent
        )
    }

    override fun initBindingLifeCycleOwner() {
        binding.lifecycleOwner = viewLifecycleOwner
    }

    /**
     * override it to return true if the fragment viewModel is shared with other fragments.
     * @return Boolean true if viewModel is shared, false otherwise
     */
    open fun isSharedViewModel() = false

    /**
     * handle api status [Status.LOADING] and [Status.ERROR]
     * @param apiStatus Resource<T> the response to handle its status
     */
    fun <T> handleApiStatus(apiStatus: Resource<T>) {
        // handle loading status
        // update view if request has content
        // user is logged in but token expired or it's login request with un valid data.
        if (apiStatus.code == 401) {
        } else if (apiStatus.status == Status.ERROR) {

            // handle error status
            handleApiErrorStatus(apiStatus)
        }
    }


    /**
     * handle [Status.ERROR] for apiServices
     * @param apiStatus Resource<T> the response to handle its error status
     */
    open fun <T> handleApiErrorStatus(apiStatus: Resource<T>) {
        val errorMsg = when {
            apiStatus.code == 500 -> getString(R.string.error_api_500)
            apiStatus.message != null -> apiStatus.message
            else -> getString(R.string.error_api_general)
        }

//        GeneralDialog(ERROR, errorMsg).show(childFragmentManager, tag)
    }

}





