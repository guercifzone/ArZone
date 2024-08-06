package com.guercif.arzone.ui.Ather;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.guercif.arzone.R;
import com.guercif.arzone.Web.WebActivity;
import com.guercif.arzone.ui.Android.AndroidViewModel;
import com.guercif.arzone.ui.Android.Android_Fragment;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AtherFragment extends Fragment {

    private AtherViewModel atherViewModel;
    ListView lvRss;
    ArrayList<String> titles;
    ArrayList<String>link;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        atherViewModel = new ViewModelProvider(this).get(AtherViewModel.class);
        View root = inflater.inflate(R.layout.fragment_ather,container,false);
        lvRss = root.findViewById(R.id.listview);
        titles = new ArrayList<String>();
        link = new ArrayList<String>();
        lvRss.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri = Uri.parse(link.get(position));
                Intent intent = new Intent(getContext(), WebActivity.class);
                String page_url = uri.toString().trim();
                intent.putExtra("url",page_url);
                startActivity(intent);
            }
        });
        new AtherFragment.ProcessInBackground().execute();
        return root;
    }
    private InputStream getInputStream(URL url) {
        try {
            return  url.openConnection().getInputStream();
        }catch (IOException e) {
            return null;
        }
    }
    public class ProcessInBackground extends AsyncTask<Integer,Void,Exception> {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        Exception exception = null;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage("wait  to  show ....");
            progressDialog.show();
        }
        @Override
        protected Exception doInBackground(Integer... integers) {
            try {
                URL url = new URL("https://guercifzone-ar.blogspot.com/feeds/posts/default/-/ather?alt=rss");
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xmlPullParser = factory.newPullParser();
                xmlPullParser.setInput(getInputStream(url), "UTF_8");
                boolean insideitem = false;
                int eventype = xmlPullParser.getEventType();
                while (eventype != XmlPullParser.END_DOCUMENT){
                    if (eventype == XmlPullParser.START_TAG){
                        if (xmlPullParser.getName().equalsIgnoreCase("item")){
                            insideitem = true;
                        } else if (xmlPullParser.getName().equalsIgnoreCase("title")) {
                            if (insideitem){
                                titles.add(xmlPullParser.nextText());
                            }
                        } else if (xmlPullParser.getName().equalsIgnoreCase("link")) {
                            if (insideitem){
                                link.add(xmlPullParser.nextText());
                            }
                        }
                    } else if (eventype == XmlPullParser.END_TAG && xmlPullParser.getName().equalsIgnoreCase("item")) {
                        insideitem = false;
                    }
                    eventype = xmlPullParser.next();
                }
            }catch (MalformedURLException e){
                exception = e;
            }catch (XmlPullParserException e){
                exception = e;
            }catch (IOException e){
                exception = e;
            }
            return exception;
        }
        @Override
        protected void onPostExecute(Exception e) {
            super.onPostExecute(e);
          //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,titles);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.color_listview,R.id.textView2,titles);
            lvRss.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }



}