package com.example.berlian.si_rt;

import com.example.berlian.si_rt.kegiatan.resKegiatan;
import com.example.berlian.si_rt.login.loginAdmin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by berlian on 6/16/2017.
 */

public interface request {
    @GET("admin/akun_admin")
    Call<List<response>> akunAdmin();

    @GET("admin/tampil_info")
    Call<List<resKegiatan>> kegiatan();

    @POST("Login_admin/proses")
    Call<loginAdmin> loginAdmin(@Body loginAdmin loginAdmin);
}
