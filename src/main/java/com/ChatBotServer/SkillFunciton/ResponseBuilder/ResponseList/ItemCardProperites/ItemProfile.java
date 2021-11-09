package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.ImageRatio;
import com.google.gson.JsonObject;

public class ItemProfile {
    private String imageUrl;
    private int width = -1;
    private int height = -1;
    private String title;

    public ItemProfile imageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        return this;
    }

    //default false
    public ItemProfile Ratio(ImageRatio ratio){
        this.width = ratio.getWidth();
        this.height = ratio.getHeight();
        return this;
    }

    public ItemProfile title(String title){
        this.title = title;
        return this;
    }

    private void checkEssentials(){
        if(imageUrl == null || title == null){

        }
    }

    public JsonObject build(){
        checkEssentials();

        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("imageUrl", imageUrl);

        if(width != -1)tempObj.addProperty("width ", width);
        if(height != -1) tempObj.addProperty("height", height);

        tempObj.addProperty("title", title);
        return tempObj;
    }
}
