package br.com.mobile.androidtech

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.net.URL

object PaisesService {
    val host = "https://www.pythonanywhere.com"
    val TAG = "WS_tech"

    fun getPaises(context: Context): List<Pais> {
        try {
            val url = "$host/user/kfaisca/files/home/kfaisca/Paises/paises"
            val json = HttpHelper.get(url)
            return parserJson(json)
        } catch (ex: Exception){
            var paises = DatabaseManager.getPaisDAO().findAll()
            return paises
        }
    }

    fun save(pais: Pais): Response {
        try {
            val json = HttpHelper.post("$host/user/kfaisca/files/home/kfaisca/Paises/paises", pais.toJson())
            return parserJson(json)
        }catch (ex: Exception){
            DatabaseManager.getPaisDAO().insert(pais)
            return Response("ok","ok")
        }
    }


    fun delete(pais: Pais): Response {
        Log.d(TAG, pais.id.toString())
        val url = "$host/user/kfaisca/files/home/kfaisca/Paises/paises/${pais.id}"
        val json = HttpHelper.delete(url)
        Log.d(TAG, json)
        return parserJson(json)
    }
    inline fun <reified T> parserJson(json: String): T{
        val type = object: TypeToken <T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}