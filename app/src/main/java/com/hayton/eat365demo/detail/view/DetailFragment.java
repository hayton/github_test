package com.hayton.eat365demo.detail.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hayton.eat365demo.R;
import com.hayton.eat365demo.databinding.FragmentDetailBinding;
import com.hayton.eat365demo.detail.viewmodel.DetailFragmentViewModel;
import com.hayton.eat365demo.list.view.SimpleUserDiffCallback;
import com.hayton.eat365demo.model.PublicUser;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailFragment extends Fragment {

    public static final String ARG_USER = "arg_user";

    private final String TAG = DetailFragment.class.getSimpleName();
    private PublicUser user;
    private DetailFragmentViewModel viewModel;
    private FragmentDetailBinding binding;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = getArguments().getSerializable(ARG_USER, PublicUser.class);
        }
        viewModel = new ViewModelProvider(this).get(DetailFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tvLogin.setText(user.getLogin());
        Glide.with(this)
                .load(user.getAvatarUrl())
                .circleCrop()
                .into(binding.ivAvatar);

        if (user.getBio() == null || user.getBio().isBlank()) {
            binding.tvBio.setVisibility(View.GONE);
        } else {
            binding.tvBio.setText(user.getBio());
        }
        binding.tvViewType.setText(user.getUserViewType());
        binding.tvCompany.setText(user.getCompany());
        binding.tvEmail.setText(user.getEmail());

        FollowsListAdapter followersListAdapter = new FollowsListAdapter(
                new SimpleUserDiffCallback()
        );
        binding.rvFollowers.setAdapter(followersListAdapter);
        binding.rvFollowers.setLayoutManager(
                new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );

        FollowsListAdapter followingListAdapter = new FollowsListAdapter(
                new SimpleUserDiffCallback()
        );
        binding.rvFollowing.setAdapter(followingListAdapter);
        binding.rvFollowing.setLayoutManager(
                new LinearLayoutManager(
                        getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );

        viewModel.followersLiveData.observe(getViewLifecycleOwner(), followers -> {
            if (followers == null) return;
            followersListAdapter.submitList(followers);
        });

        viewModel.followingsLiveData.observe(getViewLifecycleOwner(), followings -> {
           if (followings == null) return;
           followingListAdapter.submitList(followings);
        });

        viewModel.getFollowers(user.getFollowersUrl());
        viewModel.getFollowings(user.getFollowingUrl().replaceAll("\\{.*$", ""));


    }
}