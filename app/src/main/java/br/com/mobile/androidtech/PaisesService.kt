package br.com.mobile.androidtech

import android.util.Log
import java.net.URL

object PaisesService {
    //val host = "https://servicodados.ibge.gov.br/api/v1/paises/AF"
    //val TAG = "WS_App"

    fun getPaises(): List<Pais> {
        val paises = mutableListOf<Pais>()
        for (i in 1..5){
            val d = Pais()
            d.nome = "Pais $i"
            d.capital ="Capital $i"
            d.bandeira = "https://s2.static.brasilescola.uol.com.br/be/2021/02/3-mundo-planisferio-politico-a3.jpg"
            paises.add(d)
        }
        return paises
    }

}