package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Extra;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.Action;
import com.google.gson.JsonObject;

public class QuickReplies {
    private String label;
    private String action;
    private int actionState = -1;
    private String messageText;
    private String blockId;
    private JsonObject extra;

    public QuickReplies label(String label){
        this.label = label;
        return this;
    }

    public QuickReplies action(Action action){
        this.action = action.getAction();
        this.actionState = action.getActionNum();
        return this;
    }

    public QuickReplies messageText(String messageText){
        this.messageText = messageText;
        return this;
    }

    public QuickReplies blockId(String blockId){
        this.blockId = blockId;
        return this;
    }

    public QuickReplies extra(Extra extra){
        this.extra = extra.build();
        return this;
    }

    private void checkEssentials(){
        if(label == null || action == null){
            //error
        }

        if(actionState < 2 && actionState > 4){
            //error
        }
    }

    public JsonObject build(){    
        checkEssentials();
        JsonObject tempObj = new JsonObject();

        tempObj.addProperty("action", action);
        tempObj.addProperty("label", label);
             
        if(actionState == Action.MESSAGE.getActionNum() ||
           actionState == Action.BLOCK.getActionNum() &&
           messageText != null ) 
            tempObj.addProperty("messageText", messageText);
        
        if(actionState == Action.BLOCK.getActionNum()&&
           blockId != null ) 
            tempObj.addProperty("blockId", blockId);

        if(extra != null)
            tempObj.add("extra",extra);

        return tempObj;
    }
}
