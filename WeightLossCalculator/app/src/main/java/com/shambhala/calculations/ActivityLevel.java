package com.shambhala.calculations;

public enum ActivityLevel {
    SEDENTARY(1.54),
    ACTIVE(1.76),
    VIGOROUS(2.25);

    private double activityLevel;

    ActivityLevel(double v){
        this.activityLevel = v;
    }

    public double getActivityLevel(){
        return this.activityLevel;
    }
}
