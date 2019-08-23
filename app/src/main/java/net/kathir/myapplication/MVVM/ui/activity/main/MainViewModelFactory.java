package net.kathir.myapplication.MVVM.ui.activity.main;



import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import net.kathir.myapplication.MVVM.data.network.services.MovieService;

public class MainViewModelFactory implements ViewModelProvider.Factory {


    private final MovieService movieService;


    public MainViewModelFactory(MovieService movieService) {
        this.movieService = movieService;
    }



    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(movieService);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
