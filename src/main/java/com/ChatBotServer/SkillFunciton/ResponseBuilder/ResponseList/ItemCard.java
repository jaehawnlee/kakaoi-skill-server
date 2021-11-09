package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.SkillResponse;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Button;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.ButtonLayout;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.ItemAlignment;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.Head;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ImageTitle;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ItemList;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ItemListSummary;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ItemProfile;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ItemThumbnail;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ItemCard implements SkillResponse {
    private JsonObject thumbnail;
    private JsonObject head;
    private  JsonObject profile;
    private  JsonObject imageTitle;
    private   JsonArray  itemList;
    private  String itemListAlignment;

    private  JsonObject itemListSummary;
    private  String title;
    private  String description;
    private  JsonArray buttons;
    private  String buttonLayout;

    private final int skillNum = 5;

    public ItemCard thumbnail(ItemThumbnail thumbnail){
        this.thumbnail = thumbnail.build();
        return this;
    }

    public ItemCard head(Head head){
        this.head = head.build();
        return this;
    }

    public ItemCard profile(ItemProfile profile){
        this.profile = profile.build();
        return this;
    }

    public ItemCard imageTitle(ImageTitle imageitle){
        this.imageTitle = imageitle.build();
        return this;
    }

    public ItemCard itemList(ItemList item){
        if(itemList == null){
            itemList = new JsonArray();
        }

        this.itemList.add(item.build());
        return this;
    }

    public ItemCard itemListAlignment(ItemAlignment alignment){
        this.itemListAlignment = alignment.getAlignment();
        return this;
    }

    public ItemCard itemListSummary(ItemListSummary summary){
        this.itemListSummary = summary.build();
        return this;
    }

    public ItemCard title(String title){
        this.title = title;
        return this;
    }

    public ItemCard description(String title, String description){
        this.title = title;
        this.description = description;
        return this;
    }

    public ItemCard button(Button button){
        if(buttons == null)
        {
            buttons = new JsonArray();
        }
        buttons.add(button.build());

        return this;
    }

    public ItemCard buttonLayout(ButtonLayout layuout){
        this.buttonLayout = layuout.getLayout();
        return this;
    }

    private void checkEssentials(){
        if(itemList == null){
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
        if(thumbnail != null) tempObj.add("thumbnail", thumbnail);
        if(head != null) tempObj.add("head", head);
        if(profile != null) tempObj.add("profile", profile);
        if(imageTitle != null) tempObj.add("imageTitle", imageTitle);
        tempObj.add("itemList",itemList);

        if(itemListAlignment != null) tempObj.addProperty("itemListAlignment",itemListAlignment);
        if(itemListSummary != null) tempObj.add("itemListSummary",itemListSummary);

        if(title != null) tempObj.addProperty("title",title);
        if(description != null) tempObj.addProperty("description",description);

        if(buttons != null) tempObj.add("buttons",buttons);
        if(buttonLayout != null) tempObj.addProperty("buttonLayout", buttonLayout);

        return tempObj;
    }

   
}
