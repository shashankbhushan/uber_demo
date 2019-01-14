package test.interview.uber.com.data.services

import io.reactivex.Single
import test.interview.uber.com.domain.model.BaseResponse
import test.interview.uber.com.domain.model.SampleReqModel
import test.interview.uber.com.domain.repository.ApiRepository
import test.interview.uber.com.domain.repository.PreferenceRepository

import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(val apiService: ApiService): ApiRepository {
    override fun getSomeAPI(sampleReqModel: SampleReqModel): Single<BaseResponse<String>> {
       return apiService.someRandomAPI(sampleReqModel = sampleReqModel)
    }

}

