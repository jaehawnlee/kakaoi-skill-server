package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.SkillResponse;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.CarouselHeader;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.CarouselType;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Carousel implements SkillResponse{
    private String type;
    private JsonArray items;
    private JsonObject header;
    private final int skillNum = 7;

    public Carousel type(CarouselType type){
        this.type = type.getType();
        return this;
    }

    public Carousel item(BasicCard item){
        if(items == null){
            items = new JsonArray();
        }
        this.items.add(item.build());
        return this;
    }

    public Carousel item(CommerceCard item){
        if(items == null){
            items = new JsonArray();
        }
        this.items.add(item.build());
        return this;
    }

    public Carousel item(ListCard item){
        if(items == null){
            items = new JsonArray();
        }
        this.items.add(item.build());
        return this;
    }

    public Carousel item(ItemCard item){
        if(items == null){
            items = new JsonArray();
        }
        this.items.add(item.build());
        return this;
    }

    public Carousel header(CarouselHeader header){
        this.header = header.build();
        return this;
    }

    private void checkEssentials(){
        if(type == null || items == null){
            //error
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
        tempObj.addProperty("type", type);
        if(header != null) tempObj.add("header", header);
        tempObj.add("items", items);

        return tempObj;
    }
}
