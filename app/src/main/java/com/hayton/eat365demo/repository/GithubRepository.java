package com.hayton.eat365demo.repository;

import com.hayton.eat365demo.model.PublicUser;
import com.hayton.eat365demo.model.SimpleUser;

import java.util.List;

import retrofit2.Call;

public interface GithubRepository {
     Call<List<SimpleUser>> getUsers(int since, int perPage);
     Call<PublicUser> getUser(String username);
     Call<List<SimpleUser>> getUsersByUrl(String url);
}
