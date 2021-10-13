package br.com.kingofservice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.com.kingofservice.dao.UsuarioDao

class TelaLogin : AppCompatActivity() {

    lateinit var editUser: EditText
    lateinit var editPassword: EditText
    lateinit var btnLogin: Button
    lateinit var tvMensagemErro: TextView
    lateinit var tvCrieSuaConta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
        val lembrar = dados.getBoolean("lembrar", false)

        if (lembrar == true){
            abrirDashBoard()
        }

        editUser = findViewById(R.id.et_email)
        editPassword = findViewById(R.id.et_senha)
        btnLogin = findViewById(R.id.btt_login)
        tvMensagemErro = findViewById(R.id.tv_mensagem_erro)
        tvCrieSuaConta = findViewById(R.id.tv_crie_sua_conta)

        tvCrieSuaConta.setOnClickListener {
            val intent = Intent(this, TelaTipoUsuario::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            login()
        }

        var dataInicio = "1986-10-18"

        var ano = dataInicio.substring(0, 4).toInt()
        var mes = dataInicio.substring(5, 7).toInt()
        var dia = dataInicio.substring(8, 10).toInt()

        Log.i("XPTO2", ano.toString())
        Log.i("XPTO2", mes.toString())
        Log.i("XPTO2", dia.toString())

    }

    private fun abrirDashBoard() {
        val intent = Intent(this, TelaFeed::class.java)
        startActivity(intent)
        finish()
    }

    private fun login() {
        // email: user@email.com
        // senha: 123

        val user = editUser.text.toString()
        val pass = editPassword.text.toString()

        val dao = UsuarioDao(this, null)

        val autenticado = dao.autenticar(user, pass)

        if (autenticado) {
            abrirDashBoard()
        }

    }
}