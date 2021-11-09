package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.SkillResponse;

import com.google.gson.JsonObject;

public class SimpleText implements SkillResponse{
    private String text;
    private JsonObject result;
    private final int skillNum = 1;

    public SimpleText text(String text){
        this.text = text;
        return this;
    }

    private void checkEssentials(){
        if(text == null){
            //error
            text = "error";
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
        tempObj.addProperty("text", text);
        return tempObj;
    }
}
