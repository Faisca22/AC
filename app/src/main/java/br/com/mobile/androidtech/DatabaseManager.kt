package br.com.mobile.androidtech

import androidx.room.Room

object DatabaseManager {
    private val dbInstance: AndroidDatabase

    init {
        val contexto = AndroidApplication.getInstance().applicationContext

        dbInstance = Room.databaseBuilder(
            contexto, AndroidDatabase::class.java,"Android.sqlite"
        ).build()
    }
    fun getPaisDAO(): PaisDAO{
        return dbInstance.paisDAO()
    }
}