package br.com.kingofservice.ui

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.com.kingofservice.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

const val CODE_IMAGE = 100

class TelaCadastroCliente : AppCompatActivity() {

    lateinit var etCepCliente: EditText
    lateinit var etEstadoCliente: EditText
    lateinit var etCidadeCliente: EditText
    lateinit var etBairroCliente: EditText
    lateinit var etRuaCliente: EditText
    lateinit var etNome: EditText
    lateinit var etSenha: EditText
    lateinit var etEmail: EditText

    lateinit var etDataNascimentoCliente: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_cliente)

        val cepCliente = findViewById<EditText>(R.id.et_cepCadastroCliente)
        val estadoCliente = findViewById<EditText>(R.id.et_estadoCadastroCliente)
        val cidadeCliente = findViewById<EditText>(R.id.et_cidadeCadastroCliente)
        val bairroCliente = findViewById<EditText>(R.id.et_bairroCadastroCliente)
        val ruaCliente = findViewById<EditText>(R.id.et_ruaCadastroCliente)
        etCepCliente = findViewById(R.id.et_cepCadastroCliente)
        etRuaCliente = findViewById(R.id.et_ruaCadastroCliente)
        etEstadoCliente = findViewById(R.id.et_estadoCadastroCliente)
        etCidadeCliente = findViewById(R.id.et_cidadeCadastroCliente)
        etBairroCliente = findViewById(R.id.et_bairroCadastroCliente)
        etDataNascimentoCliente = findViewById(R.id.et_dataNascimentoCadastroCliente)
        etNome = findViewById(R.id.et_nomeCadastroCliente)
        etSenha = findViewById(R.id.et_senhaCadastroCliente)
        etEmail= findViewById(R.id.et_emailCadastroCliente)

        val btnCliente = findViewById<Button>(R.id.btn_Cliente)

        btnCliente.setOnClickListener {

            val endereco = Endereco()
            endereco.zipcode = cepCliente.text.toString()
            endereco.street = ruaCliente.text.toString()
            endereco.state = estadoCliente.text.toString()
            endereco.city = cidadeCliente.text.toString()
            endereco.neighborhood = bairroCliente.text.toString()
        }

            cepCliente.setOnFocusChangeListener { v, hasFocus ->

                val cep = cepCliente.text

                if (!hasFocus && cep.length == 8) {
                    searchByCEP()
                    cepCliente.error = null
                }

                if (!hasFocus && cep.length < 8) {
                    cepCliente.error = "CEP inválido"
                }
            }

            supportActionBar!!.title = "Novo usuário"
            supportActionBar!!.subtitle = "cadastre os seus dados"
            supportActionBar!!.setBackgroundDrawable(getDrawable(R.drawable.toolbar))

            //Criar um calendário:
            val calendario = Calendar.getInstance() //Instancioams o Calendar da classe Java.util
            val ano = calendario.get(Calendar.YEAR) //Pegamos dessa instância de Calendar o ano
            val mes = calendario.get(Calendar.MONTH) //Pagamos o mês desse calendar
            val dia = calendario.get(Calendar.DAY_OF_MONTH) //Pegamos o dia do mês

            //Abrir o componente DatePicker
        etDataNascimentoCliente.setOnClickListener {
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
                        etDataNascimentoCliente.setText("$diaZero/$mesZero/$_ano")
                    }, ano, mes, dia
                )
                dpd.show()
            }

        btnCliente.setOnClickListener {
            val cliente = Cliente(
                0,
                etNome.text.toString(),
                etEmail.text.toString(),
                etSenha.text.toString()
            )

            //Obter uma instância da conexão com o Backend
            val remote = RetrofitFactory().retrofitService()

            //Criar uma chamada para o endpoint /cep/json
            val call: Call<Cliente> = remote.gravarCliente(cliente)

            //Executar a chamada para a api
            call.enqueue(object : Callback<Cliente> {
                override fun onResponse(call: Call<Cliente>, response: Response<Cliente>) {
                    Toast.makeText(applicationContext, "deu certo!!", Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<Cliente>, t: Throwable) {
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

// Parte de Menu

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu_novo_usuario, menu);
            return true;
        }

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
                    Toast.LENGTH_SHORT
                ).show()

            }

            return super.onOptionsItemSelected(item)
        }

    private fun searchByCEP() {

        val cep = etCepCliente.text

        val remote = RetrofitFactory().retrofitService()
        val call: Call<Cep> = remote.getCEP(cep.toString())

        call.enqueue(object : Callback<Cep> {
            override fun onResponse(call: Call<Cep>, response: Response<Cep>) {
                val cep = response.body()
                if (cep != null) {
                    etRuaCliente.setText(cep.logradouro)
                    etEstadoCliente.setText(cep.uf)
                    etCidadeCliente.setText(cep.cidade)
                    etBairroCliente.setText(cep.bairro)
                }
            }

            override fun onFailure(call: Call<Cep>, t: Throwable) {
                Log.i("cep", t.message.toString())
            }

        })
    }

}

