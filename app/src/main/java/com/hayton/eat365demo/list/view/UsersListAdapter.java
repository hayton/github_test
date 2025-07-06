package com.hayton.eat365demo.list.view;

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
import com.hayton.eat365demo.databinding.ViewholderSimpleuserBinding;
import com.hayton.eat365demo.model.SimpleUser;

class UsersListAdapter extends ListAdapter<SimpleUser, RecyclerView.ViewHolder> {
    protected UsersListAdapter(
            @NonNull DiffUtil.ItemCallback<SimpleUser> diffCallback
    ) {
        super(diffCallback);
    }

    public interface OnItemClickListener {
        void onItemClick(SimpleUser user);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewholderSimpleuserBinding binding = ViewholderSimpleuserBinding.inflate(inflater, parent, false);
        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserViewHolder userViewHolder = (UserViewHolder) holder;
        userViewHolder.bind(getItem(position));
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderSimpleuserBinding binding;

        public UserViewHolder(@NonNull ViewholderSimpleuserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(SimpleUser user) {

            binding.tvLogin.setText(user.getLogin());
            binding.tvSiteAdmin.setText(user.getSiteAdmin().toString());

            Glide.with(binding.ivAvatar.getContext())
                    .load(user.getAvatarUrl().toString())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .circleCrop()
                    .into(binding.ivAvatar);

        }
    }
}
