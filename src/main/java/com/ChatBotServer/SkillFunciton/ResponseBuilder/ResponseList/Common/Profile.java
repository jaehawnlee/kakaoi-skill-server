package com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common;

import com.google.gson.JsonObject;

//현재 미지원
public class Profile {
    private String nickname;
    private String imageUrl;

    public Profile nickname(String nickname){
        this.nickname = nickname;
        return this;
    }

    public Profile imageUrl(String imageUrl){
        this.imageUrl = imageUrl;
        return this;
    }

    private void checkEssentials(){
        if(nickname == null){
        }
    }

    public JsonObject build(){    
        checkEssentials();

        JsonObject tempObj = new JsonObject();
        tempObj.addProperty("nickname", nickname);

        if(imageUrl != null)
            tempObj.addProperty("imageUrl",imageUrl);

        return tempObj;
    }
}
