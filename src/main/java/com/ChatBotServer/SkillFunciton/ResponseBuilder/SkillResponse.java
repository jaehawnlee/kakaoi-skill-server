package com.ChatBotServer.SkillFunciton.ResponseBuilder;

import com.google.gson.JsonObject;

public interface SkillResponse {
    public abstract JsonObject build();
    public abstract int getSkillNum();
}
