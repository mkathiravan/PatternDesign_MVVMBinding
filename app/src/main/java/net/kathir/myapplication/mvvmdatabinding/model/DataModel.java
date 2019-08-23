package net.kathir.myapplication.mvvmdatabinding.model;

import androidx.annotation.Nullable;

public class DataModel {

    private String title;

    public DataModel() {
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }
}
