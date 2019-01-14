package test.interview.uber.com.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class SampleReqModel(
    @SerializedName("key")
    var value: String
) : Serializable