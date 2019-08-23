package net.kathir.myapplication.mvvmdatabinding.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;


import net.kathir.myapplication.mvvmdatabinding.adapter.DataAdapter;
import net.kathir.myapplication.mvvmdatabinding.model.DataModel;

import java.util.ArrayList;
import java.util.List;

public class DataViewModel extends BaseObservable {

    private static final String TAG = DataViewModel.class.getSimpleName();
    private DataAdapter adapter;
    private List<DataModel> datalist;


    public DataViewModel() {
        datalist = new ArrayList<>();
        adapter = new DataAdapter();
    }

    public void setUp() {
        populateData();
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    public List<DataModel> getData() {
        return this.datalist;
    }

    @Bindable
    public DataAdapter getAdapter() {
        return this.adapter;
    }

    private void populateData() {

        for (int i = 0; i < 50; i++) {
            DataModel dataModel = new DataModel();
            dataModel.setTitle(String.valueOf(i));
            datalist.add(dataModel);
        }


    }



}
