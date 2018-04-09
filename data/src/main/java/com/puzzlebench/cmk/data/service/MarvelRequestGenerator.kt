package com.puzzlebench.cmk.data.service

import com.puzzlebench.cmk.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.NoSuchAlgorithmException


class MarvelRequestGenerator {
    private val QUERY_PARAMETER_KEY_HASH = "hash"
    private val QUERY_PARAMETER_KEY_API_KEY = "apikey"
    private val QUERY_PARAMETER_KEY_TS = "ts"
    private val builder = Retrofit.Builder()
            .baseUrl(BuildConfig.MARVEL_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    private fun getHttpClient() : OkHttpClient {
        // TODO: add proper environment configuration
        return OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val defaultRequest = chain.request()
                    val timestamp = System.currentTimeMillis().toString()
                    val defaultHttpUrl = defaultRequest.url()
                    val httpUrl = defaultHttpUrl.newBuilder()
                            .addQueryParameter(QUERY_PARAMETER_KEY_API_KEY, BuildConfig.PUBLIC_API_KEY_VALUE)
                            .addQueryParameter(
                                    QUERY_PARAMETER_KEY_HASH,
                                    md5(timestamp + BuildConfig.PRIVATE_API_KEY_VALUE + BuildConfig.PUBLIC_API_KEY_VALUE)
                            )
                            .addQueryParameter(QUERY_PARAMETER_KEY_TS, timestamp)
                            .build()

                    val requestBuilder = defaultRequest.newBuilder().url(httpUrl)
                    chain.proceed(requestBuilder.build())
                }
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
    }

    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder.client(getHttpClient()).build()
        return retrofit.create(serviceClass)
    }

    fun md5(s: String): String {
        val MD5 = "MD5"
        try {
            // Create MD5 Hash
            val digest = java.security.MessageDigest
                    .getInstance(MD5)
            digest.update(s.toByteArray())
            val messageDigest = digest.digest()

            // Create Hex String
            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2)
                    h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return ""
    }
}