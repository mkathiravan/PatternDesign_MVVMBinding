package net.kathir.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.kathir.myapplication.MVVM.ui.activity.main.MVVMViewActivity;
import net.kathir.myapplication.mvvmLiveData.view.ui.MvvmLiveDataMain;
import net.kathir.myapplication.mvvmdatabinding.view.MVVMDataBindViewActivity;
import net.kathir.myapplication.mvvmrecycler.MVVMRecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    Button mvvmView,mvvmDataBinding,mvvmliveView,mvvmRetrofitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mvvmView = (Button)findViewById(R.id.mvvm_model_view);
        mvvmDataBinding = (Button)findViewById(R.id.mvvm_databindingView);
        mvvmliveView = (Button)findViewById(R.id.mvvm_livedataView);
        mvvmRetrofitView = (Button)findViewById(R.id.mvvm_recylerview);

        mvvmView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MVVMViewActivity.class);
                startActivity(intent);
            }
        });

        mvvmDataBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MVVMDataBindViewActivity.class);
                startActivity(intent);

            }
        });

        mvvmliveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MvvmLiveDataMain.class);
                startActivity(intent);

            }
        });

        mvvmRetrofitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, MVVMRecyclerViewActivity.class);
                startActivity(intent);

            }
        });


    }
}
