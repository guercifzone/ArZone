package com.guercif.arzone.ui.Algorithmes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlgorithmesViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public AlgorithmesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Algorithmes fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}