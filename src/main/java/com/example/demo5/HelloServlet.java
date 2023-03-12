package com.example.demo5;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import com.example.demo5.mart5token.AccountRepository;
import com.example.demo5.mart5token.Brand;
//import com.example.prodem.model.Account;
//import com.example.prodem.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/car")



public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }
//    public void init() {
//        message = "Hello World!";
//    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
       // MyJsonData jsonData = new MyJsonData("Errorsd", "World123");
        String accId = request.getParameter("accId");
        System.out.println(accId);

        Integer id = Integer.valueOf(accId);
        AccountRepository accountRepository = new AccountRepository();
       // Account accountById = accountRepository.getAccountById(id);

        // Jackson Object Mapper kullanarak JSON nesnesini stringe dönüştürün
        ObjectMapper objectMapper = new ObjectMapper();
      //  String jsonStr = objectMapper.writeValueAsString(jsonData);
        /*{
        "message": "hello",
        "name": "world"
        String jsonStr = objectMapper.writeValueAsString(accountById);

        }*/

        // Response content type ve status kodunu ayarlayın
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

        // JSON stringi response body'sine yazın
      //  response.getWriter().write(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        // Request body'sini oku ve JSON stringini al
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
      //  @ @ -47, 15 + 46, 15 @@protected void doPost (HttpServletRequest request, HttpServletResponse response)
        String jsonStr = sb.toString();
        System.out.println(jsonStr);

        // JSON stringini Java nesnesine dönüştür
        ObjectMapper objectMapper = new ObjectMapper();
      //  MyJsonData jsonData = objectMapper.readValue(jsonStr, MyJsonData.class);

        // Java nesnesini kullanarak işlem yap
      //  String message = jsonData.getMessage();
      //  String name = jsonData.getName();
     //   ObjectMapper objectMapper = new ObjectMapper();
     //   Brand account = objectMapper.readValue(jsonStr, Account.class);

        response.getWriter().write("Ugurla elave olunmusdur.");
        AccountRepository accountRepository = new AccountRepository();
      //  Brand brandInDb = accountRepository.saveAccount(account);
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
      //  response.getWriter().write(objectMapper.writeValueAsString(brandInDb));

    }
}
