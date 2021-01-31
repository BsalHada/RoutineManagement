package com.example.finalassignment.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalassignment.R;
import com.example.finalassignment.modal.RoutineModal;

import java.util.List;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.MyViewHolder>{

    Context context;
    List<RoutineModal> RoutineModals;

    public DayAdapter(Context context, List<RoutineModal> RoutineModals) {
        this.context = context;
        this.RoutineModals = RoutineModals;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_routine,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        //// getting data according to position
        final RoutineModal RoutineModal = RoutineModals.get(position);

        holder.txt_course_name.setText(RoutineModal.getCourse_name());
        holder.txt_course_code.setText(RoutineModal.getCourse_code());
        holder.txt_time.setText(RoutineModal.getTime());
        holder.txt_batch.setText(RoutineModal.getBatch());
        holder.txt_room_no.setText(RoutineModal.getRoom_no());
    }

    @Override
    public int getItemCount() {
        return RoutineModals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_course_name,txt_course_code, txt_time, txt_batch, txt_room_no;

        public MyViewHolder(View itemView) {
            super(itemView);

            txt_course_name = itemView.findViewById(R.id.coursename);
            txt_course_code = itemView.findViewById(R.id.coursecode);
            txt_time = itemView.findViewById(R.id.time);
            txt_batch =itemView.findViewById(R.id.batch);
            txt_room_no=itemView.findViewById(R.id.room_no);
        }
    }
}