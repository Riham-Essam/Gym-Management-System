package gms;

import java.util.ArrayList;

/**
 *
 * @author Asunet
 */
public class Trainer {

    private String name;
    private int id;
    private String gender;
    private String class_name;
    private String phone_number;
    private int age;

    public static ArrayList<Member> Member_arr_trainer = new ArrayList<>();
    public static ArrayList<Class> class_arr_trainer = new ArrayList<>();

    public Trainer(String name, int id, String gender, String phone_number, int age) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.phone_number = phone_number;
        this.age = age;
    }
    
     public Trainer(String name, int id, String gender, String phone_number, int age, String class_name) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.phone_number = phone_number;
        this.age = age;
        this.class_name = class_name;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public int getAge() {
        return age;
    }

}
