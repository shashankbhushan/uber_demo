package test.interview.uber.com.data.util

import okhttp3.Interceptor
import okhttp3.Response
import test.interview.uber.com.domain.repository.PreferenceRepository

class HeaderInterceptor(val preferenceUtils: PreferenceRepository): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        var authToken = preferenceUtils.getUserProfileId()
        if(!authToken.isNullOrEmpty()) {
            request = request.newBuilder()
                    .addHeader("Authorization", "OAuth $authToken")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("OSName", "android")
//                    .addHeader("OSVersion", Integer.toString(deviceDetailsRepository.getDeviceApiLevel()))  this can be used to fetch common info related to device
                    .build()
        }
        return chain.proceed(request)
    }
}