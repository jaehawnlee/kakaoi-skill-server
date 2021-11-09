package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ListCardProperties.ListItem;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.SkillResponse;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Button;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Link;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ListCard implements SkillResponse{
    private JsonObject header;
    private JsonArray items;
    private JsonArray buttons;
    private final int skillNum = 6;

    public ListCard header(ListItem listItem){
        this.header = listItem.build();
        return this;
    }

    public ListCard item(ListItem listItem){
        if(items == null){
            items = new JsonArray();
        }

        this.items.add(listItem.build());
        return this;
    }

    public ListCard button(Button button){
        if(buttons == null){
            buttons = new JsonArray();
        }

        this.buttons.add(button.build());
        return this;
    }

    private void checkEssentials(){
        if(header == null || items == null){
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
        tempObj.add("header", header);
        tempObj.add("items", items);
        if(buttons != null) tempObj.add("buttons", buttons);
        return tempObj;
    }
}
