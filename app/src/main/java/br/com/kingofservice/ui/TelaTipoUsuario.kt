package br.com.kingofservice.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class TelaTipoUsuario : AppCompatActivity() {

    lateinit var btnPrestador: Button
    lateinit var btnCliente: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_tipo_usuario)

        btnPrestador = findViewById(R.id.btt_prestador)
        btnCliente = findViewById(R.id.btt_cliente)

        btnPrestador.setOnClickListener {
            TelaCadastroPrestador()
        }

        btnCliente.setOnClickListener {
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