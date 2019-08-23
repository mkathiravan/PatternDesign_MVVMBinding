package net.kathir.myapplication.MVVM.ui.activity.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.kathir.myapplication.MVVM.data.network.DataManager;
import net.kathir.myapplication.MVVM.data.network.Movie;
import net.kathir.myapplication.MVVM.ui.activity.details.DetailsActivity;
import net.kathir.myapplication.MVVM.ui.activity.main.MainViewModel;
import net.kathir.myapplication.MVVM.ui.activity.main.MainViewModelFactory;
import net.kathir.myapplication.MVVM.ui.activity.main.MovieAdapter;
import net.kathir.myapplication.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MVVMViewActivity extends AppCompatActivity implements MovieAdapter.OnMovieAdapter{

    MovieAdapter movieAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.empty_view)
    TextView emptyView;

    MainViewModel viewModel;

    private RecyclerView.LayoutManager mLayoutManager;

    private MainViewModel createViewModel() {
        MainViewModelFactory factory = new MainViewModelFactory(DataManager.getInstance().getMovieService());
        return ViewModelProviders.of(this, factory).get(MainViewModel.class);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvmmain);
        ButterKnife.bind(this);


        mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        movieAdapter = new MovieAdapter(this);
        recyclerView.setAdapter(movieAdapter);

        viewModel = createViewModel();
        viewModel.getLoadingStatus().observe(this, new LoadingObserver());
        viewModel.getMovies().observe(this, new MovieObserver());


    }

    @OnClick(R.id.network)
    void onNetworkButtonClick() {
        viewModel.loadMoviesNetwork();
    }

    @OnClick(R.id.local)
    void onLocalButtonClick() {
        viewModel.loadMoviesLocal();
    }


    @Override
    public void onMovieClicked(Movie movie) {

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("movie", movie);
        startActivity(intent);

    }


    private class LoadingObserver implements Observer<Boolean>
    {

        @Override
        public void onChanged(Boolean aBoolean) {

            if (aBoolean == null) return;

            if (aBoolean) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.GONE);
            }
        }
    }


    private class MovieObserver implements Observer<List<Movie>>
    {

        @Override
        public void onChanged(List<Movie> movies) {
            if(movies == null) return;
            movieAdapter.setItems(movies);
            if (movies.isEmpty()) {
                emptyView.setVisibility(View.VISIBLE);
            } else {
                emptyView.setVisibility(View.GONE);
            }


        }
    }
}
