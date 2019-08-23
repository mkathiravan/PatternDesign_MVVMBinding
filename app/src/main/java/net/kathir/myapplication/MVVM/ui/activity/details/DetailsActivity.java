package net.kathir.myapplication.MVVM.ui.activity.details;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;

import net.kathir.myapplication.MVVM.data.network.Movie;
import net.kathir.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.image)
    AppCompatImageView image;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.desc) TextView desc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);


        DetailsViewModel detailsViewModel = createViewModel();
        detailsViewModel.getMovie().observe(this,new MovieObserver());
        detailsViewModel.loadMovieData(getIntent());


    }

    private DetailsViewModel createViewModel()
    {
        return ViewModelProviders.of(this).get(DetailsViewModel.class);
    }

    private class MovieObserver implements Observer<Movie>
    {

        @Override
        public void onChanged(Movie movie) {
            if (movie == null) return;

            title.setText(movie.getTitle());
            desc.setText(movie.getDescription());
            Glide.with(getApplicationContext()).load(movie.getImage()).into(image);
        }
    }
}
