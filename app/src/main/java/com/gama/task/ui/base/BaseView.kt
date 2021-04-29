package com.gama.task.ui.base

import androidx.annotation.LayoutRes

interface BaseView {

    /**
     * Use it to provide the view layout.
     *
     * @return Int the layout id
     */
    @LayoutRes
    fun getLayoutRes(): Int

    /**
     * Use it to set dataBinding lifeCycleOwner
     * that's because using LiveData in dataBinding requires to be aware of LifeCycle
     */
    fun initBindingLifeCycleOwner()

    /**
     * Use it to handle all views in your activities and fragments
     */
    fun init()


}
