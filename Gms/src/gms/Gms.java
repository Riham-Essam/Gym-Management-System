package gms;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import static gms.Administrator.trainer_arr;
import static gms.Administrator.class_arr;
import static gms.Employee.Member_arr;
import static gms.Class.members_classes;
import static gms.Trainer.Member_arr_trainer;
import static gms.Trainer.class_arr_trainer;
/**
 *
 * @author Asunet
 */

public class Gms {

    public static void main(String[] args) throws IOException {

        File f1= new File("Trainer arr");
        if(f1.exists())
        {         
        BufferedReader bufReader = new BufferedReader(new FileReader("Trainer arr"));
     
        String line = bufReader.readLine();
        
        while (line != null)
        {                   
           String[] ss=line.split(":");
           Trainer trainerobj;
           trainerobj = new Trainer(ss[0],Integer.valueOf(ss[5]),ss[1],ss[3],Integer.valueOf(ss[4]),ss[2]);
                   trainer_arr.add(trainerobj);

           line = bufReader.readLine();
                    
        }
        bufReader.close();
        }
        /////////////////
          File f2= new File("class arr");
        if(f2.exists())
        {         
        BufferedReader bufReader = new BufferedReader(new FileReader("class arr"));
     
        String line = bufReader.readLine();
        
        while (line != null)
        {                   
            
           String[] ss=line.split(":");
           Class classrobj;
           classrobj = new Class(ss[0],ss[2],ss[1],ss[3],Integer.valueOf(ss[4]));
            class_arr.add(classrobj);

           line = bufReader.readLine();
                    
        }
        bufReader.close();
        }
        ///////////////
          File f3= new File("member arr");
        if(f3.exists())
        {         
        BufferedReader bufReader = new BufferedReader(new FileReader("member arr"));
     
        String line = bufReader.readLine();
        
        while (line != null)
        {                   

           String[] ss=line.split(":");
           Member memberobj;
           memberobj = new Member(Integer.valueOf(ss[5]),ss[1],ss[3],ss[0],ss[2],Integer.valueOf(ss[4]));
            Member_arr.add(memberobj);

           line = bufReader.readLine();
                    
        }
        bufReader.close();
        }
        /////////////
         File f4= new File("member_class arr");
        if(f4.exists())
        {         
        BufferedReader bufReader = new BufferedReader(new FileReader("member_class arr"));
     
        String line = bufReader.readLine();
        
        while (line != null)
        {                   

           String[] ss=line.split(":");
           Member memberobj;
           memberobj = new Member(Integer.valueOf(ss[5]),ss[1],ss[3],ss[0],ss[2],Integer.valueOf(ss[4]));
            members_classes.add(memberobj);

           line = bufReader.readLine();
                    
        }
        bufReader.close();
        }
        ////////////////
          File f5= new File("member_trainer arr");
        if(f5.exists())
        {         
        BufferedReader bufReader = new BufferedReader(new FileReader("member_trainer arr"));
     
        String line = bufReader.readLine();
        
        while (line != null)
        {                   

           String[] ss=line.split(":");
           Member memberobj;
           memberobj = new Member(Integer.valueOf(ss[5]),ss[1],ss[3],ss[0],ss[2],Integer.valueOf(ss[4]));
Member_arr_trainer.add(memberobj);
           line = bufReader.readLine();
                    
        }
        bufReader.close();
        }
        /////////////
         File f6= new File("class_trainer arr");
        if(f6.exists())
        {         
        BufferedReader bufReader = new BufferedReader(new FileReader("class_trainer arr"));
     
        String line = bufReader.readLine();
        
        while (line != null)
        {                   

           String[] ss=line.split(":");
           Class classrobj;
           classrobj = new Class(ss[0],ss[2],ss[1],ss[3],Integer.valueOf(ss[4]));
class_arr_trainer.add(classrobj);

           line = bufReader.readLine();
                    
        }
        bufReader.close();
        }
        
        
        Scanner in = new Scanner(System.in);
        String x;
        int choice;

        while (true) {
            System.out.println("Please choose your option:(1/Administrator - 2/Employee - 3/Exit and save)");
            System.out.println("Enter your option");
            int option = in.nextInt();
            switch (option) {

                case 1: {
                    System.out.println("Enter your mail please");
                    String E_mail = in.next();
                    System.out.println("Enter your password please");
                    String a_password = in.next();
                    Administrator admin = new Administrator(E_mail, a_password);
                    admin.check(E_mail, a_password);
                    do {
                        System.out.println("Please enter your choice: (1/Add - 2/Edit - 3/Delete - 4/View - 5/Addclass - 6/Edit class - 7/Delete Class - 8/Assign)");
                        choice = in.nextInt();
                        switch (choice) {
                            case 1: {

                                admin.add();
                                break;
                            }
                            case 2: {

                                System.out.println("Enter id to search");
                                admin.edit();

                                break;

                            }
                            case 3: {

                                System.out.println("Enter name to delete");
                                admin.delete();

                                break;

                            }
                            case 4: {
                                int your_choice;
                                System.out.println("Enter your choice: (1/View in class - 2/View membership - 3/View all)");
                                your_choice = in.nextInt();
                                switch (your_choice) {
                                    case 1: {
                                        admin.view_members_in_specific_class();
                                        break;
                                    }
                                    case 2: {
                                        admin.view_membership_type();
                                        break;
                                    }
                                    case 3: {
                                        admin.view_all_members();
                                        break;

                                    }

                                }
                                break;
                            }
                            case 5: {
                                admin.addclass();
                                break;
                            }
                            case 6: {
                                admin.editclass();
                                break;
                            }
                            case 7: {

                                admin.deleteclass();
                                break;
                            }
                            case 8: {
                                int your_choice;
                                System.out.println("Enter your choice: (1/Assign trainer to class - 2/Assign trainer to member)");
                                your_choice = in.nextInt();
                                switch (your_choice) {
                                    case 1: {
                                        admin.assign_trainer_to_class();
                                        break;
                                    }
                                    case 2: {
                                        admin.assign_trainer_to_member();
                                        break;
                                    }

                                }
                                break;

                            }
                        }
                        System.out.println("Do you want to continue ?");
                        x = in.next();

                    } while (x.equals("y"));

                    break;
                }

                case 2: {
                    System.out.println("Enter your mail please");
                    String E_mail = in.next();
                    System.out.println("Enter your password please");
                    String a_password = in.next();

                    Employee emp = new Employee(E_mail, a_password);
                    emp.check(E_mail, a_password);
                    do {
                        System.out.println("Please enter your choice: (1/Add - 2/Edit - 3/Delete - 4/View - 5/Add in class - 6/Delete_from_class)");
                        choice = in.nextInt();
                        switch (choice) {
                            case 1: {

                                emp.add();
                                break;
                            }
                            case 2: {
                                emp.edit();
                                break;
                            }
                            case 3: {
                                System.out.println("Enter name to delete");
                                emp.delete();
                                break;
                            }
                            case 4: {
                                int your_choice;
                                System.out.println("Enter your choice: (1/View in class - 2/View membership - 3/View all)");
                                your_choice = in.nextInt();
                                switch (your_choice) {
                                    case 1: {
                                        emp.view_members_in_specific_class();
                                        break;
                                    }
                                    case 2: {
                                        emp.view_membership_type();
                                        break;
                                    }
                                    case 3: {
                                        emp.view_all_members();
                                        break;

                                    }
                                }
                                break;

                            }
                            case 5: {

                                emp.addMember_in_class();
                                break;

                            }
                            case 6: {

                                emp.delete_member_from_class();
                                break;

                            }

                        }
                        System.out.println("Do you want to continue ?");
                        x = in.next();

                    } while (x.equals("y"));
                    break;
                }
                case 3: {

         /*edit it with >= */  if (trainer_arr.size() >= 0) {
                        File f22 = new File("Trainer arr");
                        f22.createNewFile();
                        FileWriter fm = new FileWriter(f22);
                        PrintWriter pm = new PrintWriter(fm);

                        for (int i = 0; i < trainer_arr.size(); i++) {
                            String mem = trainer_arr.get(i).getName() + ":" + trainer_arr.get(i).getGender() + ":" + trainer_arr.get(i).getClass_name()
                                    + ":" + trainer_arr.get(i).getPhone_number() + ":" + trainer_arr.get(i).getAge() + ":" + trainer_arr.get(i).getId();

                            pm.println(mem);
                        }
                        fm.close();
                        pm.close();

                    }
                    if (class_arr.size() >= 0) {
                        File f22 = new File("class arr");
                        f22.createNewFile();
                        FileWriter fm = new FileWriter(f22);
                        PrintWriter pm = new PrintWriter(fm);

                        for (int i = 0; i < class_arr.size(); i++) {
                            String mem = class_arr.get(i).getClass_name() + ":" + class_arr.get(i).getDay() + ":" + class_arr.get(i).getTime()
                                    + ":" + class_arr.get(i).getTrainer() + ":" + class_arr.get(i).Number;

                            pm.println(mem);
                        }
                        fm.close();
                        pm.close();

                    }
                    if (Member_arr.size() >= 0) {
                        File f22 = new File("member arr");
                        f22.createNewFile();
                        FileWriter fm = new FileWriter(f22);
                        PrintWriter pm = new PrintWriter(fm);

                        for (int i = 0; i < Member_arr.size(); i++) {
                            String mem = Member_arr.get(i).getClasses() + ":" + Member_arr.get(i).getName() + ":" + Member_arr.get(i).getTrainer()
                                    + ":" + Member_arr.get(i).getType_of_membership() + ":" + Member_arr.get(i).getAge() + ":" + Member_arr.get(i).getId();

                            pm.println(mem);
                        }
                        fm.close();
                        pm.close();

                    }
                    if (members_classes.size() >= 0) {
                        File f22 = new File("member_class arr");
                        f22.createNewFile();
                        FileWriter fm = new FileWriter(f22);
                        PrintWriter pm = new PrintWriter(fm);

                        for (int i = 0; i < members_classes.size(); i++) {
                            String mem = members_classes.get(i).getClasses() + ":" + members_classes.get(i).getName() + ":" + members_classes.get(i).getTrainer()
                                    + ":" + members_classes.get(i).getType_of_membership() + ":" + members_classes.get(i).getAge() + ":" + members_classes.get(i).getId();

                            pm.println(mem);
                        }
                        fm.close();
                        pm.close();

                    }
                   if (Member_arr_trainer.size() >= 0) {
                        File f22 = new File("member_trainer arr");
                        f22.createNewFile();
                        FileWriter fm = new FileWriter(f22);
                        PrintWriter pm = new PrintWriter(fm);

                        for (int i = 0; i < Member_arr_trainer.size(); i++) {
                             String mem = Member_arr_trainer.get(i).getClasses() + ":" + Member_arr_trainer.get(i).getName() + ":" + Member_arr_trainer.get(i).getTrainer()
                                    + ":" + Member_arr_trainer.get(i).getType_of_membership() + ":" + Member_arr_trainer.get(i).getAge() + ":" + Member_arr_trainer.get(i).getId();

                            pm.println(mem);
                        }
                        fm.close();
                        pm.close();

                   }
                    
                        if (class_arr_trainer.size() >= 0) {
                        File f22 = new File("class_trainer arr");
                        f22.createNewFile();
                        FileWriter fm = new FileWriter(f22);
                        PrintWriter pm = new PrintWriter(fm);

                        for (int i = 0; i < class_arr_trainer.size(); i++) {
                             String mem = class_arr_trainer.get(i).getClass_name() + ":" + class_arr_trainer.get(i).getDay() + ":" + class_arr_trainer.get(i).getTime()
                                    + ":" + class_arr_trainer.get(i).getTrainer() + ":" + class_arr_trainer.get(i).Number;

                            pm.println(mem);
                        }
                        fm.close();
                        pm.close();

                    }
                    System.exit(0);
                    break;
                }

            }
        }
    }
}
