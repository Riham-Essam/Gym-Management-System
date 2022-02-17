/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gms;

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Asunet
 */
public class Employee extends Users {
    
    Scanner in = new Scanner(System.in);
    public static ArrayList<Member> Member_arr = new ArrayList<>();
    
    String emp_email_1 = "kholod1@gmail.com";
    String emp_password_1 = "12345";
    String emp_email_2 = "reham@gmail.com";
    String emp_password_2 = "2020";
    
    public Employee(String email, String password) {
        super(email, password);
        
    }
    
    public boolean check(String mail, String pass) {
        
        while (true) {
            if (mail.equals(emp_email_1) && pass.equals(emp_password_1)) {
                
                System.out.println("Correct!");
                return true;
            } else if (mail.equals(emp_email_2) && pass.equals(emp_password_2)) {
                System.out.println("Correct!");
                return true;
            } else {
                System.out.println("Incorrect ,please enter your password and mail again");
                System.out.println("Enter your mail please");
                String emp_email = in.next();
                System.out.println("Enter your password please");
                String emp_password = in.next();
                this.check(emp_email, emp_password);
                return false;
            }
        }
    }
    
    @Override
    public int add() {
        try {
            System.out.println("Enter member's name");
            String member_name = in.next();
            System.out.println("Enter member's id");
            int member_id = in.nextInt();
            System.out.println("Enter member's membership");
            String membership = in.next();
            System.out.println("Enter member's age");
            int member_age = in.nextInt();
            Member mmbr = new Member(member_id, member_name, membership, member_age);
            Member_arr.add(mmbr);
            System.out.println("Member is added");
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    @Override
    public void edit() {
        System.out.println("Enter id you want to edit");
        int id_search = in.nextInt();
        int choice;
        for (int i = 0; i < Member_arr.size(); i++) {
            
            if (Member_arr.get(i).getId() == id_search) {
                System.out.println("Please enter your choice: (1/Edit id - 2/type of membership )");
                choice = in.nextInt();
                if (choice == 1) {
                    System.out.println("Enter your new id:");
                    int new_id = in.nextInt();
                    Member_arr.get(i).setId(new_id);
                    if (Member_arr.get(i).getClasses() != null) {
                        for (int k = 0; k < Class.members_classes.size(); k++) {
                            if (Class.members_classes.get(k).getId() == id_search) {
                                Class.members_classes.get(k).setId(new_id);
                                
                            }
                        }
                    }
                    if (Member_arr.get(i).getTrainer() != null) {
                        for (int j = 0; j < Trainer.Member_arr_trainer.size(); j++) {
                            if (Trainer.Member_arr_trainer.get(j).getId() == id_search) {
                                Trainer.Member_arr_trainer.get(j).setId(new_id);
                                
                            }
                        }
                    }
                }
                if (choice == 2) {
                    System.out.println("Enter your new membership:");
                    String new_membership = in.next();
                    Member_arr.get(i).setType_of_membership(new_membership);
                    if (Member_arr.get(i).getClasses() != null) {
                        for (int k = 0; k < Class.members_classes.size(); k++) {
                            if (Class.members_classes.get(k).getId() == id_search) {
                                Class.members_classes.get(k).setType_of_membership(new_membership);
                                
                            }
                        }
                    }
                    if (Member_arr.get(i).getTrainer() != null) {
                        for (int j = 0; j < Trainer.Member_arr_trainer.size(); j++) {
                            if (Trainer.Member_arr_trainer.get(j).getId() == id_search) {
                                Trainer.Member_arr_trainer.get(j).setType_of_membership(new_membership);
                                
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Member's info is edited");
    }
    
    @Override
    public void delete() {
        String name_delete = in.next();
        for (int i = 0; i < Member_arr.size(); i++) {
            if ((Member_arr.get(i).getName()).equals(name_delete)) {
                Member_arr.remove(i);
            }
            
            for (int k = 0; k < Class.members_classes.size(); k++) {
                if (Class.members_classes.get(k).getName().contains(name_delete)) {
                    Class.members_classes.remove(k);
                    
                }
                
            }
            
            for (int j = 0; j < Trainer.Member_arr_trainer.size(); j++) {
                if (Trainer.Member_arr_trainer.get(i).getTrainer().contains(name_delete)) {
                    Trainer.Member_arr_trainer.remove(j);
                }
                
            }            
            
        }
        System.out.println("memeber is deleted");
    }
    
    public void addMember_in_class() {
        
        System.out.println("Enter class name you want to add member to");
        String class_name = in.next();
        
        for (int i = 0; i < Administrator.class_arr.size(); i++) {
            if (Administrator.class_arr.get(i).getClass_name().equals(class_name)) {
                
                if (Administrator.class_arr.get(i).Number != 0) {
                    System.out.println("Enter id you want to add to");
                    int member_id = in.nextInt();
                    for (int j = 0; j < Member_arr.size(); j++) {
                        
                        if (Member_arr.get(j).getId() == member_id) {
                            
                            Member_arr.get(j).setClasses(class_name);
                            Class.members_classes.add(Member_arr.get(j));
                            Administrator.class_arr.get(i).Number--;
                            System.out.println("Member is added");
                            break;
                            
                        }
                    }
                } else {
                    System.out.println("You can't add any members in this class");
                    
                }
            }
        }
    }
    
    public void delete_member_from_class() {
        System.out.println("Enter class name you want to delete member from");
        String class_name = in.next();
        for (int i = 0; i < Class.members_classes.size(); i++) {
            if (Class.members_classes.get(i).getClasses().equals(class_name)) {
                System.out.println("Enter id you want to delete ");
                int id_delete = in.nextInt();
                for (int j = 0; j < Member_arr.size(); j++) {
                    
                    if (Member_arr.get(j).getId() == id_delete) {
                        Member_arr.get(j).setClasses("");
                        
                    }
                }
                if (Class.members_classes.get(i).getId() == id_delete) {
                    Class.members_classes.remove(i);
                }
                for (int k = 0; k < Administrator.class_arr.size(); k++) {
                    if (Administrator.class_arr.get(k).getClass_name().equals(class_name)) {
                        Administrator.class_arr.get(k).Number++;
                    }
                }
                break;
            }
        }
        System.out.println("memeber is deleted");
    }
    
    @Override
    public void view_members_in_specific_class() {
        System.out.println("Enter class name you want to view member from");
        String class_name = in.next();
        for (int i = 0; i < Class.members_classes.size(); i++) {
            if (Class.members_classes.get(i).getClasses().equals(class_name)) {
                Class.members_classes.get(i).displayinfo();
            }
        }
    }
    
    @Override
    public void view_membership_type() {
        
        System.out.println("Enter membership type");
        String member = in.next();
        for (int i = 0; i < Member_arr.size(); i++) {
            if (Member_arr.get(i).getType_of_membership().equals(member)) {
                Member_arr.get(i).displayinfo();
            }
        }
    }
    
    @Override
    public void view_all_members() {
        for (int i = 0; i < Member_arr.size(); i++) {
            Member_arr.get(i).displayinfo();
        }
    }
    
}
