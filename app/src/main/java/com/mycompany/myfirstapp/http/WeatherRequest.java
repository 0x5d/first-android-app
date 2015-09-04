package com.mycompany.myfirstapp.http;

import com.mycompany.myfirstapp.async.AsyncTaskObserver;

/**
 * Created by castillobg on 9/4/15.
 */
public class WeatherRequest {
    private String url;
    private String response;
    private AsyncTaskObserver observer;

    public AsyncTaskObserver getObserver() {
        return observer;
    }

    public void setObserver(AsyncTaskObserver observer) {
        this.observer = observer;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
