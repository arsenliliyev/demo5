package com.example.demo5.hiber;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (schema = "cars", name = "brands")
public class Brand {


    @Id
    private int id;

    @Column(name = "name")
    private String name;

    public Brand(int id,String name){
        this.id=id;
        this.name=name;
    }

    public Brand() {

    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    public int getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
