package Display;

import java.util.*;

public class MainMenu {

    public int selectOption(){
        Scanner sc = new Scanner(System.in);
        boolean isEnabled = true;
        int option = 0;

        while(isEnabled){
            try{
                System.out.print("Enter an option: ");
                option  = sc.nextInt();
                if(option <= 0 || option > 5){
                    System.out.println("Invalid Option!!!");
                }
                else{
                    isEnabled = false;
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid Option!!!");
                sc.next();
            }
        }
        return option;
    }

    public void displayMenu(){
        System.out.println("1: Start Game");
        System.out.println("2: Story");
        System.out.println("3: Credits");
        System.out.println("4: How to Play");
        System.out.println("5: Exit");
    }

    public String credits(){
        return "Silentium is a project developed by the \"Team Balanghoy\" Group that is composed\n"
                + "of 2nd year BSIT students from CIT-U (Cebu Institute of Technology University).\n"
                + "Silentium serves as a final submission for the final project assigned by Kenn Migan Vincent Gumonan\n"
                + "under the subject code CSIT227 titled \"Object Oriented Programming 1\"...\n\n" + "Members:\n"
                + "Ricksmer Cabatingan - Project Manager\n" + "Andrew Sangasina - Project Manager\n"+ "Yohan Abarquez - Member\n"
                + "Ryza Janell Mutya - Memeber\n"+ "Precious Ann Tolentino - Member";
    }
}
