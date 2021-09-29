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
            IrParaTelaLogin()
        }
    }

    private fun IrParaTelaLogin(){

        val telaLogin = Intent(this,TelaLogin::class.java)
        startActivity(telaLogin)
    }
}