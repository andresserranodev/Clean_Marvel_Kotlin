package com.puzzlebench.clean_marvel_kotlin.presentation.android

import android.app.Activity
import com.puzzlebench.clean_marvel_kotlin.presentation.di.android.DaggerAppComponent
import com.puzzlebench.cmk.data.android.DataApp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MarvelApp : DataApp(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
                .builder()
                .create(this)
                .inject(this)
    }
}
