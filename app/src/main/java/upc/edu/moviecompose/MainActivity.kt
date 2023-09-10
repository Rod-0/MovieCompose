package upc.edu.moviecompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upc.edu.moviecompose.data.model.Movie
import upc.edu.moviecompose.data.model.MovieResponse
import upc.edu.moviecompose.data.remote.ApiClient
import upc.edu.moviecompose.ui.movies.MovieList
import upc.edu.moviecompose.ui.theme.MovieComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MovieComposeTheme {
                // A surface container using the 'background' color from the theme
                val movies = remember { mutableStateOf(listOf<Movie>()) }
                val movieInterface = ApiClient.getMovieInterface()
                val getMovies = movieInterface.getMovies()

                getMovies.enqueue(object : Callback<MovieResponse> {
                    override fun onResponse(
                        call: Call<MovieResponse>,
                        response: Response<MovieResponse>
                    ) {
                        if (response.isSuccessful) {
                            movies.value = response.body()!!.movies
                        }
                    }

                    override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                        Log.d("MainActivity", "onFailure: ${t.message}")
                    }
                })
                    Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    )
                    {
                        MovieList(
                            movies = movies.value

                        )
                    }
                }
            }
        }
    }


