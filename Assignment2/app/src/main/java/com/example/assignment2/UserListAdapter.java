package com.example.assignment2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListHolder> {

    List<User> listUsers;

    public UserListAdapter(List<User> listUsers) {
        this.listUsers = listUsers;
    }

    @NonNull
    @Override
    public UserListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);
        return new UserListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListHolder holder, int position) {
        holder.textName.setText(listUsers.get(position).getName());
        holder.textEmail.setText(listUsers.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class UserListHolder extends RecyclerView.ViewHolder {
        public TextView textName;
        public TextView textEmail;

        public UserListHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textViewName);
            textEmail = itemView.findViewById(R.id.textViewEmail);

        }
    }
}
