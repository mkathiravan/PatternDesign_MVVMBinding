package net.kathir.myapplication.MVVM.data.network.services;

import net.kathir.myapplication.MVVM.data.network.model.MovieResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MovieService {

    private static final String URL = "http://demo6483760.mockable.io/";

    private MovieApi mMovieApi;


    private static MovieService instance;


    public static MovieService getInstance() {
        if (instance == null) {
            instance = new MovieService();
        }
        return instance;
    }

    private MovieService() {
        Retrofit mRetrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(URL).build();
        mMovieApi = mRetrofit.create(MovieApi.class);
    }

    public MovieApi getMovieApi() {
        return mMovieApi;
    }

    public interface MovieApi
    {

        @GET("movies/")
        Call<MovieResponse> getAllMovie();
    }

}
