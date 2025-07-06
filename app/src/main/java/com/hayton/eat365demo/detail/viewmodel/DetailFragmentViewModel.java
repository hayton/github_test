package com.hayton.eat365demo.detail.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hayton.eat365demo.model.SimpleUser;
import com.hayton.eat365demo.repository.GithubRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class DetailFragmentViewModel extends ViewModel {

    @Inject
    public DetailFragmentViewModel(
            GithubRepository githubRepository
    ) {
        this.githubRepository = githubRepository;
    }

    private final GithubRepository githubRepository;

    public MutableLiveData<List<SimpleUser>> followersLiveData = new MutableLiveData<>();
    public MutableLiveData<List<SimpleUser>> followingsLiveData = new MutableLiveData<>();

    public void getFollowers(String url) {
        githubRepository.getUsersByUrl(url).enqueue(
                new Callback<List<SimpleUser>>(){

                    @Override
                    public void onResponse(Call<List<SimpleUser>> call, Response<List<SimpleUser>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            followersLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SimpleUser>> call, Throwable t) {

                    }
                }
        );
    }

    public void getFollowings(String url) {
        githubRepository.getUsersByUrl(url).enqueue(
                new Callback<List<SimpleUser>>(){

                    @Override
                    public void onResponse(Call<List<SimpleUser>> call, Response<List<SimpleUser>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            followingsLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<SimpleUser>> call, Throwable t) {

                    }
                }
        );
    }
}
