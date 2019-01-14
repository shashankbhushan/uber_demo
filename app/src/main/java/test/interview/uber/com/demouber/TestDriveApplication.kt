package test.interview.uber.com.demouber

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import test.interview.uber.com.demouber.di.AppComponent
import test.interview.uber.com.demouber.di.DaggerAppComponent
import timber.log.Timber

class TestDriveApplication : DaggerApplication(){

    lateinit var appComponent: AppComponent

    companion object {
        lateinit var app : TestDriveApplication
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true) // not needed initially
        app = this
        Timber.plant(Timber.DebugTree())
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent =  DaggerAppComponent.builder().application(this).build()
        return appComponent
    }
}
