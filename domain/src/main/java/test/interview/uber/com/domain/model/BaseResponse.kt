package test.interview.uber.com.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class BaseResponse<T>: ErrorModel(), Serializable {
    @SerializedName("status_code")
    var statuscode: Int = 0
    @SerializedName("data")
    var data: T?=null
}