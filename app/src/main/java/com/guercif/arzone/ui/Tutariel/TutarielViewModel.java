package com.guercif.arzone.ui.Tutariel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TutarielViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public TutarielViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Tutariel fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}