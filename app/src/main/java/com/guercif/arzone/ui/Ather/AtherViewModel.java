package com.guercif.arzone.ui.Ather;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AtherViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AtherViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Ather fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}