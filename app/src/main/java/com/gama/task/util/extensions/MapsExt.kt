package com.gama.task.util.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.google.android.gms.maps.MapView

/**
 * Extension function to handle map lifeCycle to work with [lifecycleOwner].
 *
 * @receiver MapView
 * @param lifecycleOwner LifecycleOwner
 */
fun MapView.workWithLifecycle(lifecycleOwner: LifecycleOwner) {

    lifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun createMap() = this@workWithLifecycle.onCreate(null)

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun startMap() = this@workWithLifecycle.onStart()

        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun resumeMap() = this@workWithLifecycle.onResume()

        @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
        fun pauseMap() = this@workWithLifecycle.onPause()

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun stopMap() = this@workWithLifecycle.onStop()

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        fun destroyMap() {
            //this@workWithLifecycle.onDestroy()
            lifecycleOwner.lifecycle.removeObserver(this)
        }

    })
}