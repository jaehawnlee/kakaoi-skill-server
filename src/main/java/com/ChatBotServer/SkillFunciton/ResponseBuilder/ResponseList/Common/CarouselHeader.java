package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common;

import com.google.gson.JsonObject;

public class CarouselHeader {
    private String  title;
    private String  description;
    private JsonObject thumbnail;
    private JsonObject result;

    public CarouselHeader title(String title){
        this.title = title;
        return this;
    }

    public CarouselHeader description(String description){
        this.description = description;
        return this;
    }

    public CarouselHeader thumbnail(Thumbnail thumbnail){
        this.thumbnail = thumbnail.buildCarousel();
        return this;
    }

    private void checkEssentials(){
        if(title == null || description ==null || thumbnail == null){
        }
    }

    public JsonObject build(){
        checkEssentials();

        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("title", title);
        tempObj.addProperty("description", description);
        tempObj.add("thumbnail", thumbnail);

        return tempObj;
    }
}
