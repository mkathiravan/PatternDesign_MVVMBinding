package net.kathir.myapplication.MVVM.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import net.kathir.myapplication.MVVM.data.network.Movie;

import java.util.List;

public class MovieResponse {

    @Expose
    @SerializedName("movies")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

}
