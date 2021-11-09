package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.SkillResponse;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Button;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Profile;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Thumbnail;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.Currency;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CommerceCard implements SkillResponse{
    private String description;
    private int price = -1;
    private String currency;
    private int discount = -1;
    private int discountRate = -1; // discount보다 우선, discountedPrice필수
    private int discountedPrice = -1; // 최우선 노출
    private JsonArray thumbnails;// 현재 1개만 가능
    private JsonObject profile;
    private JsonArray buttons;
    private final int skillNum = 4;

    public CommerceCard description(String description){
        this.description = description;
        return this;
    }

    public CommerceCard price(int price){
        this.price = price;
        return this;
    }

    //현재 "won"만 가능
    public CommerceCard currency(Currency currency){
        this.currency = currency.getCurrency();
        return this;
    }
    
    public CommerceCard discount(int discount){
        this.discount = discount;
        return this;
    }

    public CommerceCard discountRate(int discountRate, int discountedPrice){
        this.discountRate = discountRate;
        this.discountedPrice = discountedPrice;
        return this;
    }

    public CommerceCard discountedPrice(int discountedPrice){
        this.discountedPrice = discountedPrice;
        return this;
    }

    public CommerceCard thumbnail(Thumbnail thumbnail){
        if(thumbnails == null)
        {
            thumbnails = new JsonArray();
        }
        this.thumbnails.add(thumbnail.build());

        return this;
    }

    public CommerceCard profile(Profile profile){
        this.profile = profile.build();
        return this;
    }

    public CommerceCard button(Button button){
        if(buttons == null)
        {
            buttons = new JsonArray();
        }
        buttons.add(button.build());

        return this;
    }

    private void checkEssentials(){
        if(description == null || price == -1 || currency == null ||
            thumbnails == null || buttons == null){
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
        
        tempObj.addProperty("description", description);
        tempObj.addProperty("price", price);
        if(discount != -1) tempObj.addProperty("discount", discount);
        if(discountRate != -1) tempObj.addProperty("discountRate", discountRate);
        if(discountedPrice != -1) tempObj.addProperty("discountedPrice", discountedPrice);
        tempObj.add("thumbnails", thumbnails);
        
        if(profile != null) tempObj.add("profile", profile);
        tempObj.add("buttons", buttons);
        return tempObj;
    }


}
