package br.com.kingofservice;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("cadastro")
    fun getCadastro(@Path("Cadastro")cadastro: String) : Call<Cadastro>


    @POST("clientes")
    fun 

}
