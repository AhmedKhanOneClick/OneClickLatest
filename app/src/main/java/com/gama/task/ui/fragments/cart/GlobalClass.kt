package com.gama.task.ui.fragments.cart

import android.app.Application
import com.gama.task.ui.fragments.cart.models.CartItem

public class GlobalClass:Application() {
    companion object {
    @JvmField
        var globalCartList = ArrayList<CartItem>()

    }
}