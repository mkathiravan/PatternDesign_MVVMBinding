package net.kathir.myapplication.mvvmLiveData.view.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import net.kathir.myapplication.mvvmLiveData.lifecycle.SomeObserver;
import net.kathir.myapplication.R;

public class MvvmLiveDataMain extends AppCompatActivity {

    private static final String TAG = MvvmLiveDataMain.class.getSimpleName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvvmlive_main);

        // Add project list fragment if this is first creation
        if (savedInstanceState == null) {
            ArticleListFragment fragment = new ArticleListFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, fragment, ArticleListFragment.TAG).commit();
        }

        // for shake of
        getLifecycle().addObserver(new SomeObserver());
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }


    }

