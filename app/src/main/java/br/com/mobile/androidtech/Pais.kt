package br.com.mobile.androidtech

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable
import java.net.URL

@Entity(tableName = "paises")
class Pais: Serializable {
    @PrimaryKey
    var id: Long = 0
    var nome: String = ""
    var capital: String =""
    var bandeira: String = ""
    var continente: String = ""
    var populacao: Long = 0
    var latitude: Long = 0
    var longitude: Long = 0

    override fun toString(): String{
        return "Pais(nome='$nome')"
    }

    fun toJson(): String{
        return GsonBuilder().create().toJson(this)
    }
}

