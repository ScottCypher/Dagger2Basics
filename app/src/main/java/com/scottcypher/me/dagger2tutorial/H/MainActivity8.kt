package com.scottcypher.me.dagger2tutorial.H

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.scottcypher.me.dagger2tutorial.R
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjection
import dagger.android.AndroidInjectionModule
import javax.inject.Inject
import dagger.android.ContributesAndroidInjector


// TODO update application before running
// Bonus Example!
// Shows @Binds binding a concrete implementation with an interface
// See the generated code to see how @Binds is more efficient!
class MainActivity8 : AppCompatActivity() {

    @Inject
    lateinit var hasText: HasText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        Log.d("MainActivity8", hasText.text)
    }
}


@Component(modules = [
    CustomModule8::class,
    ActivityModule::class,
    AndroidInjectionModule::class
])
interface SampleAppComponent8 {
    fun provideDependenciesFor(customApplication: CustomApplication8)
}

@Module
abstract class CustomModule8 {
    // @Binds is useful for defining which implementation to use when injecting the interface
    // Comment out this module and you can see MainActivity8.hasText cannot be provided
    // We could also accomplish this with @Provides but @Binds is more performant (instance is not generated to provided dependency, see implementation)
    @Binds
    abstract fun getStringWrapper8(stringWrapper8: StringWrapper8): HasText
}

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity8Injector(): MainActivity8
}

interface HasText  {
    val text: String
}

class StringWrapper8 @Inject constructor(): HasText  {
    override val text = "StringWrapper8 via @Binds"
}