package test.interview.uber.com.demouber.mainscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import test.interview.uber.com.demouber.R
import test.interview.uber.com.demouber.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    override fun getViewModelInstance() = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpView(R.layout.activity_main)
    }

    override fun setUpView(resId: Int) {
        super.setUpView(resId)

    }
}
