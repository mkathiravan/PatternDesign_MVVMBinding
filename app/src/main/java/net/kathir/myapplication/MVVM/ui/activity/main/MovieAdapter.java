package net.kathir.myapplication.MVVM.ui.activity.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import net.kathir.myapplication.MVVM.data.network.Movie;
import net.kathir.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public interface OnMovieAdapter{
        void onMovieClicked(Movie movie);
    }

    private List<Movie> mItems;
    private OnMovieAdapter mListener;

    public MovieAdapter(OnMovieAdapter listener) {
        mListener = listener;
        mItems = new ArrayList<>();
    }

    public void setItems(List<Movie> items) {
        mItems = items;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie = getItem(position);

        holder.setOnClickListener(movie);
        holder.setTitle(movie.getTitle());
        holder.setImage(movie.getImage());
        holder.setDescription(movie.getDescription());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    private Movie getItem(int position) {
        return mItems.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.image)
        AppCompatImageView image;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.desc) TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setTitle(String title) {
            this.title.setText(title);
        }

        public void setImage(String imageUrl) {
            Glide.with(itemView.getContext()).load(imageUrl).into(image);
        }

        private void setDescription(String description) {
            desc.setText(description);
        }

        private void setOnClickListener(Movie movie) {
            itemView.setTag(movie);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onMovieClicked((Movie) view.getTag());
        }
    }

}
