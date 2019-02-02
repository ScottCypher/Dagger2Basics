package com.scottcypher.me.dagger2tutorial.C

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.scottcypher.me.dagger2tutorial.R
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

// Example with module 2
class MainActivity3 : AppCompatActivity() {

    @Inject
    lateinit var stringWrapper: StringWrapper3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSampleAppComponent3.create().provideDependenciesFor(this)

        Log.d("MainActivity3", stringWrapper.text)
    }
}


@Component(modules = [
    CustomModule3::class
])
interface SampleAppComponent3 {
    fun provideDependenciesFor(mainActivity: MainActivity3)
}

@Module
class CustomModule3 {
    val text = "Some calculated value"

    // This can be named anything
    @Provides
    fun providesStringWrapper3() = StringWrapper3(text)
}

class StringWrapper3(val text: String)