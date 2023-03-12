package com.example.demo5.hiber;

public class Main {
    public static void main(String[] args) {
        Dao dao=new Dao();

        System.out.println(dao.findById(1));
    }
}
