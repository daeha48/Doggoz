package com.example.marksong.application.Util;

import com.example.marksong.application.Network.Response.ErrorMessage;
import com.google.gson.Gson;

import retrofit2.Response;

public class ErrorUtil {

    public static String returnErrorMsg(Response<?> response){
        Gson gson = new Gson();
        ErrorMessage errorMsg = gson.fromJson(response.errorBody().charStream(), ErrorMessage.class);
        return errorMsg.getMessage();
    }
}
