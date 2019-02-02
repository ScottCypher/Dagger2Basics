package com.scottcypher.me.dagger2tutorial.I

import android.app.Activity
import android.app.Application
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject


class CustomApplication9: Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerSampleAppComponent9.create().provideDependenciesFor(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

}