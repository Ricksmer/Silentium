package Display;

import java.util.*;

public class MainMenuFunctionalities {

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
                System.out.println("Input Mismatch...");
                sc.next();
            }
        }
        return option;
    }

    public void displayMenu(){
        System.out.println("=======================================================================================================================");
        System.out.println("                                                        MAIN MENU                                                        ");
        System.out.println("=======================================================================================================================");
        System.out.println("\t1: Start Game");
        System.out.println("\t2: Story");
        System.out.println("\t3: Credits");
        System.out.println("\t4: How to Play");
        System.out.println("\t5: Exit");
        System.out.println("=======================================================================================================================\n");
    }

    public String credits(){
        return "\n\n=========================================CREDITS=========================================\n"
                + "Silentium is a project developed by the \"Team Balanghoy\" Group that is composed\n"
                + "of 2nd year BSIT students from CIT-U (Cebu Institute of Technology University).\n"
                + "Silentium serves as a final submission for the final project assigned by \n"
                + "Kenn Migan Vincent Gumonan under the subject code CSIT227 titled \n\"Object Oriented Programming 1\"...\n\n" + "Members:\n"
                + "Ricksmer Cabatingan - Project Manager\n" + "Andrew Sangasina - Project Manager\n"+ "Yohan Abarquez - Member\n"
                + "Ryza Janell Mutya - Memeber\n"+ "Precious Ann Tolentino - Member"
                + "\n=========================================================================================\n\n";
    }
}
