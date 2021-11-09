package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common;

import com.google.gson.JsonObject;

public class Link {
    private String web;
    private String pc;
    private String mobile;

    public Link web(String web){
        this.web = web;
        return this;
    }

    public Link pc(String pc){
        this.pc = pc;
        return this;
    }

    public Link mobile(String mobile){
        this.mobile = mobile;
        return this;
    }

    public JsonObject build(){
        JsonObject tempObj = new JsonObject();

        if(web != null)
            tempObj.addProperty("web", web);
        
        if(pc != null)
            tempObj.addProperty("pc", pc);

        if(mobile != null)
            tempObj.addProperty("mobile", mobile);

        return tempObj;
    }
}
