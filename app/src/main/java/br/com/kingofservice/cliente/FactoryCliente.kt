package com.example.towersadmin.api

import br.com.kingofservice.URLs
import br.com.kingofservice.URLs.CADASTRO_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit instance class
 */
class FactoryCliente {

    private lateinit var serviceCliente: ServiceCliente

    fun getApiService(): ServiceCliente {

        // Initialize ApiService if not initialized yet
        if (!::serviceCliente.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(URLs.CADASTRO_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            serviceCliente = retrofit.create(ServiceCliente::class.java)
        }

        return serviceCliente
    }
}