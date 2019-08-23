package net.kathir.myapplication.MVVM.ui.activity.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import net.kathir.myapplication.MVVM.data.network.Movie;
import net.kathir.myapplication.MVVM.data.network.model.MovieResponse;
import net.kathir.myapplication.MVVM.data.network.services.MovieService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    private MutableLiveData<List<Movie>> movieList;
    private MutableLiveData<Boolean> isLoading;
    private MovieService movieService;


    public MainViewModel(MovieService movieService) {
        this.movieService = movieService;
        movieList = new MutableLiveData<>();
        isLoading = new MutableLiveData<>();

    }

    public MutableLiveData<List<Movie>> getMovies() {
        return movieList;
    }
    public MutableLiveData<Boolean> getLoadingStatus() {
        return isLoading;
    }

    public void loadMoviesNetwork()
    {

        setIsLoading(true);
        Call<MovieResponse> movieCall = movieService.getMovieApi().getAllMovie();
        movieCall.enqueue(new MovieCallback());

    }

    public void loadMoviesLocal()
    {
        setIsLoading(true);

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("David Beckham","https://cdn.images.express.co.uk/img/dynamic/67/590x/secondary/David-Beckham-1374056.jpg?r=1534415582612","England"));
        movies.add(new Movie("Van Persie","https://secure.i.telegraph.co.uk/multimedia/archive/02388/rvp_2388066b.jpg","Netherland"));
        movies.add(new Movie("Gerrard","https://www.thesun.co.uk/wp-content/uploads/2019/03/NINTCHDBPICT000478034112-e1553362169895.jpg","England"));
        movies.add(new Movie("Zidane","https://i.pinimg.com/originals/6d/86/ac/6d86acaef77aa0ecdf3c6ead622b4ced.jpg","France"));
        movies.add(new Movie("Ronaldo","https://images-na.ssl-images-amazon.com/images/I/719r1tueiBL._SL1500_.jpg","Brazil"));

        setMovies(movies);
    }



    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void showEmptyList() {
        setMovies(Collections.<Movie>emptyList()); }

    private void setIsLoading(boolean loading) {
        isLoading.postValue(loading);
    }

    private void setMovies(List<Movie> movies)
    {
        setIsLoading(false);
        movieList.postValue(movies);

    }

    private class MovieCallback implements Callback<MovieResponse>
    {

        @Override
        public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
            MovieResponse movieResponse = response.body();

            if(movieResponse != null)
            {
                setMovies(movieResponse.getMovies());
            }
            else
            {
                setMovies(Collections.<Movie>emptyList());
            }

        }

        @Override
        public void onFailure(Call<MovieResponse> call, Throwable t) {

            setMovies(Collections.<Movie>emptyList());

        }
    }

}
