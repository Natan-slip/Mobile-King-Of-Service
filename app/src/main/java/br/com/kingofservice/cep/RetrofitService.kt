package br.com.kingofservice.cep


import br.com.kingofservice.Cadastro
import br.com.kingofservice.Cliente
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    //Método que será responsável por chamar a API
    // https://viacep.com.br/ws/06600025/json/

    @GET("{CEP}/json/")
    fun getCEP(@Path("CEP") cep: String): Call<Cep>

    @GET("{uf}/{cidade}/{logradouro}/json")
    fun getCEPByLogradouro(
        @Path("uf") uf: String,
        @Path("cidade") cidade: String,
        @Path("logradouro") logradouro: String) : Call<List<Cep>>

}