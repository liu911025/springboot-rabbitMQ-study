package com.spring.boot.entry;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/30.
 */
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private short age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
