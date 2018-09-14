package com.example.marksong.application;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.marksong.application.Network.Response.DogResponse;
import com.example.marksong.application.Network.RetrofitHelperClass;
import com.example.marksong.application.Network.ServiceMethod;
import com.example.marksong.application.Util.ErrorUtil;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    private static final String TAG = MainActivity.class.getCanonicalName();
    private Button doggoBtn, openDoggoBtn;
    private String doggoUrlz;
    private Boolean doggoIsRdy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getDoggoUrl();
    }

    private void initViews(){
        doggoBtn = (Button) findViewById(R.id.get_doggo_button);
        openDoggoBtn = (Button) findViewById(R.id.open_doggo_button);

        doggoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDoggoUrl();
            }
        });

        openDoggoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doggoIsRdy){

                }
                else {
                    Toast.makeText(getApplicationContext(), "Yo doggo iz not ready. Maybe get one first", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void getDoggoUrl(){
        ServiceMethod service = RetrofitHelperClass.getDogUrlInstance().create(ServiceMethod.class);
        Call<DogResponse> doggoCall = service.getRandoDoggo();
        doggoCall.enqueue(new Callback<DogResponse>() {
            @Override
            public void onResponse(Call<DogResponse> call, Response<DogResponse> response) {
                if (response.isSuccessful()){
                    doggoUrlz = response.body().getDoggoUrl();
                    doggoIsRdy = true;
                }
                else{
                    ErrorUtil.returnErrorMsg(response);
                    doggoIsRdy = false;
                }
            }

            @Override
            public void onFailure(Call<DogResponse> call, Throwable t) {
                Log.d(TAG,"Couldn't get no doggo url");
                doggoIsRdy = false;
            }
        });
    }

    private void openDuhDoggoUrl(){
        CustomTa
    }

}
