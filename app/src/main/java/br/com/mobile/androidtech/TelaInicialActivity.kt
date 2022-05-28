package br.com.mobile.androidtech

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*
import java.net.URL

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val context: Context get() = this
    private var paises = listOf<Pais>()
    private var REQUEST_CADASTRO = 1
    private var REQUEST_REMOVE= 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val usuario = args?.getString("usuario")
        val senha = args?.getString("senha")

        Toast.makeText(context, "Nome do usuário: $usuario", Toast.LENGTH_LONG).show()
        Toast.makeText(context, "Senha: $senha", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar)
        supportActionBar?.title = "Tela Inicial"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
        recyclerPaises?.layoutManager = LinearLayoutManager(context)
        recyclerPaises?.itemAnimator = DefaultItemAnimator()
        recyclerPaises?.setHasFixedSize(true)
    }

    fun taskPaises(){
        Thread{
            this.paises = PaisesService.getPaises(context)
            runOnUiThread{
                recyclerPaises?.adapter = PaisesAdapter(this.paises) {onClickPais(it)}
            }
        }.start()
    }


    override fun onResume() {
        super.onResume()
        taskPaises()
    }
    fun onClickPais(pais:Pais){
        Toast.makeText(this, "Clicou no ${pais.nome}", Toast.LENGTH_SHORT).show()
        Toast.makeText(context, "Clicou disciplina ${pais.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, PaisesActivity::class.java)
        intent.putExtra("pais", pais)
        startActivityForResult(intent, REQUEST_REMOVE)
    }
    private fun configuraMenuLateral() {
        var toogle =
            ActionBarDrawerToggle(this, layoutMenuLateral, toolbar, R.string.open, R.string.close)
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()
        menu_lateral.setNavigationItemSelectedListener(this)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.nav_paises) {
            Toast.makeText(this, "Clicou Países", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PaisesActivity ::class.java)
            startActivity(intent)

        } else if (id == R.id.nav_sobre) {
            Toast.makeText(this, "Clicou Sobre", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SobreActivity ::class.java)
            startActivity(intent)

        } else if (id == R.id.nav_sair) {
            Toast.makeText(this, "Clicou Sair", Toast.LENGTH_SHORT).show()
            finish()
        }
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        (menu?.findItem(R.id.action_buscar)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item?.itemId
        if  (id == R.id.action_buscar) {
            Toast.makeText(context, "Botão de buscar", Toast.LENGTH_LONG).show()

        } else if (id == R.id.action_atualizar) {
            Toast.makeText(context, "Botão de buscar", Toast.LENGTH_LONG).show()

        } else if (id == R.id.action_config) {
            Toast.makeText(context, "Botão de configuracoes", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ConfiguracoesActivity ::class.java)
            startActivity(intent)
        }

        else if (id == R.id.action_adicionar){
            Toast.makeText(context, "Botão adicionar", Toast.LENGTH_LONG).show()
            val intent = Intent(this, AdicionarActivity::class.java)
            startActivity(intent)
        }

        else if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CADASTRO || requestCode == REQUEST_REMOVE ) {
            // atualizar lista de disciplinas
            taskPaises()
        }
    }

}