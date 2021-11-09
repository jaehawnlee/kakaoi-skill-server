package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common;

import com.google.gson.JsonObject;

//to be update...
public class Forwardable {
    private boolean forwardable;
    private Forwardable fowardable(boolean forwardable){
        this.forwardable = forwardable;
        return this;
    }

    private JsonObject build(){
        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("forwardable", forwardable);

        return tempObj;
    }
}
