package com.hayton.eat365demo.di;

import com.hayton.eat365demo.repository.GitHubService;
import com.hayton.eat365demo.repository.GithubRepository;
import com.hayton.eat365demo.repository.GithubRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class HttpModule {

    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        OkHttpClient client = new OkHttpClient()
                .newBuilder()
                .addInterceptor(
                        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                )
                .addInterceptor(
                        chain -> {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Accept", "application/vnd.github+json")
                                    .addHeader("X-GitHub-Api-Version", "2022-11-28")
                                    .build();
                            return chain.proceed(newRequest);
                        }
                ).build();

        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    public GitHubService provideGitHubService(Retrofit retrofit) {
        return retrofit.create(GitHubService.class);
    }

    @Provides
    public GithubRepository provideGithubRepository(GitHubService gitHubService) {
        return new GithubRepositoryImpl(gitHubService);
    }

}
