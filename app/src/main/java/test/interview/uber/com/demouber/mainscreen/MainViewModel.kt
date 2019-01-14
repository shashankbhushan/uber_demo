package test.interview.uber.com.demouber.mainscreen

import androidx.lifecycle.MutableLiveData
import test.interview.uber.com.demouber.base.BaseViewModel
import test.interview.uber.com.demouber.base.SchedulersFacade
import test.interview.uber.com.domain.intractors.GetSomeDataUseCase
import test.interview.uber.com.domain.intractors.RequestStatus
import test.interview.uber.com.domain.model.Error
import test.interview.uber.com.domain.model.SampleReqModel
import javax.inject.Inject

class MainViewModel @Inject constructor(schedulerFacade: SchedulersFacade, private val getSomeDataUseCase: GetSomeDataUseCase) : BaseViewModel(schedulerFacade) {

    val requestStatus: MutableLiveData<RequestStatus> = MutableLiveData()
    var errorResponse: Error? = null
    var userDeatils: String?=null

    fun getSomeData(){
        requestStatus.postValue(RequestStatus.LOADING)

        getSomeDataUseCase.execute(SampleReqModel(value = ""))
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe({
                userDeatils = it.data
                requestStatus.postValue(RequestStatus.SUCCESS)
            },{
                errorResponse = Error(-1, it.localizedMessage)
                requestStatus.postValue(RequestStatus.FAILED)
            }).let {
                getCompositeDisposable().add(it)
            }
    }

}