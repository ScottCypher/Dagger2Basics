package com.scottcypher.me.dagger2tutorial.I

import android.content.Intent
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
import kotlinx.android.synthetic.main.activity_main.text


// TODO update application before running
// Shows how new instances are created on each injection
class MainActivity9 : AppCompatActivity() {

    @Inject
    lateinit var hasText: HasText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        Log.d("MainActivity9", hasText.text)

        text.setOnClickListener {
            // Intentionally relaunch
            startActivity(Intent(this, MainActivity9::class.java))
            finish()
        }
    }
}


@Component(modules = [
    CustomModule9::class,
    ActivityModule::class,
    AndroidInjectionModule::class
])
interface SampleAppComponent9 {
    fun provideDependenciesFor(customApplication: CustomApplication9)
}

@Module
abstract class CustomModule9 {
    @Binds
    abstract fun getStringWrapper9(stringWrapper9: StringWrapper9): HasText
}

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity9Injector(): MainActivity9
}

interface HasText  {
    val text: String
}

class StringWrapper9 @Inject constructor(): HasText  {
    companion object {
        var count = 0
    }

    override val text = "Instance ${++count}"
}