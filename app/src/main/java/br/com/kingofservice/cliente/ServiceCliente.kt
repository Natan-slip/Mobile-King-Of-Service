package com.example.towersadmin.api

import br.com.kingofservice.Cadastro
import br.com.kingofservice.URLs
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ServiceCliente {
    @POST(URLs.CADASTRO_URL)
    fun Cadastro(@Body loginRequest: Cadastro): Call<Cadastro>
}