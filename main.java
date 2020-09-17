package oodj_assignment_2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Chi Gou Lo
 */
public class OODJ_Assignment_2018 {
    
    public static final String USERINFO = "E:\\OODJ_Assignment_2018\\userInfo.txt";
    public static Scanner input = new Scanner(System.in);
    
    public static String name;
    public static String id;
    public static String role;
    public static String password;    
    
    // naming for medicine cannot start with M as it is a trigger for unique ID
    public static void startup(){ // setting up system
        System.out.println("\nLoading Application...");
        
        while(!adminHere()){ // no admin in system
            System.out.println("\nApplication will shut down without admin's present. Do you wish to register an admin to the system? (Y/N)");
            char answer;
            do{
                answer = input.nextLine().toUpperCase().charAt(0);
                if(answer == 'N'){ // exiting application
                    System.out.println("\nApplication shutting down...");
                    System.exit(0);
                }
                else if(answer != 'Y'){ // error checking
                    System.out.println("\nInvalid Input."
                            + "\nDo you wish to register an admin to the system? (Y/N)");
                } 
            } while(answer !='Y');
            
            //creating admin and immediately login
            Admin newAdmin = new Admin();
            while (!newAdmin.regAdmin()){
                // do nothing extra
            }
            newAdmin.displayInfo();
            pressEnter();
            newAdmin.action();
        }
    }
    
    //press to continue;
    public static void pressEnter(){
        System.out.println("\nPress enter to continue...");
        
        String reply = "notempty";
        while(true){
            reply = input.nextLine();
            if(reply.equals("")){
                break;
            }
        }
        
        System.out.println("\nWhat do you wish to do?");
    }
    
    
    public static boolean adminHere(){
        String line;
        String parts[];
        
        System.out.println("\nSearching for admin...");
        try{ 
            FileReader fr = new FileReader(USERINFO);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) { // line by line for admin until end
                parts = line.split(";"); // separate information
                char check = parts[0].toUpperCase().charAt(0); // ID at array[0] and role identifiy at string[0]
                if(check == 'A'){ // found admin
                    System.out.println("\nAdmin present in the system. Login access enabled.");    
                    br.close(); 
                    return true;
                }
            }  
            br.close();
            
            // no admin
            System.out.println("\nAdmin absent in the system. Login access disabled."
                    + "\nAdmin present is needed to enable login access.");
        }
        // error exit application
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + USERINFO + "'"
                        + "\nClosing application"); 
                System.exit(0);
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + USERINFO + "'"
                        + "\nClosing application"); 
                System.exit(0);
        }
        
        return false;
    }
    
    
    public static String roleIdentifier(){ // login process to check for role for class creation
        System.out.println("\nPlease enter your ID...");
        OODJ_Assignment_2018.id = input.nextLine().toUpperCase();
        if(OODJ_Assignment_2018.id.equals("GUEST")){ // guest access break this method here
            return "GUEST";
        }
        else if(OODJ_Assignment_2018.id.equals("EXIT")){
            System.out.println("\nApplication closing...");
            System.exit(0);
        }
        
        System.out.println("\nPlease enter your password....");
        OODJ_Assignment_2018.password = input.nextLine();
                
        //check data
        String line;
        String[] parts;
        try{
            FileReader fr = new FileReader(USERINFO);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                if(parts[0].toUpperCase().equals(OODJ_Assignment_2018.id)){

                    if(parts[1].equals(OODJ_Assignment_2018.password)){ // case sensitive
                        OODJ_Assignment_2018.id = parts[0].toUpperCase();
                        OODJ_Assignment_2018.password = parts[1];
                        OODJ_Assignment_2018.name = parts[2].toUpperCase();
                        OODJ_Assignment_2018.role = parts[3].toUpperCase(); // becareful from pevious stuff did not have it
                        switch(parts[0].toUpperCase().charAt(0)){ // proceed to action if suceed
                            case 'A':
                                br.close();   
                                return "ADMIN"; 
                            case 'P':
                                br.close();   
                                return "PHARMACIST";
                            case 'C':     
                                br.close();   
                                return "CUSTOMER";
                            default:
                                break;
                        }
                    }
                }
            }  
            br.close();   
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + USERINFO + "'"
                        + "\nClosing application"); 
            System.exit(0);
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + USERINFO + "'"
                        + "\nClosing application"); 
            System.exit(0);
        }
        System.out.println("\nIncorrect Login."
                + "\nPlease try again.");
                    
        return "fail";        // retry login
    }
    
    public static void login(){ // main function to login
        String roleidentifier;
        do{
            roleidentifier =  roleIdentifier();
        }while (roleidentifier.equals("fail")); // will repeat until hit one of the role
        
        if(roleidentifier.equals("GUEST")){
            Guest g1 = new Guest();
            System.out.println("\nWelcome Guest!");
            g1.action();
        }
        else{
            switch (roleidentifier){
                case "CUSTOMER":
                    Customer c1 = new Customer(OODJ_Assignment_2018.id, OODJ_Assignment_2018.password, OODJ_Assignment_2018.name, OODJ_Assignment_2018.role);
                    c1.displayInfo();
                    pressEnter();
                    c1.action();
                    break;
                case "PHARMACIST":
                    Pharmacist p1 = new Pharmacist(OODJ_Assignment_2018.id, OODJ_Assignment_2018.password, OODJ_Assignment_2018.name, OODJ_Assignment_2018.role);
                    p1.displayInfo();
                    pressEnter();
                    p1.action();
                    break;
                case "ADMIN":
                    Admin a1 = new Admin(OODJ_Assignment_2018.id, OODJ_Assignment_2018.password, OODJ_Assignment_2018.name, OODJ_Assignment_2018.role);
                    a1.displayInfo();
                    pressEnter();
                    a1.action();
                    break;
                //default for error checking is done at above
            }
        }
    }
    
    public static void main(String[] args) {

        // Check admin's present: yes -> login; no -> register until success || close system if (absent && discontinue register)
        startup();
        
        while(true){
            login(); // exit will be done inside immediately
        }
    }
}