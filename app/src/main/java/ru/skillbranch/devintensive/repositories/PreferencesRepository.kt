package ru.skillbranch.devintensive.repositories

import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import ru.skillbranch.devintensive.App
import ru.skillbranch.devintensive.models.Profile

object PreferencesRepository {

    private const val ET_FIRST_NAME = "ET_FIRST_NAME"
    private const val ET_LAST_NAME = "ET_LAST_NAME"
    private const val ET_ABOUT = "ET_ABOUT"
    private const val ET_REPOSITORY = "ET_REPOSITORY"
    private const val TV_RATING = "TV_RATING"
    private const val TV_RESPECT = "TV_RESPECT"
    private const val APP_THEME = "APP_THEME"


    private val prefs: SharedPreferences by lazy {
        val ctx = App.applicationContext()
        PreferenceManager.getDefaultSharedPreferences(ctx)
    }


    fun saveAppTheme(theme: Int) {
        putValue(APP_THEME to theme)
    }

    fun getAppTheme(): Int = prefs.getInt(APP_THEME, AppCompatDelegate.MODE_NIGHT_NO)

    fun saveProfile(profile: Profile) {
        with(profile) {
            putValue(ET_FIRST_NAME to firstName)
            putValue(ET_LAST_NAME to lastName)
            putValue(ET_ABOUT to about)
            putValue(ET_REPOSITORY to repository)
            putValue(TV_RATING to rating)
            putValue(TV_RESPECT to respect)
        }
    }

    fun getProfile(): Profile = Profile(

        prefs.getString(ET_FIRST_NAME, "")!!,
        prefs.getString(ET_LAST_NAME, "")!!,
        prefs.getString(ET_ABOUT, "")!!,
        prefs.getString(ET_REPOSITORY, "")!!,
        prefs.getInt(TV_RATING, 0),
        prefs.getInt(TV_RESPECT, 0)
    )

    private fun putValue(pair: Pair<String, Any>) = with(prefs.edit()) {
        val key = pair.first
        val value = pair.second

        when (value) {
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Boolean -> putBoolean(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            else -> error("Only primutive types can be stored in Shared Preferences")
        }
        apply()
    }


}