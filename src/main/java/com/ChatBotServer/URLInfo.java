package com.ChatBotServer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:urlinfo.properties")
public class URLInfo {
    @Value("#{${iuPhoto.map}}")
    private Map<String, String> url = new HashMap<String, String>();

    public Map<String, String> getURL() {
       return this.url;
   }
}
