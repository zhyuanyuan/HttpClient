package com.servlet;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lenovo on 2016/4/9.
 */
@WebServlet("/testServlet.do")
public class TestServletDemo extends HttpServlet {

    private String url="http://localhost:80/webproject/FirstServletDemo";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        GetMethod getMethod = new GetMethod(this.url);
//        getMethod.setRequestHeader("accept","application/josn;");
        HttpClient httpClient = new HttpClient();
        int satus=httpClient.executeMethod(getMethod);
        if(satus == 200){
           String mes= getMethod.getResponseBodyAsString();

            System.out.println(mes);
            PrintWriter print = resp.getWriter();
            print.print(mes);
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        resp.setHeader("content-type", "text/plain;charset=utf-8");
        String username=req.getParameter("username");
        String userpwd=req.getParameter("userpwd");
        PostMethod postMethod =new PostMethod(this.url);
        postMethod.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        postMethod.setRequestHeader("accept","text/plain;charset=utf-8");
        postMethod.addParameter("name",username);
        postMethod.addParameter("pwd",userpwd);
        HttpClient httpClient = new HttpClient();
        int status= httpClient.executeMethod(postMethod);
        if(status == 200){
           String mes= postMethod.getResponseBodyAsString();
            System.out.println(mes);
            PrintWriter print = resp.getWriter();
            print.print(mes);
        }
    }
}
