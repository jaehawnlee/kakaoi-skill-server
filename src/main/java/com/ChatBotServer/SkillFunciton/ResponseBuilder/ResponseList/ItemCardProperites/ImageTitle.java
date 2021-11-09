package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites;

import com.google.gson.JsonObject;

public class ImageTitle {
    String title;
    String description;
    String imageUrl;

    public ImageTitle title(String title){
        this.title = title;
        return this;
    }
    
    public ImageTitle imageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        return this;
    }

    public ImageTitle description(String description){
        this.description = description;
        return this;
    }

    private void checkEssentials(){
        if(title == null){

        }
    }

    public JsonObject build(){
        checkEssentials();

        JsonObject tempObj = new JsonObject();
        
        tempObj.addProperty("title", title);
        tempObj.addProperty("description", description);
        tempObj.addProperty("imageUrl", imageUrl);

        return tempObj;
    }
}
