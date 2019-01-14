package test.interview.uber.com.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class ErrorModel: Serializable {
    @SerializedName("error")
    var error: Error?= null
}

data class Error(
    @SerializedName("error_code")
    var errorCode: Int,
    @SerializedName("err_message")
    var errorMessage: String
): Serializable