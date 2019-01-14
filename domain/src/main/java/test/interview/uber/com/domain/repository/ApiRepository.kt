package test.interview.uber.com.domain.repository

import io.reactivex.Single
import test.interview.uber.com.domain.model.BaseResponse
import test.interview.uber.com.domain.model.SampleReqModel

interface ApiRepository {
    fun getSomeAPI(sampleReqModel: SampleReqModel) : Single<BaseResponse<String>>
}