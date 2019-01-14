package test.interview.uber.com.device.utils

import android.content.Context
import android.content.SharedPreferences
import test.interview.uber.com.device.BuildConfig

class SharedPreferenceManager private constructor(appContext: Context){

    private var prefs: SharedPreferences? = null
    private val prefName = BuildConfig.APPLICATION_ID

    init {
        prefs = appContext.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    companion object {
        private var instance: SharedPreferenceManager? = null
        @Synchronized fun getInstance(appContext: Context): SharedPreferenceManager {
            if(instance == null) {
                instance = SharedPreferenceManager(appContext)
            }
            return  instance!!
        }
    }

    private fun getPrefs(): SharedPreferences? {
        return prefs
    }

    fun clearPrefs() {
        val editor = getPrefs()?.edit()
        editor?.clear()
        editor?.commit()
    }

    fun clearPrefsAsync() {
        val editor = getPrefs()?.edit()
        editor?.clear()
        editor?.apply()
    }

    fun removeKey(key: String) {
        getPrefs()?.edit()?.remove(key)?.commit()
    }

    fun containsKey(key: String): Boolean? {
        return getPrefs()?.contains(key)
    }

    fun getString(key: String, defValue: String?): String? {
        return getPrefs()?.getString(key, defValue)
    }

    fun getString(key: String): String? {
        return getString(key, null)
    }

    fun setString(key: String, value: String) {
        val editor = getPrefs()?.edit()
        editor?.putString(key, value)
        editor?.apply()
    }

    fun getInt(key: String, defValue: Int): Int? {
        return getPrefs()?.getInt(key, defValue)
    }

    fun getInt(key: String): Int? {
        return getInt(key, 0)
    }

    fun setInt(key: String, value: Int) {
        val editor = getPrefs()?.edit()
        editor?.putInt(key, value)
        editor?.apply()
    }

    fun getLong(key: String, defValue: Long): Long? {
        return getPrefs()?.getLong(key, defValue)
    }

    fun getLong(key: String): Long? {
        return getLong(key, 0L)
    }

    fun setLong(key: String, value: Long) {
        val editor = getPrefs()?.edit()
        editor?.putLong(key, value)
        editor?.apply()
    }

    fun getBoolean(key: String, defValue: Boolean): Boolean? {
        return getPrefs()?.getBoolean(key, defValue)
    }

    fun getBoolean(key: String): Boolean? {
        return getBoolean(key, false)
    }

    fun setBoolean(key: String, value: Boolean) {
        val editor = getPrefs()?.edit()
        editor?.putBoolean(key, value)
        editor?.apply()
    }

    fun getFloat(key: String): Float? {
        return getPrefs()?.getFloat(key, 0f)
    }

    fun getFloat(key: String, defValue: Float): Float? {
        return if (containsKey(key) == true) getFloat(key) else defValue
    }

    fun setFloat(key: String, value: Float?) {
        val editor = getPrefs()?.edit()
        editor?.putFloat(key, value!!)
        editor?.apply()
    }

}