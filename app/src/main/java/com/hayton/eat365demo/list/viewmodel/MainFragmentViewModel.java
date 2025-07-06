package com.hayton.eat365demo.list.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hayton.eat365demo.model.PublicUser;
import com.hayton.eat365demo.model.SimpleUser;
import com.hayton.eat365demo.repository.GithubRepository;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class MainFragmentViewModel extends ViewModel {

    @Inject
    public MainFragmentViewModel(
            GithubRepository githubRepository
    ) {
        this.githubRepository = githubRepository;
    }

    private final GithubRepository githubRepository;
    private final int itemsPerPage = 20;
    private int since = 0;
    private final Pattern LINK_PATTERN = Pattern.compile("<([^>]+)>\\s*;\\s*rel=\"([^\"]+)\"");


    public boolean isLoading = false;
    public MutableLiveData<List<SimpleUser>> liveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoadingLiveData = new MutableLiveData<>();
    public MutableLiveData<PublicUser> publicUserLiveData = new MutableLiveData<>();

    public void getUsers() {
        isLoading = true;
        isLoadingLiveData.setValue(true);
        githubRepository.getUsers(since, itemsPerPage).enqueue(
                new Callback<List<SimpleUser>>() {

                    @Override
                    public void onResponse(Call<List<SimpleUser>> call, Response<List<SimpleUser>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            String nextUrl = parse(response.headers().get("link")).get("next");
                            since = getQueryParam(nextUrl, "since");
                            List<SimpleUser> list = liveData.getValue();
                            if (list == null){
                                liveData.setValue(response.body());
                            } else {
                                list.addAll(response.body());
                                liveData.setValue(list);
                            }
                        }
                        isLoading = false;
                        isLoadingLiveData.setValue(false);
                    }

                    @Override
                    public void onFailure(Call<List<SimpleUser>> call, Throwable t) {
                        liveData.setValue(null);
                        isLoading = false;
                        isLoadingLiveData.setValue(false);
                    }
                }
        );
    }

    public void getUser(String login) {
        githubRepository.getUser(login).enqueue(
                new Callback<PublicUser>() {

                    @Override
                    public void onResponse(Call<PublicUser> call, Response<PublicUser> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            publicUserLiveData.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<PublicUser> call, Throwable t) {

                    }
                }
        );
    }

    private Map<String, String> parse(String header) {
        Map<String, String> links = new HashMap<>();
        if (header == null || header.isEmpty()) {
            return links;
        }

        Matcher matcher = LINK_PATTERN.matcher(header);
        while (matcher.find()) {
            String url = matcher.group(1);
            String rel = matcher.group(2);
            links.put(rel, url);
        }
        return links;
    }

    private int getQueryParam(String url, String paramName) {
        if (url == null || paramName == null) return 0;
        try {
            URI uri = new URI(url);
            String query = uri.getQuery();      // e.g. "since=30&per_page=20"
            if (query == null || query.isEmpty()) return 0;
            String[] pairs = query.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf('=');
                if (idx > 0) {
                    String key = pair.substring(0, idx);
                    if (paramName.equals(key)) {
                        return Integer.parseInt(pair.substring(idx + 1));
                    }
                }
            }
        } catch (URISyntaxException e) {
            return 0;
        }
        return 0;
    }

}