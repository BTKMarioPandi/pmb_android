package com.dosen.pmb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
Button simpandaftar,viewdaftar,updatedd,deletee;
EditText nodff,namaa,usnn,uspp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        simpandaftar=(Button)findViewById(R.id.btnsimpan);
        viewdaftar=(Button)findViewById(R.id.btntampil);
        updatedd=findViewById(R.id.btnupdate);
        deletee=findViewById(R.id.btndelete);
        nodff=(EditText)findViewById(R.id.ednodf);
        namaa=(EditText)findViewById(R.id.ednama);
        usnn=(EditText)findViewById(R.id.edusn);
        uspp=(EditText)findViewById(R.id.edusp);


        String no=getIntent().getStringExtra("noo");

        if (no !=null){
            String na=getIntent().getStringExtra("naamaa");
            nodff.setText(no);
            namaa.setText(na);
            simpandaftar.setVisibility(View.GONE);

        }


        deletee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noodf=nodff.getText().toString();
                ApiRequestData aapi=Server.getClient().create(ApiRequestData.class);
                Call<ResponDaftar>deletedaftar=aapi.hapusdaftar(noodf);
                deletedaftar.enqueue(new Callback<ResponDaftar>() {
                    @Override
                    public void onResponse(Call<ResponDaftar> call, Response<ResponDaftar> response) {
                        if (response.body().getPesan().equals("1")){
                            Toast.makeText(Register.this,"Data Berhasil dihapus",Toast.LENGTH_SHORT).show();
                            nodff.setText("");
                            namaa.setText("");
                            usnn.setText("");
                            uspp.setText("");

                        }else if (response.body().getPesan().equals("2")){
                            Toast.makeText(Register.this,"Gagal hapus data..!!",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponDaftar> call, Throwable t) {
                        Toast.makeText(Register.this,"Sambungan Gagal...",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        updatedd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noodf=nodff.getText().toString();
                String naama=namaa.getText().toString();
                final String ussn=usnn.getText().toString();
                String ussp=uspp.getText().toString();

                ApiRequestData apii=Server.getClient().create(ApiRequestData.class);
                Call<ResponDaftar>updatedfatarr=apii.updatedaftar(noodf,naama,ussn,ussp);
                updatedfatarr.enqueue(new Callback<ResponDaftar>() {
                    @Override
                    public void onResponse(Call<ResponDaftar> call, Response<ResponDaftar> response) {
                        if (response.body().getPesan().equals("2")){
                            Toast.makeText(Register.this,"Data berhasil di-update",Toast.LENGTH_SHORT).show();

                        }else if (response.body().getPesan().equals("1")){
                            Toast.makeText(Register.this,"Data belum ada dan telah disimpan",Toast.LENGTH_SHORT).show();
                        }

                        nodff.setText("");
                        namaa.setText("");
                        usnn.setText("");
                        uspp.setText("");
                    }

                    @Override
                    public void onFailure(Call<ResponDaftar> call, Throwable t) {
                        Toast.makeText(Register.this,"Sambungan gagal...",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        viewdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotampil=new Intent(Register.this,TampilDaftar.class);
                startActivity(gotampil);
            }
        });

        simpandaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String noodf=nodff.getText().toString();
                String naama=namaa.getText().toString();
                final String ussn=usnn.getText().toString();
                String ussp=uspp.getText().toString();

                ApiRequestData api =Server.getClient().create(ApiRequestData.class);
                Call<ResponDaftar>savependaftaran=api.simpandaftar(noodf,naama,ussn,ussp);
                savependaftaran.enqueue(new Callback<ResponDaftar>() {
                    @Override
                    public void onResponse(Call<ResponDaftar> call, Response<ResponDaftar> response) {

                        response.body().getKode();
                        if (response.body().getKode().equals("1")){
                            Toast.makeText(Register.this,"Data Berhasil disimpan. ",Toast.LENGTH_SHORT).show();
                            nodff.setText("");
                            namaa.setText("");
                            usnn.setText("");
                            uspp.setText("");
                        }else if (response.body().getKode().equals("2")){
                            Toast.makeText(Register.this,"Data Sudah ada." ,Toast.LENGTH_SHORT).show();
                        }

                        nodff.setText("");
                        namaa.setText("");
                        usnn.setText("");
                        uspp.setText("");

                    }

                    @Override
                    public void onFailure(Call<ResponDaftar> call, Throwable t) {
                        Toast.makeText(Register.this,"Sambungan Gagal.",Toast.LENGTH_LONG).show();

                    }
                });


            }
        });


    }
}
