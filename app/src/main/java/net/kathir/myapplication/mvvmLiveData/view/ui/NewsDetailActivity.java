package net.kathir.myapplication.mvvmLiveData.view.ui;


import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import net.kathir.myapplication.R;
import net.kathir.myapplication.databinding.ActivityNewsDetailBinding;


public class NewsDetailActivity extends AppCompatActivity {

    private ActivityNewsDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news_detail);
        binding.setUrl(getIntent().getStringExtra("url"));
    }

}
