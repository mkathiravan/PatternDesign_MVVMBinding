package net.kathir.myapplication.mvvmdatabinding.databinding;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import net.kathir.myapplication.mvvmdatabinding.adapter.DataAdapter;
import net.kathir.myapplication.mvvmdatabinding.model.DataModel;

import java.util.List;

public class RecyclerViewDataBinding {

    @BindingAdapter({"app:adapter", "app:data"})
    public void bind(RecyclerView recyclerView, DataAdapter adapter, List<DataModel> data) {
        recyclerView.setAdapter(adapter);
        adapter.updateData(data);
    }
}

