package com.scottcypher.me.dagger2tutorial.D

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.scottcypher.me.dagger2tutorial.R
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named

// Example of @Named
class MainActivity4 : AppCompatActivity() {

    // Don't do '@Inject @Named("Different")'
    // https://medium.com/@WindRider/correct-usage-of-dagger-2-named-annotation-in-kotlin-8ab17ced6928
    @field:[Inject Named("Different")]
    lateinit var stringWrapper: StringWrapper4

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSampleAppComponent4.create().provideDependenciesFor(this)

        // Logs "I am different"
        Log.d("MainActivity4", stringWrapper.text)
    }
}


@Component(modules = [
    CustomModule4::class
])
interface SampleAppComponent4 {
    fun provideDependenciesFor(mainActivity: MainActivity4)
}

@Module
class CustomModule4 {
    val text = "Some calculated value!"

    @Provides
    fun providesStringWrapper4() = StringWrapper4(text)

    @Provides
    @Named("Different")
    fun providesDifferentStringWrapper4() = StringWrapper4("I am different")
}

class StringWrapper4(val text: String)