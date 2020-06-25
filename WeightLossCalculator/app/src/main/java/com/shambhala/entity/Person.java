package com.shambhala.entity;

public class Person {
    private int age; //in years
    private String sex;
    private double weight; //in kilograms
    private double height; //in centimetres

    public Person(int age, String sex, double weight, double height){
        this.age = age;
        this.sex = sex.toUpperCase();
        this.weight = weight;
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}
