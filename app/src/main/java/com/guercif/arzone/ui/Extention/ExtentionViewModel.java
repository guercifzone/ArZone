package com.guercif.arzone.ui.Extention;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ExtentionViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ExtentionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Extention fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}