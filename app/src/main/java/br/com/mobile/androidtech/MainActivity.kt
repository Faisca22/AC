package br.com.mobile.androidtech

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)


        botao_login.setOnClickListener {onClickLogin() }

    }
    fun onClickLogin(){
        val valorUsuario = campo_usuario.text.toString()
        val valorSenha = campo_senha.text.toString()
        Toast.makeText(context, "$valorUsuario : $valorSenha", Toast.LENGTH_LONG).show()


        val intent = Intent(context, TelaInicialActivity::class.java)
        val params = Bundle()
        params.putString("usuario", valorUsuario)
        params.putString("senha", valorSenha)
        intent.putExtras(params)
        startActivity(intent)
    }




//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 1) {
//            val result = data?.getStringExtra("result")
//            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
//        }
//    }
   }










