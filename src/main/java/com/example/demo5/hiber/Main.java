package com.example.demo5.hiber;

import com.example.demo5.entity.Brand;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dao dao=new Dao();

        Brand brand= new Brand();
        brand.setName("Nese123");
        dao.saveBrand(brand);

        Thread.sleep(10000);
        brand.setId(2);
        brand.setName("345678jkdsfsd");
        dao.updateBrand(brand);


    }
}
