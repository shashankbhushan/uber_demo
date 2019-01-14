package test.interview.uber.com.domain.intractors

import com.beebeeedge.domain.intractors.types.SingleUseCaseWithParams
import io.reactivex.Single
import test.interview.uber.com.domain.model.BaseResponse
import test.interview.uber.com.domain.model.SampleReqModel
import test.interview.uber.com.domain.repository.ApiRepository
import javax.inject.Inject

class GetSomeDataUseCase @Inject constructor(private val apiRepository: ApiRepository) :
    SingleUseCaseWithParams<SampleReqModel, BaseResponse<String>> {
    override fun execute(sampleReqModel: SampleReqModel): Single<BaseResponse<String>> {
        return apiRepository.getSomeAPI(sampleReqModel)
    }

}