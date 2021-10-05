package br.com.kingofservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btt_login.setOnClickListener {
            TelaLogin()
        }

        btt_cadastro.setOnClickListener {
            TelaTipoUsuario()
        }
    }

    private fun TelaLogin(){

        val telaLogin = Intent(this,TelaLogin::class.java)
        startActivity(telaLogin)
    }


// Funcionalidade de quando clicar em Cadastre-se ir para os tipos de categorias


    private fun TelaTipoUsuario(){

        val telaTipoUsuario = Intent(this,TelaTipoUsuario::class.java)
        startActivity(telaTipoUsuario)
    }
}

//Código do menu para salvar e tals
//
//<?xml version="1.0" encoding="utf-8"?>
//<menu xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:app="http://schemas.android.com/apk/res-auto">
//<item
//android:id="@+id/menu_save"
//android:title="Salvar"
//android:icon="@drawable/save_24"
//app:showAsAction="always"/>
//
//<item
//android:id="@+id/menu_cancelar"
//android:icon="@drawable/cancel_24"
//android:title="Cancelar"
//app:showAsAction="never"/>
//
//<item
//android:id="@+id/menu_help"
//android:icon="@drawable/help_24"
//android:title="help"
//app:showAsAction="never"/>
//</menu>