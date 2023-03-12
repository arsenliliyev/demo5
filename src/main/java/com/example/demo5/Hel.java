package com.example.demo5;

import com.example.demo5.hiber.Dao;
import com.example.demo5.mart5token.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hel")



public class Hel extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Dao dao=new Dao();

        System.out.println(dao.findById(11));
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//
//        // Request body'sini oku ve JSON stringini al
//        BufferedReader reader = request.getReader();
//        StringBuilder sb = new StringBuilder();
//      //  @ @ -47, 15 + 46, 15 @@protected void doPost (HttpServletRequest request, HttpServletResponse response)
//        String jsonStr = sb.toString();
//        System.out.println(jsonStr);
//
//        // JSON stringini Java nesnesine dönüştür
//        ObjectMapper objectMapper = new ObjectMapper();
//      //  MyJsonData jsonData = objectMapper.readValue(jsonStr, MyJsonData.class);
//
//        // Java nesnesini kullanarak işlem yap
//      //  String message = jsonData.getMessage();
//      //  String name = jsonData.getName();
//     //   ObjectMapper objectMapper = new ObjectMapper();
//     //   Brand account = objectMapper.readValue(jsonStr, Account.class);
//
//        response.getWriter().write("Ugurla elave olunmusdur.");
//        AccountRepository accountRepository = new AccountRepository();
//      //  Brand brandInDb = accountRepository.saveAccount(account);
//        response.setContentType("application/json");
//        response.setStatus(HttpServletResponse.SC_OK);
//      //  response.getWriter().write(objectMapper.writeValueAsString(brandInDb));
//
//    }
}
