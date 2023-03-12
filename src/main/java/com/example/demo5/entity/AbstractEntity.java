package com.example.demo5.entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    protected  int id;


    @Column(name ="crated_at")
    protected LocalDateTime createdAt;

    @Column(name ="update_at")
    protected LocalDateTime updateDate;


    @PrePersist
    protected  void createTime(){

        this.createdAt=LocalDateTime.now();
    }


    @PreUpdate
    protected  void updateTime(){

        this.updateDate=LocalDateTime.now();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
