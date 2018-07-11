package trv.mse.katas.dagger.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import trv.mse.katas.dagger.R
import trv.mse.katas.dagger.data.IMovieRepository
import trv.mse.katas.dagger.data.MovieRepository
import trv.mse.katas.dagger.data.api.ApiKeyProvider
import trv.mse.katas.dagger.data.api.ApiService
import trv.mse.katas.dagger.data.api.IApiKeyProvider
import trv.mse.katas.dagger.util.DefaultSchedulerProvider
import trv.mse.katas.dagger.util.ISchedulerProvider

class MoviesListActivity : BaseActivity() {

    private lateinit var viewModel: MoviesListViewModel

    private val compositeDisposable = CompositeDisposable()

    private lateinit var apiKeyProvider: IApiKeyProvider
    private lateinit var apiService: ApiService
    private lateinit var movieRepository: IMovieRepository
    private lateinit var schedulerProvider: ISchedulerProvider
    private lateinit var viewModelFactory: ViewModelProvider.Factory

    // region Android Lifecycle events

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createDependencies()

        viewModelBindings().forEach {
            compositeDisposable.add(it)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable.dispose()
    }

    // endregion

    // region Private APIs

    private fun viewModelBindings() = listOf(
            viewModel.onMoviesLoaded()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        // update adapter
                    },

            viewModel.onShowMovies()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        // show movies if true
                    },

            viewModel.onShowEmptyState()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        // show empty state
                    },

            viewModel.onShowErrorState()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        // show error message
                    }
    )

    private fun createDependencies() {
        apiService = ApiService.Creator.create()
        apiKeyProvider = ApiKeyProvider()

        movieRepository = MovieRepository(apiService = apiService, apiKeyProvider = apiKeyProvider)
        schedulerProvider = DefaultSchedulerProvider()

        viewModelFactory = ViewModelFactory(movieRepository, schedulerProvider)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MoviesListViewModel::class.java)
    }

    // endregion
}
