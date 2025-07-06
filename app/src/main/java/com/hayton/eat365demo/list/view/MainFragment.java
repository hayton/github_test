package com.hayton.eat365demo.list.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hayton.eat365demo.R;
import com.hayton.eat365demo.databinding.FragmentMainBinding;
import com.hayton.eat365demo.list.viewmodel.MainFragmentViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainFragment extends Fragment {

    public MainFragment() {
    }

    private final String TAG = MainFragment.class.getSimpleName();
    private MainFragmentViewModel viewModel;
    private Boolean isAdded = false;
    private FragmentMainBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListAdapter adapter = new UsersListAdapter(
                new SimpleUserDiffCallback()
        );
        binding.rvUsers.setAdapter(adapter);
        binding.rvUsers.setLayoutManager(new LinearLayoutManager(view.getContext()));

        binding.rvUsers.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int totalItemCount = adapter.getItemCount();
                int lastVisibleItem = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                if (lastVisibleItem == totalItemCount - 1 && !viewModel.isLoading) {
                    viewModel.getUsers();
                }

            }
        });

        viewModel.liveData.observe(getViewLifecycleOwner(), users -> {
            if (users == null) return;
            adapter.submitList(users.stream().toList());
        });

        viewModel.isLoadingLiveData.observe(getViewLifecycleOwner(), isLoading -> {
            binding.progressHorizontal.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        });


        if (!isAdded) {
            viewModel.getUsers();
            isAdded = true;
        }
    }
}