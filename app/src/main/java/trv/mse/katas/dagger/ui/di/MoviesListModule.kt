package trv.mse.katas.dagger.ui.di

import android.arch.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import trv.mse.katas.dagger.data.IMovieRepository
import trv.mse.katas.dagger.data.MovieRepository
import trv.mse.katas.dagger.di.viewmodel.ViewModelKey
import trv.mse.katas.dagger.ui.MoviesListViewModel

@Module
abstract class MoviesListModule {

    @Binds
    @IntoMap
    @ViewModelKey(MoviesListViewModel::class)
    abstract fun bindMoviesListViewModel(viewModel: MoviesListViewModel): ViewModel

    @Binds
    abstract fun bindMovieRepository(repository: MovieRepository): IMovieRepository
}
