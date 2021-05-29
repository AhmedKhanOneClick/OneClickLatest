package com.gama.task

import android.app.Application
import com.github.piasy.biv.BigImageViewer
import com.github.piasy.biv.loader.glide.GlideImageLoader
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm
import io.realm.RealmConfiguration


@HiltAndroidApp
class BaseApp : Application(){
    override fun onCreate() {
        super.onCreate()
//        Bugsee.launch(this, "0651740c-47b1-4a45-bda5-1cd56c40ed8a");
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("travotels.realm")
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(config)

        BigImageViewer.initialize(GlideImageLoader.with(this))


    }
}