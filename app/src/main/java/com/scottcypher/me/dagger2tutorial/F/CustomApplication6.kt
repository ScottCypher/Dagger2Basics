package com.scottcypher.me.dagger2tutorial.F

import android.app.Activity
import android.app.Application
import dagger.android.HasActivityInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

class CustomApplication6: Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerSampleAppComponent6
            .builder()
            .customModule6(CustomModule6("Coming from the application"))
            .build()
            .provideDependenciesFor(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

}