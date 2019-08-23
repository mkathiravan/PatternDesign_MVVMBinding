package net.kathir.myapplication.mvvmLiveData.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import net.kathir.myapplication.mvvmLiveData.service.model.Article;
import net.kathir.myapplication.R;
import net.kathir.myapplication.databinding.NewsListItemBinding;
import net.kathir.myapplication.mvvmLiveData.view.callback.OnClickCallback;

import java.time.temporal.TemporalAccessor;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> {

    private static final String TAG = NewsAdapter.class.getSimpleName();


    List<? extends Article> articleList;

    public void setProjectList(final List<? extends Article> articleList)
    {
        Log.d(TAG,"PROJECT_SIZE "+articleList.size());
        if(this.articleList == null)
        {
            this.articleList = articleList;
            notifyItemRangeInserted(0,articleList.size());
        }
        else
        {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return NewsAdapter.this.articleList.size();
                }

                @Override
                public int getNewListSize() {
                    return articleList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return NewsAdapter.this.articleList.get(oldItemPosition).getUrl() ==
                            NewsAdapter.this.articleList.get(newItemPosition).getUrl();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {

                    Article newarticle = articleList.get(newItemPosition);
                    Article oldarticle = articleList.get(oldItemPosition);

                    return newarticle.getUrl().equals(oldarticle.getUrl()) && oldarticle.getAuthor().equals(newarticle.getAuthor());
                }
            });

            this.articleList = articleList;
            result.dispatchUpdatesTo(this);
        }
    }


    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsListItemBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.news_list_item,
                        parent, false);

        binding.setCallback(new OnClickCallback());

        return new ArticleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.binding.setArticle(articleList.get(position));
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        Log.d(TAG,"ARTICLECOUNT "+articleList.size());
        return articleList == null ? 0 : articleList.size();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder {

        final NewsListItemBinding binding;

        public ArticleViewHolder(NewsListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
