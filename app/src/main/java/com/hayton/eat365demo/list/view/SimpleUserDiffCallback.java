package com.hayton.eat365demo.list.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.hayton.eat365demo.model.SimpleUser;

public class SimpleUserDiffCallback extends DiffUtil.ItemCallback<SimpleUser> {
    @Override
    public boolean areItemsTheSame(@NonNull SimpleUser oldItem, @NonNull SimpleUser newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull SimpleUser oldItem, @NonNull SimpleUser newItem) {
        return oldItem.equals(newItem);
    }
}
