package com.hayton.eat365demo.repository;

import com.hayton.eat365demo.model.PublicUser;
import com.hayton.eat365demo.model.SimpleUser;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;

public class GithubRepositoryImpl implements GithubRepository{

    @Inject
    public GithubRepositoryImpl(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    private final GitHubService gitHubService;


    @Override
    public Call<List<SimpleUser>> getUsers(int since, int perPage) {
        return gitHubService.getUsers(since, perPage);
    }

    @Override
    public Call<PublicUser> getUser(String username) {
        return gitHubService.getUser(username);
    }

    @Override
    public Call<List<SimpleUser>> getUsersByUrl(String url) {
        return gitHubService.getUsersByUrl(url);
    }
}
