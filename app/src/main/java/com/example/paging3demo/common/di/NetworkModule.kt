package com.example.paging3demo.common.di

import com.example.paging3demo.BuildConfig
import com.example.paging3demo.main.model.remote.MainApi
import com.example.paging3demo.main.model.remote.MainWebService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { okhttpClient() }
    single { retrofit(get()) }
    single { apiService(get()) }
    single { provideMovieAppService(get()) }
}

fun provideMovieAppService(
    mainApi: MainApi
): MainWebService =
    MainWebService(mainApi)

fun apiService(
    retrofit: Retrofit
): MainApi = retrofit.create(
    MainApi::class.java)

fun retrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun okhttpClient(): OkHttpClient = OkHttpClient.Builder().build()