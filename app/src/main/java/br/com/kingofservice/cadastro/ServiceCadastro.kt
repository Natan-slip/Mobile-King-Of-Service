package br.com.kingofservice.cadastro

import br.com.kingofservice.Cadastro
import br.com.kingofservice.Cliente
import br.com.kingofservice.URLs
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ServiceCadastro {

    @POST("clientes")
    fun gravarCliente(@Body cliente: Cliente) : Call<Cliente>

}