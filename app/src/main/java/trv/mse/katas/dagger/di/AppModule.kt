package trv.mse.katas.dagger.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import trv.mse.katas.dagger.MovieApplication
import trv.mse.katas.dagger.util.DefaultSchedulerProvider
import trv.mse.katas.dagger.util.ISchedulerProvider
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideApplication(application: Application): MovieApplication {
        return application as MovieApplication
    }

    @Singleton
    @Provides
    fun provideSchedulerProvider(): ISchedulerProvider {
        return DefaultSchedulerProvider()
    }
}
