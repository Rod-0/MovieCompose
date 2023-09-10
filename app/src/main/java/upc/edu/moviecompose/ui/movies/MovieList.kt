package upc.edu.moviecompose.ui.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import upc.edu.moviecompose.data.model.Movie

@Composable
fun MovieList(movies: List<Movie> = emptyList()) {
    LazyColumn {
        items(movies) {
            MovieItem(it)
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Row {
        GlideImage(
            imageModel = { "https://image.tmdb.org/t/p/original${movie.urlImage}" },
            imageOptions = ImageOptions(contentScale = ContentScale.FillWidth),
            modifier = Modifier.weight(1f)
        )
        Text(text = movie.title, modifier = Modifier.weight(5f))
    }

}

@Preview(showBackground = true)
@Composable
fun MovieListPreview() {
    MovieList()
}