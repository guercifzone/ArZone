package com.guercif.arzone.Web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;

public class WebViewController  extends WebViewClient {



    @Override
    public boolean shouldOverrideUrlLoading(@NonNull WebView view, WebResourceRequest request) {
if((String.valueOf(request.getUrl())).contains("https://guercifzone-ar.blogspot.com/")){
    view.loadUrl(String.valueOf(request.getUrl()));
    view.getSettings().setJavaScriptEnabled(true);

    view.setWebViewClient(new WebViewClient(){
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            //String javascript = "javascript:(function () {document.getElementsByClassName('mobile-header')[0].style.display='none';})()";
            view.loadUrl("javascript:(function () {document.getElementsByClassName('post-footer')[0].style.display='none';})()");
            view.loadUrl("javascript:(function() { document.getElementById('header-wrap').style.display='none';})()");
            view.loadUrl("javascript:(function() { document.getElementById('sidebar-wrapper').style.display='none';})()");
            view.loadUrl("javascript:(function() { document.getElementById('footer-wrapper').style.visibility='collapse';})()");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //String javascript = "javascript:(function () {document.getElementsByClassName('mobile-header')[0].style.display='none';})()";
            view.loadUrl("javascript:(function () {document.getElementsByClassName('post-footer')[0].style.display='none';})()");
            view.loadUrl("javascript:(function() { document.getElementById('header-wrap').style.display='none';})()");
            view.loadUrl("javascript:(function() { document.getElementById('sidebar-wrapper').style.display='none';})()");
            view.loadUrl("javascript:(function() { document.getElementById('footer-wrapper').style.visibility='collapse';})()");
        }

    });
}else{
    Intent  i = new Intent(Intent.ACTION_VIEW, request.getUrl());
    view.getContext().startActivity(i); }
return true;
    }

}
