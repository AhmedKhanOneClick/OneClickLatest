package com.gama.task.di

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    /**
     * provide context to be used in data repository
     *
     * @return applicationContext
     */
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    /**
     * provide shared preference to store data
     *
     * @return shared preference instance
     */
    @Provides
    fun provideSharedPref(application: Application) =
        application.getSharedPreferences("${application.packageName}.pref", MODE_PRIVATE)


}