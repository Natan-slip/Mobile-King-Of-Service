package br.com.kingofservice

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import br.com.kingofservice.R
import java.util.*

class TelaCadastroPrestador : AppCompatActivity() {

    lateinit var etDataNascimentoPrestador: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_cadastro_prestador)

        etDataNascimentoPrestador = findViewById(R.id.et_dataNascimentoCadastroPrestador)

        supportActionBar!!.title = "Novo Prestador"
        supportActionBar!!.subtitle = "cadastre os seus dados"
        supportActionBar!!.setBackgroundDrawable(getDrawable(R.drawable.toolbar))

        //Criar um calendário:
        val calendario = Calendar.getInstance() //Instancioams o Calendar da classe Java.util
        val ano = calendario.get(Calendar.YEAR) //Pegamos dessa instância de Calendar o ano
        val mes = calendario.get(Calendar.MONTH) //Pagamos o mês desse calendar
        val dia = calendario.get(Calendar.DAY_OF_MONTH) //Pegamos o dia do mês

        //Abrir o componente DatePicker
        etDataNascimentoPrestador.setOnClickListener {
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
                    etDataNascimentoPrestador.setText("$diaZero/$mesZero/$_ano")
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

            R.id.menu_help -> Toast.makeText(this
                ,"Ajuda com sucesso!!",
                Toast.LENGTH_SHORT).show()

        }

        return super.onOptionsItemSelected(item)
    }

}
