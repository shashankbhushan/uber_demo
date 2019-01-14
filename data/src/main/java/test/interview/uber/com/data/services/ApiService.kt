package test.interview.uber.com.data.services

import io.reactivex.Single
import retrofit2.http.POST
import test.interview.uber.com.data.constants.Urls
import test.interview.uber.com.domain.model.BaseResponse
import test.interview.uber.com.domain.model.SampleReqModel

interface ApiService {

    @POST(Urls.SAMPLE)
    fun someRandomAPI(sampleReqModel : SampleReqModel): Single<BaseResponse<String>>

}