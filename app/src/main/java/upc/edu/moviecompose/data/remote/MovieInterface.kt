package upc.edu.moviecompose.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {
    @GET("popular")
    fun getMovies(@Query("api_key") apiKey: String = "b7f2a7d0b0e3b0c7d4f9f8b2b2b3b2b1")
}