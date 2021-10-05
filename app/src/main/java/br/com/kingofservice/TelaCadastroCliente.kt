package br.com.kingofservice

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_cadastro_cliente.*
import kotlinx.android.synthetic.main.activity_tela_cadastro_prestador.*
import kotlinx.android.synthetic.main.activity_tela_login.*
import java.util.*

const val CODE_IMAGE = 100

class TelaCadastroCliente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_cliente)


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
}
