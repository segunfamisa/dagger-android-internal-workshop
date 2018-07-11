package trv.mse.katas.dagger.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import trv.mse.katas.dagger.data.IMovieRepository
import trv.mse.katas.dagger.util.ISchedulerProvider

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val movieRepo: IMovieRepository,
                       private val scheduler: ISchedulerProvider) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesListViewModel::class.java)) {
            return MoviesListViewModel(movieRepo, scheduler) as T
        }
        throw IllegalArgumentException("Don't know how to handle this viewmodel")
    }

}