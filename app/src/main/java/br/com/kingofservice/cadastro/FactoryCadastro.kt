package br.com.kingofservice.cadastro

import br.com.kingofservice.URLs
import br.com.kingofservice.URLs.CADASTRO_URL
import br.com.kingofservice.cliente.ServiceCliente
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FactoryCadastro {

    val Cadastro_URL = "kingofservices/cadastro"

    val retrofitFactory = Retrofit.Builder()
        .baseUrl(Cadastro_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun serviceCadastro() : ServiceCadastro {
        return  retrofitFactory.create(ServiceCadastro::class.java)
    }
}