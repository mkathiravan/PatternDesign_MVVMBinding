package net.kathir.myapplication.mvvmLiveData.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import net.kathir.myapplication.mvvmLiveData.service.model.News;
import net.kathir.myapplication.mvvmLiveData.service.repository.NewsRepository;

public class NewsViewModel extends AndroidViewModel {

    private final LiveData<News> newsLiveData;

    public ObservableField<News> news = new ObservableField<>();

    public NewsViewModel(@NonNull Application application) {
        super(application);
        // a differnt source can be passed, here i am passing techcrunch
        newsLiveData = NewsRepository.getInstance().getNews("techcrunch");
    }

    public LiveData<News> getObservableProject() {
        return newsLiveData;
    }

    public void setNews(News news) {
        this.news.set(news);
    }

    /**
     * A creator is used to inject the project ID into the ViewModel
     */
    public static class Factory extends ViewModelProvider.NewInstanceFactory {

        @NonNull
        private final Application application;

        public Factory(@NonNull Application application) {
            this.application = application;
        }

        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            //noinspection unchecked
            return (T) new NewsViewModel(application);
        }
    }

}
