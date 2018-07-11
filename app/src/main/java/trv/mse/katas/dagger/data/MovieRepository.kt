package trv.mse.katas.dagger.data

import io.reactivex.Observable
import trv.mse.katas.dagger.data.api.ApiService
import trv.mse.katas.dagger.data.api.IApiKeyProvider
import trv.mse.katas.dagger.data.models.Movie

class MovieRepository(private val apiService: ApiService,
                      private val apiKeyProvider: IApiKeyProvider) : IMovieRepository {

    override fun getPopularMovies(page: Int): Observable<List<Movie>> {
        return apiService.discover(page = page, apiKey = apiKeyProvider.getApiKey())
                .map { it.results ?: arrayListOf() }
    }

    override fun getMovieDetails(movieId: Long): Observable<Movie> {
        return apiService.getMovieDetails(movieId = movieId, apiKey = apiKeyProvider.getApiKey())
    }

}
