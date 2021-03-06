package com.dosen.pmb;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiRequestData {
    @FormUrlEncoded
    @POST("register.php")
    Call<ResponDaftar>simpandaftar(@Field("no_pendaftaran") String no_daftar,
                                   @Field("nama_calon_siswa")String namasiswa,
                                   @Field("usn")String usernama,@Field("usp")String userpass);
    @FormUrlEncoded
    @POST("update_daftar.php")
    Call<ResponDaftar>updatedaftar(@Field("no_pendaftaran") String no_daftar,
                                   @Field("nama_calon_siswa")String namasiswa,
                                   @Field("usn")String usernama,@Field("usp")String userpass);


@GET ("daftar_read.php")
    Call<ResponDaftar> getpendaftaran();


}
