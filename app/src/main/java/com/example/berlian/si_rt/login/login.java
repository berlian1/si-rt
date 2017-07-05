package com.example.berlian.si_rt.login;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.berlian.si_rt.MainActivity;
import com.example.berlian.si_rt.R;
import com.example.berlian.si_rt.kegiatan.resKegiatan;
import com.example.berlian.si_rt.request;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {
EditText username,pass;
    Button btnLogin;
    SessionManager sessionManager;

    private String url = "http://10.0.2.2/Si-RT2/index.php/rest/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sessionManager = new SessionManager(getApplicationContext());
        username = (EditText)findViewById(R.id.edUsername);
        pass = (EditText)findViewById(R.id.edPass);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAdmin loginAdmin = new loginAdmin(username.getText().toString(),pass.getText().toString());

/*
                Intent intent = new Intent(login.this, MainActivity.class);
                startActivity(intent);
*/
            checkLogin(loginAdmin);

            }
        });

    }

    void checkLogin(loginAdmin admin){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient Client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(url).
                addConverterFactory(GsonConverterFactory.create()).
                client(Client).
                build();
        request client = retrofit.create(request.class);
        Call<loginAdmin> call = client.loginAdmin(admin);

        call.enqueue(new Callback<loginAdmin>() {
            @Override
            public void onResponse(Call<loginAdmin> call, Response<loginAdmin> response) {
                sessionManager.createSession(response.body().getAdminnama().toString(),response.body().getAdminlogin());

              sessionManager.checkLogin();
                finish();
                /*if (response.body().getAdminlogin() == true){
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }*/
            }

            @Override
            public void onFailure(Call<loginAdmin> call, Throwable t) {

            }
        });
    }
}
