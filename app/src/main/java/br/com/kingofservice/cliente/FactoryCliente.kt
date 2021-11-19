package com.example.towersadmin.api

import br.com.kingofservice.cliente.ServiceCliente
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FactoryCliente {

    val Cliente_URL = "kingofservices/login"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(Cliente_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun serviceCliente() : ServiceCliente {
        return  retrofitFactory.create(ServiceCliente::class.java)
    }
}