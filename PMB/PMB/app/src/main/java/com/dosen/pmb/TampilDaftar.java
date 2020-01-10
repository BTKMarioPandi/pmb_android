package com.dosen.pmb;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilDaftar extends AppCompatActivity {
    private RecyclerView mRc;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<DataPendaftar> mItems = new ArrayList<>();
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       setContentView(R.layout.tampil);

       pd=new ProgressDialog(this);
       mRc=(RecyclerView)findViewById(R.id.rvdaftar);
       mManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
       mRc.setLayoutManager(mManager);

        ApiRequestData api=Server.getClient().create(ApiRequestData.class);
        Call<ResponDaftar>pendaftar=api.getpendaftaran();
        pendaftar.enqueue(new Callback<ResponDaftar>() {
            @Override
            public void onResponse(Call<ResponDaftar> call, Response<ResponDaftar> response) {
                Toast.makeText(TampilDaftar.this,"Respon:Berhasil ditampilkan " ,Toast.LENGTH_LONG).show();
                mItems=response.body().getResult();
                mAdapter=new AdapterDaftar(TampilDaftar.this,mItems);
                mRc.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponDaftar> call, Throwable t) {

                Toast.makeText(TampilDaftar.this,"Gagal konek",Toast.LENGTH_SHORT).show();

            }
        });



    }
}
