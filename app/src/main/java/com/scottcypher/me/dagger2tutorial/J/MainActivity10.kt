package com.scottcypher.me.dagger2tutorial.J

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
import javax.inject.Singleton


// TODO update application before running
// Introducing @Singleton
class MainActivity10 : AppCompatActivity() {

    @Inject
    lateinit var hasText: HasText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AndroidInjection.inject(this)

        Log.d("MainActivity10", hasText.text)

        text.setOnClickListener {
            // Intentionally relaunch
            startActivity(Intent(this, MainActivity10::class.java))
            finish()
        }
    }
}

@Singleton
@Component(modules = [
    CustomModule10::class,
    ActivityModule::class,
    AndroidInjectionModule::class
])
interface SampleAppComponent10 {
    fun provideDependenciesFor(customApplication: CustomApplication10)
}

@Module
abstract class CustomModule10 {
    @Binds
    abstract fun getStringWrapper10(stringWrapper10: StringWrapper10): HasText
}

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity10Injector(): MainActivity10
}

interface HasText  {
    val text: String
}

@Singleton
// @Singleton could also be defined from a @Module
// e.g. to provide an expensive object only once
class StringWrapper10 @Inject constructor(): HasText  {
    companion object {
        var count = 0
    }

    override val text = "Instance ${++count}"
}