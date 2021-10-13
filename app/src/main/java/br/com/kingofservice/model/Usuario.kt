package br.com.kingofservice.model

import android.graphics.Bitmap

data class Usuario(
    var id: Int = 0,
    var email: String,
    var senha: String,
    var nome: String,
    var profissao: String,
    var dataNascimento: String,
    var sexo: Char,
    var foto: Any? = null,
    var imageBitmap: Bitmap?
)