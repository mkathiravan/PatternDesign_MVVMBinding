package net.kathir.myapplication.mvvmLiveData.view.adapter;

import android.text.format.DateUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import net.kathir.myapplication.mvvmLiveData.utility.DateUtil;

public class CustomBindingAdapter {

    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("dateText")
    public static void convertToDate(TextView view, String date) {
        view.setText(DateUtil.Companion.convertToDateString(date));
    }


    @BindingAdapter("loadurl")
    public static void loadurl(WebView mWebview, String url) {
        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            }
        });
        mWebview.loadUrl(url);
    }
}
