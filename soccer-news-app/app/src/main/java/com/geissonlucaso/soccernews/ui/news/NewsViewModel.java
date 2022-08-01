package com.geissonlucaso.soccernews.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.geissonlucaso.soccernews.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        news = new MutableLiveData<>();

        // TODO Remove mock news.
        List<News> listNews = new ArrayList<>();
        listNews.add(new News("Cruzeiro é Campeão Antecipado.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        listNews.add(new News("Framengo Empata em 0x0.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        listNews.add(new News("Corinthians é Derrotado por 2x0.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));
        listNews.add(new News("Copa do Mundo Feminina Será no Brasil.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "));

        news.setValue(listNews);
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}