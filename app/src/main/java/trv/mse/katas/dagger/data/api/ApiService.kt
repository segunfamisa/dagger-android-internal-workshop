package trv.mse.katas.dagger.data.api

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import trv.mse.katas.dagger.data.models.DiscoverMovieResponse
import trv.mse.katas.dagger.data.models.Movie


interface ApiService {

    /**
     * Discover movie
     */
    @GET("discover/movie")
    fun discover(@Query("sort_by") sortBy: String = "popularity.desc",
                 @Query("page") page: Int,
                 @Query("api_key") apiKey: String): Observable<DiscoverMovieResponse>

    /**
     * Get movie details
     *
     * @param movieId - movie id
     * @param apiKey - API key
     */
    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: Long,
                        @Query("api_key") apiKey: String): Observable<Movie>


    class Creator {

        companion object {

            @JvmStatic
            fun create(): ApiService {
                val retrofit = Retrofit.Builder()
                        .addCallAdapterFactory(
                                RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                        .addConverterFactory(GsonConverterFactory.create())
                        .baseUrl("https://api.themoviedb.org/3/")
                        .build()
                return retrofit.create(ApiService::class.java)
            }
        }
    }

}
