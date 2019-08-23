package net.kathir.myapplication.mvvmdatabinding.databinding;


public class AppDataBindingComponent implements androidx.databinding.DataBindingComponent {
    @Override
    public RecyclerViewDataBinding getRecyclerViewDataBinding() {
        return new RecyclerViewDataBinding();
    }
}

