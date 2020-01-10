package com.dosen.pmb;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Server {

    //Emulator Android
    //private  static final String url_base="http://10.0.2.2/PMB/";

    //Emulator Nox
    private  static final String url_base="http://192.168.1.3/PMB/";

    private static Retrofit retrofit;

    public static Retrofit getClient(){

        if (retrofit ==null){
            retrofit=new Retrofit.Builder().baseUrl(url_base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
