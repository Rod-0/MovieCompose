package upc.edu.moviecompose.data.model

import com.google.gson.annotations.SerializedName

data class Movie (
    val id: Int,
    val title: String,

    @SerializedName("poster_path")
    val urlImage: String
)

data class MovieResponse(
    val page: Int,

    @SerializedName("results")
    val movies: List<Movie>,


)