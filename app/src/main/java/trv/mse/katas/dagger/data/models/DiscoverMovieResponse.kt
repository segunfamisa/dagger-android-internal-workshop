package trv.mse.katas.dagger.data.models

import com.google.gson.annotations.SerializedName


data class DiscoverMovieResponse(
        @SerializedName("page") val page: Long = 0,
        @SerializedName("results") var results: List<Movie>? = null,
        @SerializedName("total_pages") val totalPages: Long = 0,
        @SerializedName("total_results") val totalResults: Long = 0
)