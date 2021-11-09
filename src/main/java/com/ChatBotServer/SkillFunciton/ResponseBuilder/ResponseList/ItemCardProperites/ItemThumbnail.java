package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.ImageRatio;
import com.google.gson.JsonObject;

public class ItemThumbnail {
    private String imageUrl;
    private int width = -1;
    private int height = -1;

    public ItemThumbnail imageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        return this;
    }

    //default false
    public ItemThumbnail Ratio(ImageRatio ratio){
        this.width = ratio.getWidth();
        this.height = ratio.getHeight();
        return this;
    }

    private void checkEssentials(){
        if(imageUrl == null || width == -1 || height == -1){

        }
    }

    public JsonObject build(){
        checkEssentials();

        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("imageUrl", imageUrl);
        tempObj.addProperty("width ", width);
        tempObj.addProperty("height", height);

        return tempObj;
    }
}
