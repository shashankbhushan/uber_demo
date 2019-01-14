package test.interview.uber.com.demouber.base

import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerAppCompatActivity
import java.util.*
import javax.inject.Inject

/**
 * this is base activity ,maintain the base behaviour
 */
abstract class BaseActivity<VM : BaseViewModel>: DaggerAppCompatActivity(), View.OnClickListener {

    protected lateinit var viewModel: VM

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModelInstance()

    }
    abstract fun getViewModelInstance(): VM

    open fun setUpView(resId: Int){
        setContentView(resId)
    }


    override fun onClick(v: View?) {

    }
}