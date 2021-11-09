package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Extra{
    private JsonObject extra = new JsonObject();

    public Extra addProperty(String property, String value){
        this.extra.addProperty(property, value);
        return this;
    }

    public Extra addProperty(String property, Number value){
        this.extra.addProperty(property, value);
        return this;
    }

    public Extra addProperty(String property, Character value){
        this.extra.addProperty(property, value);
        return this;
    }

    public Extra addProperty(String property, Boolean value){
        this.extra.addProperty(property, value);
        return this;
    }

    public Extra add(String property, JsonElement value){
        this.extra.add(property, value);
        return this;
    }

    public JsonObject build(){
        return extra;
    }
}
