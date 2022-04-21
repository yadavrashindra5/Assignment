package com.example.physicswalla;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physicswalla.model.ModelClass;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<ModelClass>arrayList;
    Context context;

    public MyAdapter(ArrayList<ModelClass> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.subject.setText(ModelClass.onlySubject(arrayList.get(position).getSubjects()));
        holder.qualification.setText(ModelClass.onlyQualification(arrayList.get(position).getQualification()));
        Picasso.get().load(arrayList.get(position).getProfileImage()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,subject,qualification;
        Button viewmore;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            subject=itemView.findViewById(R.id.subject);
            qualification=itemView.findViewById(R.id.qualification);
            viewmore=itemView.findViewById(R.id.viewmore);
            imageView=itemView.findViewById(R.id.imageView);

            viewmore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(view.getContext(),TutorActivity.class);
                    intent.putExtra("tutorname",arrayList.get(getAdapterPosition()).getName());
                    intent.putExtra("tutorsubject",ModelClass.onlySubject(arrayList.get(getAdapterPosition()).getSubjects()));
                    intent.putExtra("tutorqualification",ModelClass.onlyQualification(arrayList.get(getAdapterPosition()).getQualification()));
                    intent.putExtra("tutorimage",arrayList.get(getAdapterPosition()).getProfileImage());
                    view.getContext().startActivity(intent);

                }
            });
        }
    }
}
