package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.ImageRatio;
import com.google.gson.JsonObject;

public class Thumbnail {
    private String imageUrl;
    private JsonObject link;
    private boolean fixedRatio = false;
    private int width;
    private int height;

    public Thumbnail imageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        return this;
    }

    public Thumbnail link(Link link){
        this.link = link.build();
        return this;
    }

    //default false
    public Thumbnail fixedRatio(ImageRatio ratio){
        this.fixedRatio = true;
        this.width = ratio.getWidth();
        this.height = ratio.getHeight();
        return this;
    }

    private void checkEssentials(){
        if(imageUrl == null){

        }
    }

    public JsonObject build(){
        checkEssentials();
        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("imageUrl", imageUrl);

        if(link != null)
            tempObj.add("link",link);
        
        if(fixedRatio){
            tempObj.addProperty("fixedRatio", fixedRatio);
            tempObj.addProperty("width ", width);
            tempObj.addProperty("height", height);
        }

        return tempObj;
    }

    public JsonObject buildCarousel(){
        checkEssentials();
        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("imageUrl", imageUrl);

        return tempObj;
    }
}
