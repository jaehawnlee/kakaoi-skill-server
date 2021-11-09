package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

//코드로 새로운 values 생성 불가능
//실제 존재하는 values의 param 변경가능
public class ContextValue {
    private JsonArray values = new JsonArray();
    private String name;
    private int lifeSpan;
    private Map<String, String> paramsInfo;
    private JsonObject params;

    public ContextValue name(String name){
        this.name = name;
        return this;
    }

    public ContextValue lifeSpan(int lifeSpan){
        this.lifeSpan = lifeSpan;
        return this;
    }

  //  public ContextValue InsertValue(JsonObject params){

   // }
   public JsonObject build(){
       JsonObject tempObj = new JsonObject();
       JsonObject tempObj2 = new JsonObject();

       tempObj.addProperty("name", name);
       tempObj.addProperty("lifeSpan", lifeSpan);

       values.add(tempObj);

       tempObj2.add("values", values);
       return tempObj2;
   }
}
