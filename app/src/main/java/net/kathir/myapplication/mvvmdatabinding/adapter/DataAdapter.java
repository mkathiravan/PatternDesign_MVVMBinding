package net.kathir.myapplication.mvvmdatabinding.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import net.kathir.myapplication.mvvmdatabinding.model.DataModel;
import net.kathir.myapplication.mvvmdatabinding.viewmodel.DataItemViewModel;
import net.kathir.myapplication.R;
import net.kathir.myapplication.databinding.ItemDataBinding;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {

    private static final String TAG = "DataAdapter";
    private List<DataModel> data;

    public DataAdapter() {
        this.data = new ArrayList<>();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,
                new FrameLayout(parent.getContext()), false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        DataModel dataModel = data.get(position);
        holder.setViewModel(new DataItemViewModel(dataModel));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<DataModel> data) {
        if (data == null || data.isEmpty()) {
            this.data.clear();
        } else {
            this.data.addAll(data);
        }
        notifyDataSetChanged();
    }

    /* package */ static class DataViewHolder extends RecyclerView.ViewHolder {
        /* package */ ItemDataBinding binding;

        /* package */ DataViewHolder(View itemView) {
            super(itemView);
            bind();
        }

        /* package */ void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

        /* package */ void unbind() {
            if (binding != null) {
                binding.unbind(); // Don't forget to unbind
            }
        }

        /* package */ void setViewModel(DataItemViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }
    }
}
