package trv.mse.katas.dagger.ui

import android.arch.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import trv.mse.katas.dagger.data.IMovieRepository
import trv.mse.katas.dagger.data.models.Movie
import trv.mse.katas.dagger.util.ISchedulerProvider
import javax.inject.Inject

class MoviesListViewModel @Inject constructor(private val movieRepo: IMovieRepository,
                                              private val scheduler: ISchedulerProvider) : ViewModel() {

    private val mShowMoviesSubject = PublishSubject.create<Boolean>()
    private val mEmptySubject = PublishSubject.create<Boolean>()
    private val mShowErrorSubject = PublishSubject.create<Boolean>()

    fun onMoviesLoaded(): Observable<List<Movie>> {
        return movieRepo.getPopularMovies(page = 1)
                .subscribeOn(scheduler.io())
                .doOnNext {
                    mEmptySubject.onNext(it.isEmpty())
                    mShowMoviesSubject.onNext(!it.isEmpty())
                    mShowErrorSubject.onNext(false)
                }
                .doOnError {
                    mEmptySubject.onNext(false)
                    mShowMoviesSubject.onNext(false)
                    mShowErrorSubject.onNext(true)
                }
    }

    fun onShowMovies(): Observable<Boolean> = mShowMoviesSubject.hide()

    fun onShowEmptyState(): Observable<Boolean> = mEmptySubject.hide()

    fun onShowErrorState(): Observable<Boolean> = mShowErrorSubject.hide()
}
