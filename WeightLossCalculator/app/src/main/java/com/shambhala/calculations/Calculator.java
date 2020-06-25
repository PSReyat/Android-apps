package com.shambhala.calculations;

import com.shambhala.entity.Person;

public class Calculator {
    private Person person;
    private double activityLevel;
    private double BMR;

    public Calculator(Person person, String level){
        this.person = person;
        this.activityLevel = ActivityLevel.valueOf(level.toUpperCase()).getActivityLevel();
        this.BMR = (10 * this.person.getWeight()) + (6.25 * this.person.getHeight())
                - (5 * this.person.getAge());
    }

    public Calculator(Person person){
        this.person = person;
        this.activityLevel = 0;
        this.BMR = (10 * this.person.getWeight()) + (6.25 * this.person.getHeight())
                - (5 * this.person.getAge());
    }

    public double getBMR(){
        if(this.person.getSex().equals("MALE")){
            this.BMR += 5;
        }else{
            this.BMR -= 161;
        }

        if(this.activityLevel == 0){
            return this.BMR;
        }else{
            return this.BMR * this.activityLevel;
        }
    }


}
