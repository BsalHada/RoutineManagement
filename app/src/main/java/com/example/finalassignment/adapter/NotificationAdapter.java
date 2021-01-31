package com.example.finalassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.R;
import com.example.finalassignment.modal.NotificationModal;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder>{

    Context context;
    List<NotificationModal> EventModals;

    public NotificationAdapter(Context context, List<NotificationModal> EventModals) {
        this.context = context;
        this.EventModals = EventModals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recyclerview_notification,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //// getting data according to position
        final NotificationModal NotificationModal = EventModals.get(position);

        holder.txt_title.setText(NotificationModal.getTitle());
        holder.txt_desc.setText(NotificationModal.getDesc());

    }

    @Override
    public int getItemCount() {
        return EventModals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_title,txt_desc;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_title = itemView.findViewById(R.id.txtTitle);
            txt_desc = itemView.findViewById(R.id.txtDesc);
        }
    }
}