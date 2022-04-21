package com.example.physicswalla;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.physicswalla.apicalling.RetrofitObject;
import com.example.physicswalla.model.ModelClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private ArrayList<ModelClass>arrayList;
    private MyAdapter adapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager manager;
    private View view;
    private ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_home, container, false);
        arrayList=new ArrayList<>();
        progressDialog=new ProgressDialog(view.getContext());
        progressDialog.setMessage("Data Loading");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
        loadData();

        recyclerView=view.findViewById(R.id.recyclerview);
        manager=new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(manager);

        adapter=new MyAdapter(arrayList,view.getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        loadData();
    }


    private void loadData() {

        Call<List<ModelClass>>call= RetrofitObject.getInstance().getMyApi().getData();
        call.enqueue(new Callback<List<ModelClass>>() {
            @Override
            public void onResponse(Call<List<ModelClass>> call, Response<List<ModelClass>> response) {
                List<ModelClass>modelClasses=response.body();
                arrayList.clear();
                arrayList.addAll(modelClasses);
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<ModelClass>> call, Throwable t) {

            }
        });

    }


}