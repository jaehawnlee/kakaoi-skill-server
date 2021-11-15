package com.ChatBotServer.SkillFunciton.Sample;

import java.util.Map;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.*;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.*;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.*;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.*;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.*;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ListCardProperties.*;
import com.google.gson.JsonObject;

public class Example {
    Response response = new Response();
    Map<String,String> url;

    public Example (){
    }

    public Example (Map<String,String> url){
        this.url = url;
    }
    
    public void simpleText(){
        response.addSkill(new SimpleText()
                              .text("RUN IU!")
                         );
    }

    public void simpleImage(){   
        response.addSkill(new SimpleImage()
                         .imageUrl(url.get("main"))
                         .altText("그녀는 신이야!")
                    );      

    }

    public void BasicCard(){
        response.addSkill(new BasicCard()
                        .title("아이유")
                        .description("아이유 참이슬 폼")
                        .thumbnail(new Thumbnail()
                                .imageUrl(url.get("main"))
                                .link(new Link()
                                            .mobile("https://www.instagram.com/official.chamisul/?hl=ko")
                                            .pc("https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0")))
                        .button(new Button()
                                .action(Action.WEBLINK)
                                .label("장만월")
                                .webLinkUrl("https://namu.wiki/w/%EC%9E%A5%EB%A7%8C%EC%9B%94"))
        );
    }

    public void BasicCardForwardable(){
        response.addSkill(new BasicCard()
                        .title("아이유")
                        .description("아이유 참이슬 폼")
                        .thumbnail(new Thumbnail()
                                .imageUrl(url.get("main"))
                                .link(new Link()
                                            .mobile("https://www.instagram.com/official.chamisul/?hl=ko")
                                            .pc("https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0")))
                            
                          , true);
    }

    public void CommerceCard(){
        response.addSkill(new CommerceCard()
                        .description("참이슬")
                        .price(2000)
                        .currency(Currency.WON)
                        .discountRate(20, 1600)
                        .thumbnail(new Thumbnail()
                            .imageUrl(url.get("soju"))
                            .link(new Link()
                                .mobile("https://www.instagram.com/official.chamisul/?hl=ko")
                                .pc("https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0")))
                        .profile(new Profile()
                                .imageUrl(url.get("main"))
                                .nickname("iu 포스터"))
                        .button(new Button()
                                .action(Action.WEBLINK)
                                .label("장만월")
                                .webLinkUrl("https://namu.wiki/w/%EC%9E%A5%EB%A7%8C%EC%9B%94"))
                        .button(new Button()
                                .action(Action.SHARE)
                                .label("공유하기"))
        );     
    }

    public void ListCard(){
        response.addSkill(new ListCard()
                        .header(new ListItem()
                                .title("IU 모음"))                 
                        .item(new ListItem()
                                .title("장만월")
                                .description("호텔델루나")
                                .imageUrl(url.get("manweol"))
                                .link(new Link()
                                        .web("https://namu.wiki/w/%EC%9E%A5%EB%A7%8C%EC%9B%94")))
                        .item(new ListItem()
                                .title("아이유")
                                .description("참이슬 화보")
                                .imageUrl(url.get("main"))
                                .link(new Link()
                                        .web("https://www.instagram.com/official.chamisul/?hl=ko")))
                        .button(new Button()
                                .action(Action.SHARE)
                                .label("공유하기"))
        );
    }

    public void ItemCard(){         
        response.addSkill(new ItemCard()
                        .thumbnail(new ItemThumbnail()
                                .imageUrl(url.get("main"))
                                .Ratio(ImageRatio.ONETOONE))                 
                        .profile(new ItemProfile()
                                .imageUrl(url.get("manweol"))
                                .title("장만월"))
                        .imageTitle(new ImageTitle()
                                    .title("IU")
                                    .description("이지은")
                                    .imageUrl(url.get("soju")))
                        .itemList(new ItemList()
                                  .title("이지은")
                                  .description("본캐"))
                        .itemList(new ItemList()
                                  .title("이지금")
                                  .description("부캐"))
                        .itemList(new ItemList()
                                  .title("이지동")
                                  .description("왕부캐"))
                        .itemListAlignment(ItemAlignment.LEFT)
                        .itemListSummary(new ItemListSummary()
                                         .title("아이유 모음")
                                         .description("더 많은 아이유"))
                        .description("아이템 카드", "귀찮네")
                        .button(new Button()
                                .action(Action.SHARE)
                                .label("공유하기"))
                                .button(new Button()
                                .action(Action.WEBLINK)
                                .label("장만월 보고가")
                                .webLinkUrl("https://namu.wiki/w/%EC%9E%A5%EB%A7%8C%EC%9B%94"))
        );       
    }

    public void Carousel(){
        response.addSkill(new Carousel()
                            .type(CarouselType.BASIC)
                            .header(new CarouselHeader()
                                    .title("IU")
                                    .description("IU들")
                                    .thumbnail(new Thumbnail()
                                                .imageUrl(url.get("manweol"))))
                            .item(new BasicCard()
                                    .title("이지은")
                                    .description("본체")
                                    .thumbnail(new Thumbnail()
                                            .imageUrl(url.get("main")))
                                    .button(new Button()
                                            .action(Action.WEBLINK)
                                            .label("보기")
                                            .webLinkUrl("https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0")))                    
                            .item(new BasicCard()
                                    .title("이지금")
                                    .description("부캐")
                                    .thumbnail(new Thumbnail()
                                            .imageUrl(url.get("gold")))
                                    .button(new Button()
                                    .action(Action.WEBLINK)
                                    .label("보기")
                                            .webLinkUrl("https://namu.wiki/w/%EC%9D%B4%EC%A7%80%EA%B8%88"))) 
                            .item(new BasicCard()
                                    .title("이지동")
                                    .description("부부캐")
                                    .thumbnail(new Thumbnail()
                                                    .imageUrl(url.get("bronze")))
                                    .button(new Button()
                                            .action(Action.WEBLINK)
                                            .label("보기")
                                            .webLinkUrl("https://namu.wiki/w/%EC%9D%B4%EC%A7%80%EB%8F%99"))) 
       );
    }

    public void Quickreplies(){
        response.addQuickreplies(new QuickReplies()
                                .action(Action.MESSAGE)
                                .label("10km/h")
                                .messageText("빠른 아이유다")
                                .build());

        response.addQuickreplies(new QuickReplies()
                                .action(Action.MESSAGE)
                                .label("2km/h")
                                .messageText("느린 아이유다")
                                .build());

        response.addQuickreplies(new QuickReplies()
                                .action(Action.MESSAGE)
                                .label("6km/h")
                                .messageText("보통 아이유다")
                                .build());
    }

    public void QuickrepliesWithExtra(){
        response.addQuickreplies(new QuickReplies()
                                .action(Action.MESSAGE)
                                .label("10km/h")
                                .messageText("빠른 아이유다")
                                .extra(new Extra()
                                .addProperty("fast", "Speed up"))
                                .build());

        response.addQuickreplies(new QuickReplies()
                                .action(Action.MESSAGE)
                                .label("2km/h")
                                .messageText("느린 아이유다")
                                .build());

        response.addQuickreplies(new QuickReplies()
                                .action(Action.MESSAGE)
                                .label("6km/h")
                                .messageText("보통 아이유다")
                                .build());
    }

    public JsonObject makeExam(){
            return  response.build();
    }

}
