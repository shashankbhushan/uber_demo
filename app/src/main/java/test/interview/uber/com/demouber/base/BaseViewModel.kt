package test.interview.uber.com.demouber.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel @Inject constructor(val schedulers: SchedulersFacade): ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    protected fun getCompositeDisposable(): CompositeDisposable {
        return disposables
    }

    override fun onCleared() {
        disposables.clear()
    }

}