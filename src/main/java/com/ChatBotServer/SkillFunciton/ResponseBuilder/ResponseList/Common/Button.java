package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.Action;
import com.google.gson.JsonObject;

public class Button {

    private String label;
    private String action;
    private String webLinkUrl; // webLink
    private String messageText; // message, block
    private String phoneNumber; // phone
    private String blockId; //block
    private JsonObject extra; // add info

    private JsonObject result;
    private int actionState;

    public Button label(String label){
        this.label = label;
        return this;
    }

    public Button action(Action action){
        this.action = action.getAction();
        this.actionState = action.getActionNum();
        return this;
    }

    public Button webLinkUrl(String webLinkUrl){
        this.webLinkUrl = webLinkUrl;
        return this;
    }
    
    public Button messageText(String messageText){
    
        this.messageText = messageText;
        return this;
    }

    public Button phoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Button blockId(String blockId){
        this.blockId = blockId;
        return this;
    }

    public Button extra(Extra extra){
        this.extra = extra.build();
        return this;
    }

    private void checkEssentials(){
        if(label == null || action == null){
            //error
        }
    }

    public JsonObject build(){    
        checkEssentials();
        JsonObject tempObj = new JsonObject();

        tempObj.addProperty("action", action);
        tempObj.addProperty("label", label);
        
        if(actionState == Action.WEBLINK.getActionNum() &&
            webLinkUrl != null) 
            tempObj.addProperty("webLinkUrl", webLinkUrl);
        
        if(actionState == Action.MESSAGE.getActionNum() ||
           actionState == Action.BLOCK.getActionNum() &&
           messageText != null ) 
            tempObj.addProperty("messageText", messageText);
        
        if(actionState == Action.PHONE.getActionNum()&&
           phoneNumber != null ) 
            tempObj.addProperty("phoneNumber", phoneNumber);
        
        if(actionState == Action.BLOCK.getActionNum()&&
           blockId != null ) 
            tempObj.addProperty("blockId", blockId);

        if(extra != null)
            tempObj.add("extra",extra);

        return tempObj;
    }
}
