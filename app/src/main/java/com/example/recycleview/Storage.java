package com.example.recycleview;

import androidx.lifecycle.MutableLiveData;

import com.example.recycleview.model.Story;

import java.util.List;

public class Storage {
    private List<Story> m002ListStory;
    private MutableLiveData<Story> m002Story=new MutableLiveData<>();

    public List<Story> getM002ListStory() {
        return m002ListStory;
    }

    public void setM002ListStory(List<Story> listStory) {
        m002ListStory = listStory;
    }

    public MutableLiveData<Story> getM002Story() {
        return m002Story;
    }

    public void setM002Story(Story story) {

        m002Story.setValue(story);
    }
}