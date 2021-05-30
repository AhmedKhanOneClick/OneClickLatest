package com.gama.task.ui.base

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.DialogFragment
import com.gama.task.AppExecutors
import com.gama.task.R
import com.gama.task.binding.FragmentDataBindingComponent
import com.gama.task.ui.base.BaseView
import com.gama.task.util.autoCleared



import com.gama.task.models.Resource
import com.gama.task.models.Status
import com.gama.task.ui.common.DialogType
import com.gama.task.ui.common.GeneralDialog
import com.gama.task.util.autoCleared
import javax.inject.Inject

abstract class BaseDialogFragment<DB : ViewDataBinding> : DialogFragment(), BaseView {

    @Inject
    lateinit var appExecutors: AppExecutors

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    var binding by autoCleared<DB>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isFullScreenDialog())
            setStyle(STYLE_NORMAL, R.style.DialogFullScreen)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        initDataBinding(inflater, container)
        initBindingLifeCycleOwner()

        if (isRoundedCorners() && !isFullScreenDialog()) {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            binding.root.setBackgroundResource(R.drawable.bg_rounded_dialog)
        }

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        view.findViewById<Toolbar>(R.id.toolbar)?.setNavigationOnClickListener {
            dismissAllowingStateLoss()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        dialog?.window?.attributes?.windowAnimations = R.style.dialog_animation
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
     * override it to return true if the dialog has a rounded corners
     * @return Boolean true if the dialog has a rounded corners, false otherwise
     */
    open fun isRoundedCorners() = false


    /**
     * override it to return true if the dialog fill the full window screen
     * @return Boolean true if the dialog fill the full window screen, false otherwise
     */
    open fun isFullScreenDialog() = false


    /**
     * handle api status [Status.LOADING] and [Status.ERROR]
     * @param apiStatus Resource<T> the response to handle its status
     */
    fun <T> handleApiStatus(apiStatus: Resource<T>) {

        // user is logged in but token expired
        if (apiStatus.code == 409) {
        //    openActivity(SplashActivity::class.java, true)
        } else {
            // handle loading status
            binding.setVariable(BR.isLoading, apiStatus.status == Status.LOADING)

            // handle error status
            if (apiStatus.status == Status.ERROR)
                handleApiErrorStatus(apiStatus)
        }
    }


    /**
     * handle [Status.ERROR] for apiServices
     * @param apiStatus Resource<T> the response to handle its error status
     */
    open fun <T> handleApiErrorStatus(apiStatus: Resource<T>) {
        val errorMsg = when {
            apiStatus.code == 401 -> getString(R.string.invalid_login_data)
            apiStatus.code == 500 -> getString(R.string.error_api_500)
            apiStatus.message != null -> apiStatus.message
            else -> getString(R.string.error_api_general)
        }

        GeneralDialog(DialogType.ERROR, errorMsg).show(childFragmentManager, tag)
    }
}





