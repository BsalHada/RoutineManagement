package com.example.finalassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalassignment.R;
import com.example.finalassignment.modal.EventModal;
import com.squareup.picasso.Picasso;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder>{

    Context context;
    List<EventModal> EventModals;

    public EventAdapter(Context context, List<EventModal> EventModals) {
        this.context = context;
        this.EventModals = EventModals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_event,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //// getting data according to position
        final EventModal EventModal = EventModals.get(position);

        holder.txt_event_name.setText(EventModal.getEvent_name());
        holder.txt_event_desc.setText(EventModal.getEvent_desc());

        // get Product Image
        Picasso.get()
                .load(EventModal.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .resize(220, 220)
                .centerCrop()
                .into(holder.img_event);
    }

    @Override
    public int getItemCount() {
        return EventModals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_event_name,txt_event_desc;
        ImageView img_event;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_event_name = itemView.findViewById(R.id.evetname);
            txt_event_desc = itemView.findViewById(R.id.eventDesc);
            img_event = itemView.findViewById(R.id.eventImage);
        }
    }
}
