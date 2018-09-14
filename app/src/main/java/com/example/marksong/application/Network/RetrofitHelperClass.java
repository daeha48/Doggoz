package com.example.marksong.application.Network;

import android.support.annotation.Nullable;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelperClass {

    private static Retrofit dogFit;
    private static final String dogUrl = "https://random.dog";

    public static Retrofit getDogUrlInstance(){
        if (dogFit == null){
            dogFit = new retrofit2.Retrofit.Builder()
                    .addConverterFactory(new NullOnEmptyConverterFactory())
                    .baseUrl(dogUrl)
                    .build();
        }
        return dogFit;
    }

    public static class NullOnEmptyConverterFactory extends Converter.Factory{
        @Nullable
        @Override
        public Converter<ResponseBody,?> responseBodyConverter(Type type, Annotation[] annotations,Retrofit retrofit){
            final Converter<ResponseBody, Object> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return new Converter<ResponseBody, Object>() {
                @Override
                public Object convert(ResponseBody value) throws IOException {
                    return value.contentLength() != 0 ? delegate.convert(value) : null;
                }
            };
        }
    }
}
