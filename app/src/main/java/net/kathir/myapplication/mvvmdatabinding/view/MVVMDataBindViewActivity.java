package net.kathir.myapplication.mvvmdatabinding.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.kathir.myapplication.mvvmdatabinding.databinding.AppDataBindingComponent;
import net.kathir.myapplication.mvvmdatabinding.viewmodel.DataViewModel;
import net.kathir.myapplication.R;
import net.kathir.myapplication.databinding.ActivityBindMainBinding;

import static android.graphics.drawable.ClipDrawable.VERTICAL;

public class MVVMDataBindViewActivity extends AppCompatActivity {

    private DataViewModel dataViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
        View view = bind();
        initRecyclerView(view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataViewModel.setUp();
    }

    @Override
    protected void onPause() {
        super.onPause();
        dataViewModel.tearDown();
    }


    private View bind() {

        ActivityBindMainBinding binding = DataBindingUtil.setContentView(MVVMDataBindViewActivity.this, R.layout.activity_bind_main);
        dataViewModel = new DataViewModel();
        binding.setViewModel(dataViewModel);
        return binding.getRoot();

    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
    }

}
