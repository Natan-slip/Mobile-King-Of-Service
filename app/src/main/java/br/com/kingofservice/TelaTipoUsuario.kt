package br.com.kingofservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tela_tipo_usuario.*

class TelaTipoUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_tipo_usuario)

        btt_prestador.setOnClickListener {
            TelaCadastroPrestador()
        }

        btt_cliente.setOnClickListener {
            TelaCadastroCliente()
        }
    }

    private fun TelaCadastroCliente(){

        val telaCliente = Intent(this,TelaCadastroCliente::class.java)
        startActivity(telaCliente)
    }

    private fun TelaCadastroPrestador(){

        val telaCadastroPrestador = Intent(this,TelaCadastroPrestador::class.java)
        startActivity(telaCadastroPrestador)
    }
}