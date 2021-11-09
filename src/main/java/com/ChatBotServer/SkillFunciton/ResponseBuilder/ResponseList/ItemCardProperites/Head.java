package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites;

import com.google.gson.JsonObject;

public class Head {
    String title;

    public Head title(String title){
        this.title = title;
        return this;
    }

    private void checkEssentials(){
        if(title == null){

        }
    }
    
    public JsonObject build(){
        JsonObject tempObj = new JsonObject();

        checkEssentials();
        tempObj.addProperty("title", title);

        return tempObj;
    }
}
