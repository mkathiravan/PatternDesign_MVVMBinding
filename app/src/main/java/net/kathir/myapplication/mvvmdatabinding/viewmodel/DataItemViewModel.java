package net.kathir.myapplication.mvvmdatabinding.viewmodel;

import android.text.TextUtils;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import net.kathir.myapplication.mvvmdatabinding.model.DataModel;


public class DataItemViewModel extends BaseObservable {

    private DataModel dataModel;

    public DataItemViewModel(DataModel dataModel)
    {
        this.dataModel = dataModel;
    }

    public void setUp() {
        // perform set up tasks, such as adding listeners
    }

    public void tearDown() {
        // perform tear down tasks, such as removing listeners
    }

    @Bindable
    public String getTitle()
    {
        return !TextUtils.isEmpty(dataModel.getTitle()) ? dataModel.getTitle() : "";
    }

}
