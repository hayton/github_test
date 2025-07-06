package com.hayton.eat365demo.detail.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hayton.eat365demo.R;
import com.hayton.eat365demo.databinding.ViewholderFollowBinding;
import com.hayton.eat365demo.model.SimpleUser;

public class FollowsListAdapter extends ListAdapter<SimpleUser, RecyclerView.ViewHolder> {
    protected FollowsListAdapter(@NonNull DiffUtil.ItemCallback<SimpleUser> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.viewholder_follow, parent, false);
        ViewholderFollowBinding binding = ViewholderFollowBinding.inflate(inflater, parent, false);
        return new FollowViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((FollowViewHolder) holder).bind(getItem(position));
    }

    static class FollowViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderFollowBinding binding;

        public FollowViewHolder(@NonNull ViewholderFollowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(SimpleUser user) {
            binding.tvLogin.setText(user.getLogin());
            Glide.with(binding.ivAvatar.getContext())
                    .load(user.getAvatarUrl().toString())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .circleCrop()
                    .into(binding.ivAvatar);
        }
    }
}
