package br.com.kingofservice

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import br.com.kingofservice.dao.UsuarioDao
import br.com.kingofservice.model.Usuario
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

        fun salvar() {
            val usuario = Usuario(
                0,
                et_emailCadastroPrestador.text.toString(),
                et_senhaCadastroPrestador.text.toString(),
                et_nomeCadastroPrestador.text.toString(),
                et_profissaoCadastroPrestador.text.toString(),
                et_dataNascimentoCadastroPrestador.text.toString(),
                if(radio_feminino.isChecked) "Feminino" else "Masculino",
                imageBitmap

            )

            val dao = UsuarioDao(this, usuario)
            dao.gravar()

            Toast.makeText(this, "Dados gravados com sucesso!!", Toast.LENGTH_SHORT).show()

            finish()
        }


        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == CODE_IMAGE && resultCode == -1) {

                // Recuperar a imagem no stream
                val stream = contentResolver.openInputStream(data!!.data!!)

                // Transformar o stream em um BitMap
                imageBitmap = BitmapFactory.decodeStream(stream)

                // Colocar a imagem no ImageView
                imgProfile.setImageBitmap(imageBitmap)
            }

        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            // Handle item selection
            when (item.itemId) {
                R.id.menu_save -> {
                    Toast.makeText(this,"Salvar",Toast.LENGTH_LONG).show()
                    salvar()
                    return true
                }
                R.id.menu_cancel -> {
                    Toast.makeText(this,"Cancelar",Toast.LENGTH_LONG).show()
                    return true
                }
                R.id.menu_help ->{
                    Toast.makeText(this,"Ajuda",Toast.LENGTH_LONG).show()
                    return true
                }
            }
            return super.onOptionsItemSelected(item)
        }

    }
}