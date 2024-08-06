package com.guercif.arzone.Web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestConnectionInternet {
    String testUrl = "";
    public static Object connected(String testUrl){
        try {
            URL  url = new URL(testUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(15000);
            connection.setDoInput(true);
            return connection;
        }catch (MalformedURLException malformedURLException){
            malformedURLException.printStackTrace();
            return ConnectionInternetERRor.WRONG_URL_FORMAT;
        }catch (IOException ioException){
            ioException.printStackTrace();
            return ConnectionInternetERRor.CONNECTION_ERROR ;
        }
    }
}
