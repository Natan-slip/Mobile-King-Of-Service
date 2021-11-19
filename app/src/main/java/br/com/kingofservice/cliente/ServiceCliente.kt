package br.com.kingofservice.cliente

import br.com.kingofservice.Cliente
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface ServiceCliente {

    @GET("clientes")
    fun gravarCliente(@Body cliente: Cliente) : Call<Cliente>

}