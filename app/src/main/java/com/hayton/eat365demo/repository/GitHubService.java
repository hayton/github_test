package com.hayton.eat365demo.repository;

import com.hayton.eat365demo.model.PublicUser;
import com.hayton.eat365demo.model.SimpleUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface GitHubService {
    @GET("users")
    Call<List<SimpleUser>> getUsers(
            @Query("since") int since,
            @Query("per_page") int perPage
    );

    @GET("users/{username}")
    Call<PublicUser> getUser(
            @Path("username") String username
    );

    @GET
    Call<List<SimpleUser>> getUsersByUrl(
            @Url String url
    );
}
