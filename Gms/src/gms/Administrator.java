package gms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Asunet
 *
 */
public class Administrator extends Users {

    Scanner in = new Scanner(System.in);
    String admin_email_1 = "rawan@gmail.com";
    String admin_password_1 = "12345";
    String admin_email_2 = "rony@gmail.com";
    String admin_password_2 = "245";
    public static ArrayList<Class> class_arr = new ArrayList<Class>();
    public static ArrayList<Trainer> trainer_arr = new ArrayList<>();

    public Administrator(String email, String password) {
        super(email, password);

    }

    public boolean check(String mail, String pass) {

        while (true) {
            if (mail.equals(admin_email_1) && pass.equals(admin_password_1)) {

                System.out.println("Correct!");

                return true;
            } else if (mail.equals(admin_email_2) && pass.equals(admin_password_2)) {
                System.out.println("Correct!");

                return true;
            } else {
                System.out.println("Incorrect ,please enter your password and mail again");
                System.out.println("Enter your mail please");
                String admin_email = in.next();
                System.out.println("Enter your password please");
                String admin_password = in.next();
                this.check(admin_email, admin_password);

                return false;
            }

        }
    }

    @Override
    public int add() {
        try {
            System.out.println("Enter trainer's name");
            String t_name = in.next();
            System.out.println("Enter trainer's id");
            int id = in.nextInt();
            System.out.println("Enter trainer's gender");
            String t_gender = in.next();
            System.out.println("Enter trainer's age");
            int t_age = in.nextInt();
            System.out.println("Enter trainer's phone_number");
            String t_phone = in.next();
            Trainer t = new Trainer(t_name, id, t_gender, t_phone, t_age);

            trainer_arr.add(t);
            System.out.println("Trainer is added");
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public void edit() {
        int id_search = in.nextInt();
        int choice;
        for (int i = 0; i < trainer_arr.size(); i++) {

            if (trainer_arr.get(i).getId() == id_search) {
                System.out.println("Please enter your choice: (1/Edit id - 2/Editphone _number)");
                choice = in.nextInt();
                if (choice == 1) {
                    System.out.println("Enter your new Id:");
                    int id_new = in.nextInt();
                    trainer_arr.get(i).setId(id_new);
                }
                if (choice == 2) {
                    System.out.println("Enter your new phone:");
                    String new_phone = in.next();
                    trainer_arr.get(i).setPhone_number(new_phone);

                }
                System.out.println("Trainer's info is edited");

            }
        }
    }

    @Override
    public void delete() {

        String tname_delete = in.next();

        for (int i = 0; i < trainer_arr.size(); i++) {
            if (trainer_arr.get(i).getName().equals(tname_delete)) {
                trainer_arr.remove(i);

                for (int k = 0; k < Trainer.Member_arr_trainer.size(); k++) {
                    if (Trainer.Member_arr_trainer.get(k).getTrainer().contains(tname_delete)) {

                        Trainer.Member_arr_trainer.remove(k);

                    }
                }

                for (int l = 0; l < Trainer.class_arr_trainer.size(); l++) {
                    if (Trainer.class_arr_trainer.get(l).getTrainer().contains(tname_delete)) {

                        Trainer.class_arr_trainer.remove(l);

                    }
                }
                for (int m = 0; m < class_arr.size(); m++) {
                    if(class_arr.get(m).getTrainer() != null)
                    {
                         if (class_arr.get(m).getTrainer().contains(tname_delete)) {
                        class_arr.get(m).setTrainer(null);
                    }
                    }
                   

                }

                for (int j = 0; j < Employee.Member_arr.size(); j++) {
                    if ((Employee.Member_arr.get(j).getTrainer().contains(tname_delete))) {

                        Employee.Member_arr.get(j).setTrainer("");

                    }
                }

            }

        }
        System.out.println("trainer is deleted");
    }

    public void assign_trainer_to_class() {

        System.out.println("Enter trainer's name you want to add to a class ");
        String trainer_name = in.next();
        for (int i = 0; i < trainer_arr.size(); i++) {
            if (trainer_arr.get(i).getName().equals(trainer_name)) {
                System.out.println("Enter class name you want to add to");
                String class_name = in.next();
                for (int j = 0; j < class_arr.size(); j++) {

                    if (class_arr.get(j).getClass_name().equals(class_name)) {
                        if (class_arr.get(j).getTrainer() == null) {
                            if (trainer_arr.get(i).getClass_name() == null) {

                                class_arr.get(j).setTrainer(trainer_name);

                                trainer_arr.get(i).setClass_name(class_name);
                                Trainer.class_arr_trainer.add(class_arr.get(j));
                                System.out.println("Trainer is assigned to a class");

                                break;
                            } else {
                                if (trainer_arr.get(i).getClass_name() != null) {

                                    for (int k = 0; k < Trainer.class_arr_trainer.size(); k++) {

                                        if (Trainer.class_arr_trainer.get(k).getDay().equals(class_arr.get(j).getDay())
                                                && Trainer.class_arr_trainer.get(k).getTime().equals(class_arr.get(j).getTime())) {
                                            System.out.println("Invalid");

                                            break;
                                        } else {
                                            class_arr.get(j).setTrainer(trainer_name);
                                            trainer_arr.get(i).setClass_name(class_name);

                                            Trainer.class_arr_trainer.add(class_arr.get(j));
                                            System.out.println("Trainer is assigned to a class");

                                            break;
                                        }

                                    }

                                }
                            }
                        } else {
                            System.out.println("This class is already has a trainer");
                            break;
                        }

                    }

                }
                break;
            }

        }

    }

    public void addclass() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter class name");
        String class_name = input.next();
        System.out.println("Enter class time");
        String time = input.next();
        System.out.println("Enter class day");
        String day = input.next();
        System.out.println("Enter number of members ");
        int number = in.nextInt();
        class_arr.add(new Class(class_name, time, day, number));
        System.out.println("Class is added");

    }

    public void editclass() {
        System.out.println("Enter name of class to update");
        String update_class = in.next();
        int choice;
        for (int i = 0; i < class_arr.size(); i++) {
            if (class_arr.get(i).getClass_name().equals(update_class)) {

                System.out.println("Please enter your choice: (1/Edit day - 2/Edit time )");
                choice = in.nextInt();

                if (choice == 1) {
                    System.out.println("Enter your new class day:");
                    String new_day = in.next();
                    class_arr.get(i).setDay(new_day);
                }
                if (choice == 2) {
                    System.out.println("Enter your new class time:");
                    String new_time = in.next();
                    class_arr.get(i).setTime(new_time);
                }
                System.out.println("Class is edited");
            }
        }
    }

    public void deleteclass() {
        System.out.println("Enter class you want to delete");
        String class_delete = in.next();
        for (int i = 0; i < class_arr.size(); i++) {
            if (class_delete.equals(class_arr.get(i).getClass_name())) {
                class_arr.remove(i);

                for (int k = 0; k < Class.members_classes.size(); k++) {
                    if (Class.members_classes.get(k).getClasses() != null) {
                        if (Class.members_classes.get(k).getClasses().equals(class_delete)) {

                            Class.members_classes.remove(k);
                        }
                    }
                }
                for (int j = 0; j < Employee.Member_arr.size(); j++) {
                    if (Employee.Member_arr.get(j).getClasses() != null) {
                        if (Employee.Member_arr.get(j).getClasses().equals(class_delete)) {

                            Employee.Member_arr.get(j).setClasses("");
                        }
                    }
                }
                for(int l=0;l< trainer_arr.size();l++)
                {
                    if(trainer_arr.get(l).getClass_name() !=null)
                    {
                          if(trainer_arr.get(l).getClass_name().contains(class_delete))
                    {
                        trainer_arr.get(l).setClass_name("");
                    }
                    }
                  
                }
            }
        }
        System.out.println("class is deleted");
    }

    public void assign_trainer_to_member() {

        System.out.println("Enter trainer's name you want to add to a member ");
        String trainer_name = in.next();
        for (int i = 0; i < trainer_arr.size(); i++) {
            if (trainer_arr.get(i).getName().equals(trainer_name)) {
                System.out.println("Enter id you want to add to");
                int member_id = in.nextInt();
                for (int j = 0; j < Employee.Member_arr.size(); j++) {

                    if (Employee.Member_arr.get(j).getId() == member_id) {

                        if ((Employee.Member_arr.get(j).getTrainer() == null) || Employee.Member_arr.get(j).getTrainer().equals("")) {

                            Employee.Member_arr.get(j).setTrainer(trainer_name);
                            Trainer.Member_arr_trainer.add(Employee.Member_arr.get(j));
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Trainer is assigned to a member");
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
        for (int i = 0; i < Employee.Member_arr.size(); i++) {
            if (Employee.Member_arr.get(i).getType_of_membership().equals(member)) {
                Employee.Member_arr.get(i).displayinfo();
            }
        }
    }

    @Override
    public void view_all_members() {
        for (int i = 0; i < Employee.Member_arr.size(); i++) {
            Employee.Member_arr.get(i).displayinfo();
        }
    }

}
