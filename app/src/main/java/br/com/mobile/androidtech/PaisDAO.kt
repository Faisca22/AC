package br.com.mobile.androidtech

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PaisDAO {
    @Query("SELECT * FROM paises where id=:id")
    fun getById(id: Long): Pais?

    @Query("SELECT * FROM paises")
    fun findAll(): List<Pais>

    @Insert
    fun insert(pais: Pais)

    @Delete
    fun delete(pais: Pais)
}