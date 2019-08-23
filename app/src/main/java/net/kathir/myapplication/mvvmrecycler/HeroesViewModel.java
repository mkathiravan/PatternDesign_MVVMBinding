package net.kathir.myapplication.mvvmrecycler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesViewModel extends ViewModel {

    //This is the data that we will fetch asynchronously
    private MutableLiveData<List<Hero>> herolist;

    //will call this method to load the data
    public LiveData<List<Hero>> getHeros()
    {
        if(herolist == null)
        {
            herolist = new MutableLiveData<List<Hero>>();

            load_heros();
        }

        return herolist;
    }

    private void load_heros() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService api = retrofit.create(ApiService.class);
        Call<List<Hero>> call = api.getHeroes();


        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                //finally we are setting the list to our MutableLiveData
                herolist.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });


    }


}
