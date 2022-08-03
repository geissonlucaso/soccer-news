package com.geissonlucaso.soccernews.ui.favorites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.geissonlucaso.soccernews.MainActivity;
import com.geissonlucaso.soccernews.databinding.FragmentFavoritesBinding;
import com.geissonlucaso.soccernews.domain.News;
import com.geissonlucaso.soccernews.ui.adapter.NewsAdapter;

import java.util.List;

public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FavoritesViewModel favoritesViewModel = new ViewModelProvider(this).get(FavoritesViewModel.class);
        binding = FragmentFavoritesBinding.inflate(inflater, container, false);

        loadFavoriteNews();

        View root = binding.getRoot();
        return root;
    }

    private void loadFavoriteNews() {
        MainActivity activity = (MainActivity) getActivity();
        if (activity != null) {
            List<News> favoriteNews = activity.getDb().NewsDao().loadFavoriteNews();
            binding.rvNews.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.rvNews.setAdapter(new NewsAdapter(favoriteNews, updatedNews -> {
                activity.getDb().NewsDao().save(updatedNews);
                loadFavoriteNews();
            }));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}