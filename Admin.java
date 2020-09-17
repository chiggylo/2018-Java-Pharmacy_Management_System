
package oodj_assignment_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Chi Gou Lo
 */
public class Admin extends Pharmacist { 
       
    public Admin(){ // for new admin
        super();
    }
    
    public Admin(String id, String password, String name, String role){ // for exisiting admin
        super();
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }
    
    // for startup
    public boolean regAdmin(){ // new Admin
        
        // variable setup
        this.role = "ADMIN";
        char answer = ' ';
        
        // error checking name
        while(answer != 'Y'){
            switch(answer){
                case ' ':
                    System.out.println("\nRegistering Admin..."
                            + "\nWhat is the admin's name?");
                    this.name = input.nextLine().toUpperCase();
                    System.out.println("\nTo confirm, the name is "+this.name+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
                case 'N':
                    System.out.println("\nWhat is the admin's name?");
                    this.name = input.nextLine();
                    System.out.println("\nTo confirm, the name is "+this.name+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
                default:
                    System.out.println("\nInvalid input."
                            + "\nTo confirm, the name is "+this.name+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
            }
        }
        answer = ' '; // reset
        
        // error checking password
        while(answer != 'Y'){
            switch(answer){
                case ' ':
                    System.out.println("\nRegistering password..."
                            + "\nWhat is the password?");
                    this.password = input.nextLine().toUpperCase();
                    System.out.println("\nTo confirm, the password is "+this.password+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
                case 'N':
                    System.out.println("\nWhat is the password?");
                    this.password = input.nextLine();
                    System.out.println("\nTo confirm, the password is "+this.password+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
                default:
                    System.out.println("\nInvalid input."
                            + "\nTo confirm, the password is "+this.password+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
            }
        }
        answer = ' ';

        
        // search for free id
        try{
            FileWriter fw = new FileWriter(USERINFO, true);
            BufferedWriter bw = new BufferedWriter(fw);
            int numbering = 0;// starting from 0
            String num = Integer.toString(numbering);
            this.id = "A" + num;
            while(!availability(this.id)){ // find next available id
                numbering += 1;
                num = Integer.toString(numbering);
                this.id = "A" + num;
            }
            bw.write(this.id+";"+this.password+";"+this.name+";"+this.role+";");
            bw.newLine();
            bw.close();   
            System.out.println("\nRegister successful...");
            pressEnter();
            return true;
        }
        catch(FileNotFoundException ex) {
            System.out.println("\nError registering..."
                    + "\nClosing application"); 
            System.exit(0);
        }   
        catch(IOException ex) {
            System.out.println("\nError registering..."
                    + "\nClosing application"); 
            System.exit(0);
        }
        
        // will initiate this function until success
        return false;
    }
    
    
    public boolean newUser(){
        char answer = ' ';
        
        String newName = null;
        String newRole;
        String newPassword = null;
        String newTitle = null; //based on role
        String newID;

        
        // error checking name
        while(answer != 'Y'){
            switch(answer){
                case ' ':
                    System.out.println("\nRegistering new user..."
                            + "\nWhat is the user's name?");
                    newName = input.nextLine().toUpperCase();
                    newName = input.nextLine().toUpperCase();

                    System.out.println("\nTo confirm, the name is "+newName+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
                case 'N':
                    System.out.println("\nWhat is the user's name?");
                    newName = input.nextLine();
                    System.out.println("\nTo confirm, the name is "+newName+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
                default:
                    System.out.println("\nInvalid input."
                            + "\nTo confirm, the name is "+newName+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
            }
        }
        answer = ' '; // reset
        
        
        // role selection
        
        System.out.println("\nWhat role is this user?");
        newRole = input.nextLine().toUpperCase();      
        //checking for role
        boolean repeat = true;
        while(repeat){
            repeat = false;
            switch(newRole){ // flip all comparison to lowercase
                case "ADMIN":
                    newTitle = "A" ;
                    break;
                case "PHARMACIST":
                    newTitle = "P";
                    break;
                case "CUSTOMER":
                    newTitle = "C";
                    break;
                default:
                    System.out.println("\nInvalid input."
                            + "\nWhat role is this user? (ADMIN/PHARMACIST/CUSTOMER)");
                    newRole = input.nextLine().toUpperCase();
                    repeat = true;
                    break;
            }
        }
        
        // error checking password
        while(answer != 'Y'){
            switch(answer){
                case ' ':
                    System.out.println("\nRegistering password..."
                            + "\nWhat is the password?");
                    newPassword = input.nextLine().toUpperCase();
                    System.out.println("\nTo confirm, the password is "+newPassword+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
                case 'N':
                    System.out.println("\nWhat is the password?");
                    newPassword = input.nextLine();
                    System.out.println("\nTo confirm, the password is "+newPassword+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
                default:
                    System.out.println("\nInvalid input."
                            + "\nTo confirm, the password is "+newPassword+"? (Y/N)");
                    answer = input.nextLine().toUpperCase().charAt(0);
                    break;
            }
        }
        answer = ' ';
        
        //registering
        try{
            FileWriter fw = new FileWriter(USERINFO, true);
            BufferedWriter bw = new BufferedWriter(fw);
            int numbering = 0;// either slowly increment of 0,1,2,13 instead of 000,001,002,013
            String num = Integer.toString(numbering);
            newID = newTitle + num;
            while(!availability(newID)){
                numbering += 1;
                num = Integer.toString(numbering);
                newID = newTitle + num;
            }
            System.out.println("\nNew user detail..."
                    + "\nID: "+newID
                    + "\nPassword: "+newPassword
                    + "\nName: "+newName
                    + "\nRole: "+newRole
                    + "\nIs this correct? (Y/N)");
            answer = input.nextLine().toUpperCase().charAt(0);
            while(true){
                switch(answer){
                    case 'Y':
                        bw.write(newID+";"+newPassword+";"+newName+";"+newRole+";");
                        bw.newLine();
                        bw.close();
                        return true;
                    case 'N':
                        return false;
                    default:
                        System.out.println("\nInvalid input."
                        + "\nNew user detail..."
                        + "\nID: "+newID
                        + "\nPassword: "+newPassword
                        + "\nName: "+newName
                        + "\nRole: "+newRole
                        + "\nIs this correct? (Y/N)");
                        answer = input.nextLine().toUpperCase().charAt(0);
                        break;
                }
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("\nUnable to open file '" + USERINFO + "'"
                    + "\nClosing Application");  
            System.exit(0);
        }   
        catch(IOException ex) {
            System.out.println("\nError reading file '" + USERINFO + "'"
                    + "\nClosing Application");
            System.exit(0);
        }
        return false;
    }
    
    public boolean availability(String check){
        String line;
        String parts[];
        try{
            FileReader fr = new FileReader(USERINFO);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                if(parts[0].equals(check)){
                    br.close();   
                    return false;
                }
            }  
            br.close();   
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "\nUnable to open file '" + USERINFO + "'"
                        + "\nClosing application"); 
            System.exit(0);
        }
        catch(IOException ex) {
            System.out.println(
                "\nError reading file '" + USERINFO + "'"
                        + "\nClosing application"); 
            System.exit(0);
        }
        return true;
    }
    
    public void action(){ // need to pull from pharmacist
        boolean logout = false;
        while(!logout){
            System.out.println("\n1: New User\n2: Add medicine\n3: Delete medicine\n4: Modify medicine\n5: Search medicine\n6: Expired on\n7: Check Medicine Availablilty\n8: Check Medicine Detail\n9: Logout\n10: Logout and Exit");
            String choice = input.next();
            switch(choice){
                case "1":
                    do{
                        // empty
                    }while(!newUser());
                    System.out.println("\nCreating new user...\nSuccessful.\nWhat do you wish to do next?");
                    break;
                    
                case "2":
                    addMedicine();
                    System.out.println("\nAdding medicine...\nSuccessful.\nWhat do you wish to do next?");
                    break;
                    
                case "3":
                    boolean successful = deleteMedicine();
                    if(successful){
                        System.out.println("\nDeleting medicine...\nSuccessful.\nWhat do you wish to do next?");
                    }
                    else{
                       System.out.println("\nDeleting medicine...\nUnsuccessful.\nWhat do you wish to do next?");
                    }
                    break;
                    
                case "4":
                    successful = modifyMedicine();
                    if(successful){
                        System.out.println("\nModifying medicine...\nSuccessful.\nWhat do you wish to do next?");
                    }
                    else{
                        System.out.println("\nModifying medicine...\nUnsuccessful.\nWhat do you wish to do next?");
                    }
                    break;
                    
                case "5":
                    searchMedicine();
                    System.out.println("\nWhat do you wish to do next?");
                    break;
                    
                case "6":
                    expiredOn();
                    System.out.println("\nWhat do you wish to do next?");
                    break;
                    
                case "7":
                    medicineAvailability();
                    System.out.println("\nWhat do you wish to do next?");
                    break;
                    
                case "8" :
                    medicineDetail();
                    System.out.println("\nWhat do you wish to do next?");
                    break;
                    
                case "9":
                    System.out.println("\nLogging out...");
                    logout = true;
                    break;
                    
                case "10": 
                    System.out.println("\nLogging out..."
                            + "\nClosing Application");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("\nInvalid input."
                            + "\nWhat do you wish to do?");
                    break;
            }                        
        }
    }
}
