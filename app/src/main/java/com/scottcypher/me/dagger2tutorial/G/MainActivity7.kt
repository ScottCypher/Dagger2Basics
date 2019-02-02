package com.scottcypher.me.dagger2tutorial.G

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
// Example showing @Provides binding a concrete implementation with an interface
class MainActivity7 : AppCompatActivity() {

    @Inject
    lateinit var hasText: HasText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        Log.d("MainActivity7", hasText.text)
    }
}


@Component(modules = [
    CustomModule7::class,
    ActivityModule::class,
    AndroidInjectionModule::class
])
interface SampleAppComponent7 {
    fun provideDependenciesFor(customApplication: CustomApplication7)
}

@Module
class CustomModule7 {
    @Provides
    fun getStringWrapper7(stringWrapper7: StringWrapper7): HasText = stringWrapper7
}

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity7Injector(): MainActivity7
}

interface HasText  {
    val text: String
}

class StringWrapper7 @Inject constructor(): HasText  {
    override val text = "StringWrapper7 via @Provides"
}