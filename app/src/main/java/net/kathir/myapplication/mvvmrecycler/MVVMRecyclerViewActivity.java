package net.kathir.myapplication.mvvmrecycler;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.kathir.myapplication.MainActivity;
import net.kathir.myapplication.R;

import java.util.List;

public class MVVMRecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HeroesAdapter adapter;

    List<Hero> heroList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvvm_recycler_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HeroesViewModel model = ViewModelProviders.of(this).get(HeroesViewModel.class);

        model.getHeros().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new HeroesAdapter(MVVMRecyclerViewActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
