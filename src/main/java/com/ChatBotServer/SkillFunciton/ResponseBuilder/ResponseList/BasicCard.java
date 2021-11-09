package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.SkillResponse;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Button;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Profile;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Thumbnail;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class BasicCard implements SkillResponse{
    private String title;
    private String description;
    private JsonObject thumbnail;
    private JsonObject profile;
    private JsonObject social;
    private JsonArray buttons;

    private final int skillNum = 3;

    public BasicCard title(String title){
        this.title = title;
        return this;
    }

    public BasicCard description(String description){
        this.description = description;
        return this;
    }

    public BasicCard thumbnail(Thumbnail thumbnail){
        this.thumbnail = thumbnail.build();
        return this;
    }

    //profile, social 현재 미지원
    private BasicCard profile(Profile profile){
        this.profile = profile.build();
        return this;
    }

    private BasicCard social(JsonObject social){
        this.social = social;
        return this;
    }
    

    public BasicCard button(Button button){
        if(buttons == null)
        {
            buttons = new JsonArray();
        }
        buttons.add(button.build());

        return this;
    }


    private void checkEssentials(){
        if(thumbnail == null){
            //error
        }
    }

    @Override
    public int getSkillNum() {
        // TODO Auto-generated method stub
        return skillNum;
    }

    @Override
    public JsonObject build(){    
        checkEssentials();

        JsonObject tempObj = new JsonObject();
        if(title != null) tempObj.addProperty("title", title);
        if(description != null) tempObj.addProperty("description", description);
        tempObj.add("thumbnail", thumbnail);

        if(profile != null) tempObj.add("profile", profile);
        if(social != null) tempObj.add("social", social);
        if(buttons != null) tempObj.add("buttons", buttons);

        return tempObj;
    }
}
