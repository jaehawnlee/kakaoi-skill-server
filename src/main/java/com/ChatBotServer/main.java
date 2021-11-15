package com.ChatBotServer;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ChatBotServer.SkillFunciton.Sample.Example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;

import lombok.extern.slf4j.*;

@Slf4j
@WebServlet("/")
public class main  extends HttpServlet {
    int test = 0;
    int initCount = 0;
    ServletRequest req;
    String strLog;
    Map<String,String> urlInfo;

    @Override
    public void init() throws ServletException {
        // Initialization code...
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(URLInfo.class);
        ctx.refresh();
        urlInfo = ctx.getBean(URLInfo.class).getURL();
     }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println(strLog);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson parse = new GsonBuilder().setPrettyPrinting().create();
        strLog =  parse.toJson(getBody(req));
        resp.setContentType("application/json; charset=UTF-8");    
        PrintWriter out = resp.getWriter();

        Example exam = new Example(urlInfo);
        
        //simpleText
        exam.simpleText(); 

        //simpleImage
        //exam.simpleImage();

        //basicCard
        //exam.BasicCard();

        //basicCard with Forwardable
        //exam.BasicCardForwardable();

        //commerceCard
        exam.CommerceCard();

        //itemCard
        //exam.ItemCard();

        //listCard
        //exam.ListCard();

        //Carousel
        //exam.Carousel();

        
        // carousel with quickreplies
        //exam.Carousel();
       // exam.Quickreplies();
        

        out.print(exam.makeExam());

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