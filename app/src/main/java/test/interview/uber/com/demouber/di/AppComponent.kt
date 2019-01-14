package test.interview.uber.com.demouber.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import test.interview.uber.com.data.di.DataModule
import test.interview.uber.com.demouber.TestDriveApplication
import test.interview.uber.com.demouber.base.ViewModelModule
import test.interview.uber.com.device.di.DeviceModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class,
    DeviceModule::class,
    DataModule::class,
    ViewModelModule::class,
    AndroidSupportInjectionModule::class,
    AndroidInjectionModule::class,
    ActivityBindingModule::class))
interface AppComponent : AndroidInjector<TestDriveApplication> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}