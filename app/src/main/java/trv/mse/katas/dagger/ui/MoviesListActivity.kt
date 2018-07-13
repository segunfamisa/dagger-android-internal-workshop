package trv.mse.katas.dagger.ui

import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import trv.mse.katas.dagger.R
import javax.inject.Inject

class MoviesListActivity : BaseActivity() {

    companion object {
        private const val TAG = "MoviesList"
    }

    @Inject
    lateinit var viewModel: MoviesListViewModel

    private val compositeDisposable = CompositeDisposable()

    // region Android Lifecycle events

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidInjection.inject(this)

        setContentView(R.layout.activity_main)

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
                        Log.d(TAG, "Movies: $it")
                    },

            viewModel.onShowMovies()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        // show movies if true
                        Log.d(TAG, "Show movies?: $it")
                    },

            viewModel.onShowEmptyState()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        // show empty state
                        Log.d(TAG, "Show empty state?: $it")
                    },

            viewModel.onShowErrorState()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        // show error message
                        Log.d(TAG, "Show error state?: $it")
                    }
    )

    // endregion
}
