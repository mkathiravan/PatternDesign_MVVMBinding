package net.kathir.myapplication.mvvmLiveData.view.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import net.kathir.myapplication.mvvmLiveData.service.model.News;
import net.kathir.myapplication.mvvmLiveData.view.adapter.NewsAdapter;
import net.kathir.myapplication.mvvmLiveData.viewModel.NewsViewModel;
import net.kathir.myapplication.R;
import net.kathir.myapplication.databinding.FragmentNewsListItemBinding;

public class ArticleListFragment extends Fragment {

    public static final String TAG = "ArticleListFragment";
    private NewsAdapter newsAdapter;
    private FragmentNewsListItemBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.d(TAG,"FRAGMENT_ONCREATE_CALLED ");
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_list_item, container, false);

        newsAdapter = new NewsAdapter();
        binding.projectList.setAdapter(newsAdapter);
        binding.setIsLoading(true);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        NewsViewModel.Factory factory = new NewsViewModel.Factory(getActivity().getApplication());

        final NewsViewModel viewModel = ViewModelProviders.of(this, factory)
                .get(NewsViewModel.class);

        binding.setIsLoading(true);

        observeViewModel(viewModel);
    }

    private void observeViewModel(NewsViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getObservableProject().observe(this, new Observer<News>() {
            @Override
            public void onChanged(@Nullable News news) {
                if (news != null) {
                    binding.setIsLoading(false);
                    newsAdapter.setProjectList(news.getArticles());
                }
            }
        });
    }
}
