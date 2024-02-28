package com.example.data

import android.content.Context
import android.util.Log
import com.example.data.common.Constants
import com.example.data.common.TokenInterceptor
import com.example.data.webservice.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun provideCache(@ApplicationContext context: Context): Cache {
        val cacheDirectory = File(context.cacheDir, "offline_cache_directory")
        return Cache(cacheDirectory, 5 * 1024 * 1024)
    }

    @Provides
    fun provideTokenInterceptor(@ApplicationContext context: Context): Interceptor {
        return TokenInterceptor(context)
    }


    @Provides
    fun provideCertificatePinner(): CertificatePinner {
        return CertificatePinner.Builder()
            .add(Constants.hostName, Constants.sha256)
            .build()
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor {
            Log.e("api", it)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }

    @Provides
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
        certificatePinner: CertificatePinner,
        tokenInterceptor: TokenInterceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient
            .Builder()
            .cache(cache)
            .addInterceptor(loggingInterceptor)
            .certificatePinner(certificatePinner)
            .addInterceptor(tokenInterceptor)
            .build()
    }


    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun provideRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(Constants.baseURL)
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()

    }

    @Provides
    fun provideWebService(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }
}


