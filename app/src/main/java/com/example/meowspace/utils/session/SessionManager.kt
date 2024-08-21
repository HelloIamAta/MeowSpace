package com.example.meowspace.utils.session

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class SessionManager(private var _context: Context) {
    // Shared Preferences
    private var pref: SharedPreferences
    private var editor: Editor

    // Shared pref mode
    private var PRIVATE_MODE = 0

    init {
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    companion object {
        // LogCat tag
        private val TAG: String = SessionManager::class.java.getSimpleName()

        // Shared preferences file name
        private const val PREF_NAME = "MeowSpace"
        private const val KEY_IS_LOGGED_IN = "KEY_IS_LOGGED_IN"
        private const val LAT = "LAT"

    }

    fun setLogin(isLoggedIn: String?) {
        editor.putString(KEY_IS_LOGGED_IN, isLoggedIn)
        editor.commit()
    }
    fun isLoggedIn(): String? {
        return pref.getString(KEY_IS_LOGGED_IN, "no")
    }

    fun setStudentLat(lat: String?) {
        editor.putString(LAT, lat)
        editor.commit()
    }
    fun getStudentLat(): String? {
        return pref.getString(LAT, "")
    }

}