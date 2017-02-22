package com.example.zhucan.joke.ui;

/**
 * Created by zhucan on 2017/2/15.
 */

public class ResponseCode {
    private String resultCode;
    private String description;

    public void setResultCode(String resultCode){
        this.resultCode=resultCode;
    }
    public String getResultCode(){
        return resultCode;
    }

    public void setDescription(String description){
        this.description=description;

    }

    public String getDescription(){
        return description;
    }
}
