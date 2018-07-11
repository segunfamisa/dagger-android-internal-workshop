package trv.mse.katas.dagger.data.models

import com.google.gson.annotations.SerializedName


data class Movie(@SerializedName("poster_path") val posterPath: String,
                 @SerializedName("adult") val isAdult: Boolean,
                 @SerializedName("overview") val overview: String,
                 @SerializedName("release_date") val releaseDate: String,
                 @SerializedName("id") val id: Long,
                 @SerializedName("title") val title: String,
                 @SerializedName("backdrop_path") val backdropPath: String,
                 @SerializedName("popularity") val popularity: Double,
                 @SerializedName("vote_count") val voteCount: Long,
                 @SerializedName("video") val isVideo: Boolean,
                 @SerializedName("vote_average") val voteAverage: Double,
                 @SerializedName("imdb_id") val imdbId: String,
                 @SerializedName("homepage") val homepageUrl: String,
                 @SerializedName("runtime") val runtime: Long,
                 @SerializedName("budget") val budget: Long,
                 @SerializedName("production_companies") val productionCompanies: List<ProductionCompany>,
                 @SerializedName("tagline") val tagline: String,
                 @SerializedName("status") val status: String)