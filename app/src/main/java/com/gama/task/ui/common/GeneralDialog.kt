package com.gama.task.ui.common

import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import com.gama.task.R



import com.gama.task.databinding.ButtonGradientBinding
import com.gama.task.databinding.DialogGeneralBinding
import com.gama.task.databinding.DialogGeneralMultiActionBinding
import com.gama.task.ui.base.BaseDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlin.reflect.KFunction1

/**
 * Display info msg or error msg to the user
 * @property type [DialogType] the type of the dialog info or error
 * @property msg String the msg to be displayed
 * @property action Function0<Unit> action to be performed when click to close dialog
 */
@AndroidEntryPoint
class GeneralDialog(
    private val type: DialogType,
    private val msg: String,
    private val action: () -> Unit = {}
) : BaseDialogFragment<DialogGeneralBinding>() {

    override fun getLayoutRes() = R.layout.dialog_general

    override fun isRoundedCorners() = true

    override fun init() {
        binding.msg = msg
        binding.dialogType = type

        binding.btnOk.root.setOnClickListener {
            action()
            dismissAllowingStateLoss()
        }

        binding.imgClose.setOnClickListener { binding.btnOk.root.performClick() }
    }

}

/**
 * Display info msg or error msg to the user with multi action btn.
 * @property type [DialogType] the type of the dialog info or error
 * @property msg String the msg to be displayed
 * @property btns Array<out ButtonGradientBinding>
 */
@AndroidEntryPoint
class GeneralDialogMultiAction(
    private val type: DialogType,
    private val msg: String,
    private val orientation: Int = LinearLayout.VERTICAL,
    private vararg val btns: KFunction1<@ParameterName(name = "dialog") GeneralDialogMultiAction, ButtonGradientBinding>,
) : BaseDialogFragment<DialogGeneralMultiActionBinding>() {

    override fun getLayoutRes() = R.layout.dialog_general_multi_action

    override fun isRoundedCorners() = true

    override fun init() {
        binding.msg = msg
        binding.dialogType = type


        binding.actionContainer.orientation = orientation

        btns.forEach {
            it(this)
        }


    }

}

/**
 * The enum of available types of dialog
 * @property icon Int the [DrawableRes] for icon
 */
@Keep
enum class DialogType(@DrawableRes val icon: Int) {
    ERROR(R.drawable.ic_dialog_error),
    INFO(R.drawable.ic_dialog_info)
}