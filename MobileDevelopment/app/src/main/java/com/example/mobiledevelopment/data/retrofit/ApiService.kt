package com.example.mobiledevelopment.data.retrofit

import com.example.mobiledevelopment.data.response.DestinationResponse
import com.example.mobiledevelopment.data.response.LoginResponse
import com.example.mobiledevelopment.data.response.RegisterResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("username") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

//    @FormUrlEncoded
    @POST("main")
    suspend fun getStories(
        @Header("Authorization") auth: String,
        @Body body: RequestBody
    ): Response<DestinationResponse>

    data class GetStoriesRequest(
        val lat : Double = 0.0,
        val long : Double = 0.0,
        val age : Int = 0,
        val category: String = ""
    )
}