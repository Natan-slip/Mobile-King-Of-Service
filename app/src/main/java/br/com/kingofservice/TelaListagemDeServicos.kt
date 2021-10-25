package br.com.kingofservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class TelaListagemDeServicos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_listagem_de_servicos)

        supportActionBar!!.title = "Listagem de Serviços"
        supportActionBar!!.setBackgroundDrawable(getDrawable(R.drawable.toolbar))

//        @Override public boolean onCreateOptionsMenu(menu: Menu?) {
//            menuInflater.inflate(R.menu.menu_novo_usuario,menu);
//            return true;
//        }
    }
}