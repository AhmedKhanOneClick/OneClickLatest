package com.gama.task.util

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.gama.task.R

object OpenAppSettingsUtil {

    fun openAppSettings(context: Context, @StringRes msgRes: Int) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(msgRes)
        builder.setPositiveButton("ok") { dialog: DialogInterface, which: Int ->
            val packageUri =
                Uri.fromParts("package", context.packageName, null)
            val applicationDetailsSettingsIntent = Intent()
            applicationDetailsSettingsIntent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            applicationDetailsSettingsIntent.data = packageUri
            applicationDetailsSettingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(applicationDetailsSettingsIntent)
            dialog.dismiss()
        }
        builder.setNegativeButton(
            android.R.string.cancel
        ) { dialog: DialogInterface, which: Int -> dialog.dismiss() }
        builder.create().show()
    }

}