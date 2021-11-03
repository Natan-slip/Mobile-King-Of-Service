package br.com.kingofservice.ui

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.kingofservice.Cliente
import br.com.kingofservice.R
import br.com.kingofservice.RetrofitFactory
import kotlinx.android.synthetic.main.activity_tela_cadastro_cliente.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

const val CODE_IMAGE = 100

class TelaCadastroCliente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_cliente)

        supportActionBar!!.title = "Novo usuário"
        supportActionBar!!.subtitle = "cadastre os seus dados"
        supportActionBar!!.setBackgroundDrawable(getDrawable(R.drawable.toolbar))

        //Criar um calendário:
        val calendario = Calendar.getInstance() //Instancioams o Calendar da classe Java.util
        val ano = calendario.get(Calendar.YEAR) //Pegamos dessa instância de Calendar o ano
        val mes = calendario.get(Calendar.MONTH) //Pagamos o mês desse calendar
        val dia = calendario.get(Calendar.DAY_OF_MONTH) //Pegamos o dia do mês

        //Abrir o componente DatePicker
        et_dataNascimentoCadastroCliente.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, _ano, _mes, _dia ->
                    var diaZero = _dia.toString()
                    var mesZero = _mes.toString()
                    if (_dia < 10) {
                        diaZero = "0$_dia"
                    }

                    if (_mes < 9) {
                        mesZero = "0${_mes + 2}"
                    }
                    et_dataNascimentoCadastroCliente.setText("$diaZero/$mesZero/$_ano")
                }, ano, mes, dia
            )
            dpd.show()
        }
    }

    // Parte de Menu

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_novo_usuario,menu);
        return true;
    }

    private fun salvar()

    private fun trocaTela() {
        val intent = Intent(this, TelaListagem::class.java)
        startActivity(intent)
    }

    private fun cancelarTela() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_save -> {
                trocaTela()
                return true
            }

            R.id.menu_cancel -> {
                cancelarTela()
                return true
            }

            R.id.menu_help -> Toast.makeText(
                this,
                "Ajuda com sucesso!!",
                Toast.LENGTH_SHORT).show()

        }

        return super.onOptionsItemSelected(item)
    }
}

//private fun salvar() {
//        val cliente = Cliente(0, et_nomeCadastroCliente.text.toString(), et_emailCadastroCliente.text.toString(), et_senhaCadastroCliente.text.toString())
//
//        //Obter uma instância da conexão com o Backend
//        val remote = RetrofitFactory().retrofitService()
//
//        //Criar uma chamada para o endpoint /cep/json
//        val call: Call<Cliente> =  remote.gravarCadastro(cliente)
//
//        //Executar a chamada para a api
//        call.enqueue(object : Callback<Cliente> {
//            override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
//                Toast.makeText(applicationContext, "deu certo", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onFailure(call: Call<Cliente>, t: Throwable) {
//                Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
//                Log.i("cliente", t.message.toString())
//    }