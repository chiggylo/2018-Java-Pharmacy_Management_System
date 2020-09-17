package oodj_assignment_2018;

import java.util.Scanner;


/*
   @author Chi Gou Lo
 */

public abstract class User {
    public abstract String idReturn();
    
    public abstract String passwordReturn();
    
    public abstract String nameReturn();
    
    public abstract String roleReturn();
    
    public abstract void displayInfo();
    
    public abstract void action();
    
    public void pressEnter(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nPress enter to continue...");
        
        String reply = "notempty";
        while(true){
            reply = input.nextLine();
            if(reply.equals("")){
                break;
            }
        }
    }
}
