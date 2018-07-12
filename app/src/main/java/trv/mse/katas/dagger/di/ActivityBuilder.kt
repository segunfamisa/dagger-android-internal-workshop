package trv.mse.katas.dagger.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import trv.mse.katas.dagger.ui.MoviesListActivity
import trv.mse.katas.dagger.ui.di.MoviesListModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MoviesListModule::class])
    abstract fun bindMoviesListActivity(): MoviesListActivity
}
