package test.interview.uber.com.device.services

import android.content.Context
import com.google.gson.Gson
import test.interview.uber.com.device.R
import test.interview.uber.com.device.utils.SharedPreferenceManager
import test.interview.uber.com.domain.repository.PreferenceRepository

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceRepositoryImpl @Inject constructor(val context: Context) : PreferenceRepository {

    private val sharedPreferenceHelper: SharedPreferenceManager = SharedPreferenceManager.getInstance(context)

    override fun getUserProfileId(): String {
        return sharedPreferenceHelper.getString(context.getString(R.string.pref_key_user_id))!!
    }

}