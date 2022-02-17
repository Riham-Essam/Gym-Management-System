/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gms;

/**
 *
 * @author Asunet
 */
public class Member {

    private int id;
    private String name;
    private String type_of_membership;
    private String classes;
    private String trainer;
    private int age;

    public Member(int id, String name, String membership, int age) {
        this.id = id;
        this.name = name;
        this.type_of_membership = membership;
        this.age = age;
    }

    public Member(int id, String name, String type_of_membership, String classes, String trainer, int age) {
        this.id = id;
        this.name = name;
        this.type_of_membership = type_of_membership;
        this.classes = classes;
        this.trainer = trainer;
        this.age = age;
    }

    public String getType_of_membership() {
        return type_of_membership;
    }

    public void setType_of_membership(String type_of_membership) {
        this.type_of_membership = type_of_membership;
    }

    public int getId() {
        return id;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void displayinfo() {
        System.out.println("Name is: " + name);
        System.out.println("Id is: " + id);
        System.out.println("Membership type: " + type_of_membership);
        System.out.println("Trainer's name: " + trainer);
        System.out.println("age is : " + age);
        System.out.println("Class is: " + classes);
    }

}
