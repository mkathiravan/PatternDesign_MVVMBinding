package net.kathir.myapplication.mvvmLiveData.view.callback;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import net.kathir.myapplication.mvvmLiveData.service.model.Article;
import net.kathir.myapplication.mvvmLiveData.view.ui.NewsDetailActivity;

public class OnClickCallback {

    public void onClick(View view, Article article) {
        Context context = view.getContext();
        Intent i = new Intent(context, NewsDetailActivity.class);
        i.putExtra("url", article.getUrl());
        context.startActivity(i);
    }
}
