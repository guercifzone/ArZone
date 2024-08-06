package com.guercif.arzone.ui.Computer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ComputerViewModel extends ViewModel {
    private MutableLiveData<String> mtext;
    public  ComputerViewModel(){
        mtext = new MediatorLiveData<>();
        mtext.setValue("this is Computer fragment");
    }
    public LiveData<String> getText() {return mtext;}
}