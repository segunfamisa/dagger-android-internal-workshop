package trv.mse.katas.dagger.data

import io.reactivex.Observable
import trv.mse.katas.dagger.data.models.Movie

interface IMovieRepository {

    /*
     * Get list of popular movies
     */
    fun getPopularMovies(page: Int): Observable<List<Movie>>

    /**
     * Get movie details given a movie id
     */
    fun getMovieDetails(movieId: Long): Observable<Movie>

}
