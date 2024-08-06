package com.guercif.arzone.ui.Blogger;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BloggerViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    public BloggerViewModel(){
        mText = new MediatorLiveData<>();
        mText.setValue("this is Blogger fragmant");
    }
    public LiveData<String> getText() {
        return mText;
    }
}