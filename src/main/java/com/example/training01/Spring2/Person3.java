package com.example.training01.Spring2;

public class Person3 {

    private String name;
    private Integer id;

    public Person3() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
