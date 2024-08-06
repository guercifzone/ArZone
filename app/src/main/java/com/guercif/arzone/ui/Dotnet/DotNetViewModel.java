package com.guercif.arzone.ui.Dotnet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DotNetViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public DotNetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Csharp fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}