package br.com.kingofservice

import android.app.DatePickerDialog
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_cadastro_prestador.*
import java.util.*

class TelaCadastroPrestador : AppCompatActivity() {

    var imageBitmap: Bitmap? = null
    lateinit var imgProfile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_prestador)

        supportActionBar!!.title = "Novo Prestador"
        supportActionBar!!.subtitle = "cadastre os seus dados"
        supportActionBar!!.setBackgroundDrawable(getDrawable(R.drawable.toolbar))

        //Criar um calendário:
        val calendario = Calendar.getInstance() //Instancioams o Calendar da classe Java.util
        val ano = calendario.get(Calendar.YEAR) //Pegamos dessa instância de Calendar o ano
        val mes = calendario.get(Calendar.MONTH) //Pagamos o mês desse calendar
        val dia = calendario.get(Calendar.DAY_OF_MONTH) //Pegamos o dia do mês

        //Abrir o componente DatePicker
        et_dataNascimentoCadastroPrestador.setOnClickListener {
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
                    et_dataNascimentoCadastroPrestador.setText("$diaZero/$mesZero/$_ano")
                }, ano, mes, dia
            )
            dpd.show()
        }

            Toast.makeText(this, "Dados gravados com sucesso!!", Toast.LENGTH_SHORT).show()

            finish()
        }

}