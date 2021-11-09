package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.SkillResponse;
import com.google.gson.JsonObject;

public class SimpleImage implements SkillResponse{
    private String url;
    private String altText;
    private JsonObject result;
    private final int skillNum = 2;

    public SimpleImage imageUrl(String url){
        this.url = url;
        return this;
    }

    public SimpleImage altText(String altText){
        this.altText = altText;
        return this;
    }

    private void checkEssentials(){
        if(url == null || altText == null){
            //error
            altText = "error";
            url = "";
        }
    }

    @Override
    public int getSkillNum() {
        return skillNum;
    }

    @Override
    public JsonObject build(){    
        checkEssentials();
        
        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("imageUrl", url);
        tempObj.addProperty("altText", altText);
        return tempObj;
    }
}
