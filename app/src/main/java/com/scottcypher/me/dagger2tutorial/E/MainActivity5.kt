package com.scottcypher.me.dagger2tutorial.E

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.scottcypher.me.dagger2tutorial.R
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

// Example of passing in a module a value
class MainActivity5 : AppCompatActivity() {

    @Inject
    lateinit var stringWrapper: StringWrapper5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSampleAppComponent5.builder()
            .customModule5(CustomModule5("Value passed when instantiating module"))
            .build()
            .provideDependenciesFor(this)

        Log.d("MainActivity5", stringWrapper.text)
    }
}


@Component(modules = [
    CustomModule5::class
])
interface SampleAppComponent5 {
    fun provideDependenciesFor(mainActivity: MainActivity5)
}

@Module
class CustomModule5(val text: String) {
    @Provides
    fun providesStringWrapper5() = StringWrapper5(text)
}

class StringWrapper5(val text: String)