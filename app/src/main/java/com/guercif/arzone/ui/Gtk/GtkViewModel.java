package com.guercif.arzone.ui.Gtk;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GtkViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public GtkViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is GTK fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}