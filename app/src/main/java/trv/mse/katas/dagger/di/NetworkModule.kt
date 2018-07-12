package trv.mse.katas.dagger.di

import dagger.Module
import dagger.Provides
import trv.mse.katas.dagger.data.api.ApiKeyProvider
import trv.mse.katas.dagger.data.api.ApiService
import trv.mse.katas.dagger.data.api.IApiKeyProvider
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiService.Creator.create()
    }

    @Provides
    @Singleton
    fun provideApiKeyProvider(): IApiKeyProvider {
        return ApiKeyProvider()
    }
}
