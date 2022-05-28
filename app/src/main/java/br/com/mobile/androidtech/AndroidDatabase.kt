package br.com.mobile.androidtech

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Pais::class), version =1)
abstract class AndroidDatabase: RoomDatabase() {
    abstract fun paisDAO(): PaisDAO

}