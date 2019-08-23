package net.kathir.myapplication.mvvmLiveData.service.repository;

import net.kathir.myapplication.mvvmLiveData.service.model.News;
import net.kathir.myapplication.mvvmLiveData.utility.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface NewsService {

    String URL = Constants.Companion.getAPI_URL();

    @GET("top-headlines")
    Call<News> getNews(@Query("sources") String source);
}
