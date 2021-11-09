package com.ChatBotServer.SkillFunciton.ResponseBuilder;

import java.util.HashMap;
import java.util.Map;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ContextValue;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Forwardable;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Response {
    /**
     *  call => ResponseList 
     */
    private JsonObject outputs;
    private JsonObject result;
    private JsonArray skills;
    private JsonArray quickreplies;
    private JsonObject contexts;
    private JsonArray extra;

    private final Map<Integer,String> sKillMap = new HashMap<>(){{
        put(1, "simpleText"); put(2, "simpleImage"); put(3, "basicCard");
        put(4, "commerceCard"); put(5, "itemCard"); put(6, "listCard");
        put(7,"carousel");
    }}; 

    public Response(){
        result = new JsonObject();
        outputs = new JsonObject();
        skills = new JsonArray();
        result.addProperty("version", "2.0");
    }

    public Response addSkill(SkillResponse skill){
        JsonObject tempObj = new JsonObject();
        tempObj.add(sKillMap.get(skill.getSkillNum()), skill.build());
        skills.add(tempObj);
        return this;
    }

    public Response addSkill(SkillResponse skill, Boolean forwardable){
        JsonObject tempObj = new JsonObject();
        JsonObject _tempObj =  skill.build();
        _tempObj.addProperty("forwardable",forwardable);

        tempObj.add(sKillMap.get(skill.getSkillNum()), _tempObj);
        skills.add(tempObj);
        return this;
    }

    public Response addQuickreplies(JsonObject reply){
        if(quickreplies == null){
            quickreplies = new JsonArray();
        }

        quickreplies.add(reply);
        return this;
    }

    public Response addContext(ContextValue context){
        if(contexts == null){
        //    contexts = new JsonArray();
        }

        contexts = context.build();
        return this;
    }

    public JsonObject build(){
        outputs.add("outputs", skills);
        if(quickreplies != null) outputs.add("quickReplies",quickreplies);
        result.add("template", outputs);
        
        if(contexts != null) result.add("context", contexts);

        return result;
    }
}
