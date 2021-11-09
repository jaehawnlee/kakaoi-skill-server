package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ListCardProperties;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Link;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ListItem{
    private String title;
    private String description;
    private String imageUrl;
    private JsonObject link;

    public ListItem title(String title){
        this.title = title;
        return this;
    }

    public ListItem description(String description){
        this.description = description;
        return this;
    }

    public ListItem imageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        return this;
    }

    public ListItem link(Link link){
        this.link = link.build();
        return this;
    }
    
    private void checkEssentials(){
        if(title == null){
            //error
        }
    }

    public  JsonObject build(){
        checkEssentials();
        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("title", title);
        if(description != null) tempObj.addProperty("description", description);
        if(imageUrl != null) tempObj.addProperty("imageUrl", imageUrl);
        if(link != null) tempObj.add("link",link);

        return tempObj;
    }
}
