package com.guercif.arzone.Web;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {
    static String stream = null;
    public HttpHandler(){}
    public String GetHttpData(String urlString){
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) !=null){
                    stringBuilder.append(line);
                    stream = stringBuilder.toString();
                    httpURLConnection.disconnect();
                }
            }
        }catch (MalformedURLException e){
e.printStackTrace();
return ConnectionInternetERRor.CONNECTION_ERROR;
        }catch (IOException e){
e.printStackTrace();
return ConnectionInternetERRor.RESPONSE_EROR;
        }
        return stream;
    }
}
