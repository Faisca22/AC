package br.com.mobile.androidtech

import android.content.SharedPreferences

object Prefs {
    val PREF_ID = "Android"

    private fun prefs(): SharedPreferences{
        val contexto = AndroidApplication.getInstance().applicationContext
        val prefs = contexto.getSharedPreferences(PREF_ID, 0)
        return prefs
    }

    fun setString(flag: String, valor:String){
        prefs().edit().putString(flag, valor).apply()
    }

    fun getString(flag: String): String?{
        return prefs().getString(flag, "")
    }

    fun setBoolean(flag: String, valor: Boolean){
        prefs().edit().putBoolean(flag, valor).apply()
    }
    fun getBoolean(flag:String): Boolean?{
        return prefs().getBoolean(flag, false)
    }
}