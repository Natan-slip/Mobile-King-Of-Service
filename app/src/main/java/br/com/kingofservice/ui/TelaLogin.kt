package br.com.kingofservice.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.com.kingofservice.Cliente
import com.example.towersadmin.api.FactoryCliente
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaLogin : AppCompatActivity() {

    lateinit var editUser: EditText
    lateinit var editPassword: EditText
    lateinit var btnFazerLogin: Button
    lateinit var tvMensagemErro: TextView
    lateinit var tvCrieSuaConta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_login)

        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
        val lembrar = dados.getBoolean("lembrar", false)

        if (lembrar == true){
        }

        editUser = findViewById(R.id.et_email)
        editPassword = findViewById(R.id.et_senha)
        tvMensagemErro = findViewById(R.id.tv_mensagem_erro)
        tvCrieSuaConta = findViewById(R.id.tv_crie_sua_conta)
        btnFazerLogin = findViewById(R.id.btt_fazerLogin)

        btnFazerLogin.setOnClickListener {
            val cliente = Cliente(
                0,
                editUser.text.toString(),
                editPassword.text.toString()
            )

            //Obter uma instância da conexão com o Backend
            val remote = FactoryCliente().serviceCliente()

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

//        btnFazerLogin.setOnClickListener {
//            val intent = Intent(this, TelaListagem::class.java)
//            startActivity(intent)
//        }


        tvCrieSuaConta.setOnClickListener {
            val intent = Intent(this, TelaTipoUsuario::class.java)
            startActivity(intent)
        }
    }
}