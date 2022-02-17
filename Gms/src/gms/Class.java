/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gms;

import java.util.ArrayList;

/**
 *
 * @author Asunet
 */
public class Class {

    private String class_name;
    private String time;
    private String day;
    public int Number;
    private String trainer;
    public int number_of_members;
    public static ArrayList<Member> members_classes = new ArrayList<>();

    public Class(String class_name, String time, String day, String t, int Num_of_Mem) {

        this.class_name = class_name;
        this.time = time;
        this.day = day;
        this.trainer = t;
        this.Number = Num_of_Mem;
        number_of_members = Num_of_Mem;

    }

    public Class(String class_name, String time, String day, int Num_of_Members) {
        this.class_name = class_name;
        this.time = time;
        this.day = day;
        this.Number = Num_of_Members;
        number_of_members = Num_of_Members;

    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

}
