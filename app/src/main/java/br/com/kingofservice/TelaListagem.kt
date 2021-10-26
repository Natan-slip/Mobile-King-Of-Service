package br.com.kingofservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class TelaListagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_listagem)

        supportActionBar!!.title = "King Of Services"
        supportActionBar!!.setBackgroundDrawable(getDrawable(R.drawable.toolbar))



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    menuInflater.inflate(R.menu.menu_busca,menu);
    return true;
    }

    private fun trocaTela() {
        val intent = Intent(this, TelaFeed::class.java)
        startActivity(intent)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.profile -> Toast.makeText(
                this,
                "Acessado com sucesso!!",
                Toast.LENGTH_SHORT).show()

            R.id.busca_servicos -> Toast.makeText(
                this,
                "Acessado com sucesso!!",
                Toast.LENGTH_SHORT).show()

            R.id.principais_categorias -> {
                trocaTela()
                return true
            }

            R.id.logout -> Toast.makeText(this
                ,"Saiu com sucesso!!",
                Toast.LENGTH_SHORT).show()

        }

        return super.onOptionsItemSelected(item)
    }

}