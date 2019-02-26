package com.example.demo;

public class Hoge {
    private int id;
    private String value;

    public Hoge() {
    }

    public Hoge(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Hoge{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
