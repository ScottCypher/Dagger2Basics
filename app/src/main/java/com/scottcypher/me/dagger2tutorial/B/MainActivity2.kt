package com.scottcypher.me.dagger2tutorial.B

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.scottcypher.me.dagger2tutorial.R
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

// Example with module
class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var stringWrapper: StringWrapper2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSampleAppComponent2.create().provideDependenciesFor(this)

        Log.d("MainActivity2", stringWrapper.text)
    }
}


@Component(modules = [
    CustomModule2::class
])
interface SampleAppComponent2 {
    fun provideDependenciesFor(mainActivity: MainActivity2)
}

@Module
class CustomModule2 {
    // This can be named anything
    @Provides
    fun providesStringWrapper2() = StringWrapper2()
}

class StringWrapper2 {
    val text = "Another example using dagger!"
}