package trv.mse.katas.dagger.data.api

import trv.mse.katas.dagger.BuildConfig

class ApiKeyProvider : IApiKeyProvider {

    override fun getApiKey(): String {
        return BuildConfig.API_KEY
    }

}
