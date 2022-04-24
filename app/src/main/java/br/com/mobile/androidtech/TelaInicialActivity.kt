package br.com.mobile.androidtech

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity : DebugActivity() {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val usuario = args?.getString("usuario")
        val senha = args?.getString("senha")

        Toast.makeText(context, "Nome do usuário: $usuario", Toast.LENGTH_LONG).show()
        Toast.makeText(context, "Senha: $senha", Toast.LENGTH_LONG).show()

        mensagemInicial.text = "Bem vindo, $usuario"




        botaoSair.setOnClickListener {cliqueSair()}
    }

    fun cliqueSair() {
        val returnIntent = Intent();
        returnIntent.putExtra("result","Saída do LMSApp");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}