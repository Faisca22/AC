package br.com.mobile.androidtech

import android.app.Application
import java.lang.IllegalStateException

class AndroidApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: AndroidApplication?=null

        fun getInstance(): AndroidApplication{
            if (appInstance == null){
                throw IllegalStateException("Configurar application")
            }
            return appInstance!!
        }
    }
}