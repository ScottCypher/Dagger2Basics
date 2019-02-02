package com.scottcypher.me.dagger2tutorial.A

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.scottcypher.me.dagger2tutorial.R
import dagger.Component
import javax.inject.Inject

// Basic example
class MainActivity1 : AppCompatActivity() {

    @Inject
    lateinit var stringWrapper: StringWrapper1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // DaggerSampleAppComponent is auto-generated after running make
        // Check out the source code to see how DaggerSampleAppComponent provides the StringWrapper to MainActivity1
        DaggerSampleAppComponent1.create().provideDependenciesFor(this)

        Log.d("MainActivity1", stringWrapper.text)
    }
}


@Component
interface SampleAppComponent1 {
    // This can be named anything (in most examples it is 'inject')
    fun provideDependenciesFor(mainActivity: MainActivity1)
}

class StringWrapper1 @Inject constructor() {
    val text = "Hello Dagger 2"
}