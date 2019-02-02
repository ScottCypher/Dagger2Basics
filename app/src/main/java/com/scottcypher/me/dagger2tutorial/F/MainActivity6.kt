package com.scottcypher.me.dagger2tutorial.F

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.scottcypher.me.dagger2tutorial.R
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import javax.inject.Inject
import dagger.android.ContributesAndroidInjector

// TODO update application before running
// Example showing less dependent injection (we do not instantiate our component)
// Introduces @ContributesAndroidInjector
class MainActivity6 : AppCompatActivity() {

    @Inject
    lateinit var stringWrapper: StringWrapper6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        Log.d("MainActivity6", stringWrapper.text)
    }
}


@Component(modules = [
    CustomModule6::class,
    ActivityModule::class,
    AndroidInjectionModule::class
])
interface SampleAppComponent6 {
    fun provideDependenciesFor(customApplication: CustomApplication6)
}

@Module
class CustomModule6(val text: String) {
    @Provides
    fun providesStringWrapper6() = StringWrapper6(text)
}

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity6Injector(): MainActivity6
}

class StringWrapper6(val text: String)