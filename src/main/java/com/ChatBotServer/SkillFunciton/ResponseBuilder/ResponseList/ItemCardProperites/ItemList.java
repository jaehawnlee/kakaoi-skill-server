package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites;

import com.google.gson.JsonObject;

public class ItemList {
    String title;
    String description;

    public ItemList title(String title){
        this.title = title;
        return this;
    }

    public ItemList description(String description){
        this.description = description;
        return this;
    }

    private void checkEssentials(){
        if(title == null || description == null){

        }
    }

    public JsonObject build(){
        checkEssentials();

        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("title", title);
        tempObj.addProperty("description", description);

        return tempObj;
    }
}
