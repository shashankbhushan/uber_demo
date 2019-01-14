package test.interview.uber.com.demouber.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import test.interview.uber.com.demouber.mainscreen.MainActivity
import test.interview.uber.com.demouber.mainscreen.MainActivityModule

@Module
abstract class ActivityBindingModule{

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

}