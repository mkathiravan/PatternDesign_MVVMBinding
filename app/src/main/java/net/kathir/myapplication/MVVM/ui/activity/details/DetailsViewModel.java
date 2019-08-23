package net.kathir.myapplication.MVVM.ui.activity.details;

import android.content.Intent;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import net.kathir.myapplication.MVVM.data.network.Movie;

public class DetailsViewModel extends ViewModel {

    MutableLiveData<Movie> movie;

    public DetailsViewModel()
    {
        this.movie = new MutableLiveData<>();
    }


    public void loadMovieData(Intent intent) {
        assert intent.getExtras() != null;
        Movie movieExtra = intent.getExtras().getParcelable("movie");
        movie.postValue(movieExtra);
    }


    public MutableLiveData<Movie> getMovie() {
        return movie;
    }


}
