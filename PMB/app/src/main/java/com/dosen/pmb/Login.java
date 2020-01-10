package com.dosen.pmb;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText usernama,userpass;
    Button login;
    TextView akun;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        usernama=findViewById(R.id.etuser);
        userpass=findViewById(R.id.etpass);
        login=findViewById(R.id.btnlogin);
        akun=findViewById(R.id.tvakun);

        akun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goreg=new Intent(Login.this,Register.class);
                startActivity(goreg);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usnn=usernama.getText().toString();
                String uspp=userpass.getText().toString();

                ApiRequestData api=Server.getClient().create(ApiRequestData.class);
                Call<ResponDaftar> getlogin=api.loginn(usnn,uspp);

                getlogin.enqueue(new Callback<ResponDaftar>() {
                    @Override
                    public void onResponse(Call<ResponDaftar> call, Response<ResponDaftar> response) {
                        if (response.body().getKode().equals("1")){
                            Toast.makeText(Login.this,"Login sukses...",Toast.LENGTH_SHORT).show();
                            Intent goregg=new Intent(Login.this,Register.class);
                            startActivity(goregg);

                        }else if (response.body().getKode().equals("2")){
                            Toast.makeText(Login.this,"Login gagal",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponDaftar> call, Throwable t) {
                        Toast.makeText(Login.this,"cek sambungan..!!",Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


    }

}
