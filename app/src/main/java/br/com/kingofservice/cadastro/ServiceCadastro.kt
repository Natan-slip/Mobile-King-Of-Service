package br.com.kingofservice.cadastro

import br.com.kingofservice.Cadastro
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ServiceCadastro {

    @POST("cadastro")
    fun gravarCadastro(@Body cadastro: Cadastro) : Call<Cadastro>

}