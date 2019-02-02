package com.scottcypher.me.dagger2tutorial.G

import android.app.Activity
import android.app.Application
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject


class CustomApplication7: Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerSampleAppComponent7.create().provideDependenciesFor(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

}