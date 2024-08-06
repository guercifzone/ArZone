package com.guercif.arzone.ui.Android;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AndroidViewModel extends ViewModel {
   private MutableLiveData<String> mText;
   public AndroidViewModel(){
       mText = new MediatorLiveData<>();
       mText.setValue("This is Android fragmant");
   }
   public LiveData<String> getText(){return  mText;}
}