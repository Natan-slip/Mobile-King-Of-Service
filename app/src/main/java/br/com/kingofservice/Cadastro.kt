package br.com.kingofservice

import java.time.LocalDate

data class Cadastro(
    var id: Long,
    var nome: String,
    var email: String,
    var senha: String,
    var dataNascimento : String
)
