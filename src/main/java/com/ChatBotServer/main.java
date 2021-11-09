package com.ChatBotServer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ChatBotServer.SkillFunciton.ResponseBuilder.Response;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.*;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Button;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.CarouselHeader;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Extra;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Link;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Profile;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Common.Thumbnail;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.Action;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.CarouselType;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.Currency;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.ImageRatio;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.Enum.EnumList.ItemAlignment;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.Head;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ImageTitle;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ItemList;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ItemListSummary;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ItemProfile;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ItemCardProperites.ItemThumbnail;
import com.ChatBotServer.SkillFunciton.ResponseBuilder.ResponseList.ListCardProperties.ListItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import lombok.extern.slf4j.*;

@Slf4j
@WebServlet("/")
public class main  extends HttpServlet {
    int test = 0;
    int initCount = 0;
    ServletRequest req;
    String strLog;

    @Override
    public void init() throws ServletException {
        // Initialization code...
     }

    /*
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // Logging
      
        log.debug("req"+ Integer.toString(test));
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        writer.println("<h1>Hello This is Sample Servlet!</h1>");
    }
    */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(strLog);
    }
    
    //run debug 현재 동작 다름.. 왜그러지??
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        Gson parse = new GsonBuilder().setPrettyPrinting().create();
        strLog =  parse.toJson(getBody(req));
        /*
        response.addSkill(new SimpleText()
                              .text("RUN IU!")
                         );

        response.addSkill(new SimpleImage()
                         .imageUrl("http://kimshinparklee.com/img/queenIU.jpg")
                         .altText("그녀는 신이야!")
                    );      

        response.addSkill(new BasicCard()
                    .title("아이유")
                    .description("아이유 참이슬 폼")
                    .thumbnail(new Thumbnail()
                              .imageUrl("http://kimshinparklee.com/img/queenIU.jpg")
                               .link(new Link()
                                        .mobile("https://www.instagram.com/official.chamisul/?hl=ko")
                                        .pc("https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0")))
                    .button(new Button()
                            .action(Action.WEBLINK)
                            .label("장만월")
                            .webLinkUrl("https://namu.wiki/w/%EC%9E%A5%EB%A7%8C%EC%9B%94"))
                    .button(new Button()
                            .action(Action.MESSAGE)
                            .label("장만월")
                            .messageText("호텔델루나 애옹"))
        );
        
        response.addSkill(new CommerceCard()
                    .description("참이슬")
                    .price(2000)
                    .currency(Currency.WON)
                    .discountRate(20, 1600)
                    .thumbnail(new Thumbnail()
                        .imageUrl("http://kimshinparklee.com/img/Cham.png")
                        .link(new Link()
                            .mobile("https://www.instagram.com/official.chamisul/?hl=ko")
                            .pc("https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0")))
                    .profile(new Profile()
                             .imageUrl("http://kimshinparklee.com/img/queenIU.jpg")
                             .nickname("iu 포스터"))
                    .button(new Button()
                             .action(Action.WEBLINK)
                             .label("장만월")
                             .webLinkUrl("https://namu.wiki/w/%EC%9E%A5%EB%A7%8C%EC%9B%94"))
                    .button(new Button()
                            .action(Action.SHARE)
                            .label("공유하기"))
                    );     
        response.addSkill(new ListCard()
                        .header(new ListItem()
                                .title("IU 모음"))                 
                        .item(new ListItem()
                                .title("장만월")
                                .description("호텔델루나")
                                .imageUrl("http://kimshinparklee.com/img/ManWol.jpg")
                                .link(new Link()
                                        .web("https://namu.wiki/w/%EC%9E%A5%EB%A7%8C%EC%9B%94")))
                        .item(new ListItem()
                                .title("아이유")
                                .description("참이슬 화보")
                                .imageUrl("http://kimshinparklee.com/img/queenIU.jpg")
                                .link(new Link()
                                        .web("https://www.instagram.com/official.chamisul/?hl=ko")))
                        .button(new Button()
                                .action(Action.SHARE)
                                .label("공유하기"))
                        );
        
        response.addSkill(new ItemCard()
                        .thumbnail(new ItemThumbnail()
                                .imageUrl("http://kimshinparklee.com/img/queenIU.jpg")
                                .Ratio(ImageRatio.ONETOONE))                 
                        .profile(new ItemProfile()
                                .imageUrl("http://kimshinparklee.com/img/ManWol.jpg")
                                .title("장만월"))
                        .imageTitle(new ImageTitle()
                                    .title("IU")
                                    .description("이지은")
                                    .imageUrl("http://kimshinparklee.com/img/ManWol.jpg"))
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
        
        */
        response.addSkill(new Carousel()
                        .type(CarouselType.BASIC)
                        .header(new CarouselHeader()
                                  .title("IU")
                                  .description("IU들")
                                  .thumbnail(new Thumbnail()
                                             .imageUrl("http://kimshinparklee.com/img/ManWol.jpg")))
                        .item(new BasicCard()
                                .title("이지은")
                                .description("본체")
                                .thumbnail(new Thumbnail()
                                           .imageUrl("http://kimshinparklee.com/img/queenIU.jpg"))
                                .button(new Button()
                                        .action(Action.WEBLINK)
                                        .label("보기")
                                        .webLinkUrl("https://namu.wiki/w/%EC%95%84%EC%9D%B4%EC%9C%A0")))                    
                        .item(new BasicCard()
                                .title("이지금")
                                .description("부캐")
                                .thumbnail(new Thumbnail()
                                        .imageUrl("http://kimshinparklee.com/img/leejigold.jpg"))
                                .button(new Button()
                                .action(Action.WEBLINK)
                                .label("보기")
                                        .webLinkUrl("https://namu.wiki/w/%EC%9D%B4%EC%A7%80%EA%B8%88"))) 
                        .item(new BasicCard()
                                .title("이지동")
                                .description("부부캐")
                                .thumbnail(new Thumbnail()
                                                .imageUrl("http://kimshinparklee.com/img/leejidong.jpg"))
                                .button(new Button()
                                        .action(Action.WEBLINK)
                                        .label("보기")
                                        .webLinkUrl("https://namu.wiki/w/%EC%9D%B4%EC%A7%80%EB%8F%99"))) 
                        );
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

        response.addContext(new ContextValue()
                        .name("speedInfo")
                        .lifeSpan(3));   
    
        resp.setContentType("application/json; charset=UTF-8");    
        

        PrintWriter out = resp.getWriter();
        out.print(response.build());
        out.flush();   
    }

    public static String getBody(HttpServletRequest request) throws IOException {
 
        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
 
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
 
        body = stringBuilder.toString();
        return body;
    }

}