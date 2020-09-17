/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Chi Gou Lo
 */
public class Customer extends Guest{
    
    private static final String CUSTOMERFILE =  "E:\\OODJ_Assignment_2018\\customer\\";

    
    public Customer(){
        super();
    }
    
    public Customer(String id, String password, String name, String role){ // for exisiting admin, just for displaying - not for checking
        super();
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }
    
    public double medicinePrice(String ID){
        String line;
        String parts[];
        
        int increment = 0;
        if(ID.charAt(0) != 'M')
        {
         increment++;   
        }
        // find medicine
        try{
            FileReader fr = new FileReader(MEDICINEINFO);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                if(parts[0+increment].toUpperCase().equals(ID.toUpperCase())){
                        return Double.parseDouble(parts[6]);
                }
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println("\nUnable to open file '" + MEDICINEINFO + "'"
                    + "\nClosing application.");  
            System.exit(0);
        }   
        catch(IOException ex) {
            System.out.println("\nError reading file '" + MEDICINEINFO + "'"
                    + "\nClosing application");  
            System.exit(0);
        }
        return -1;
    }
    
    public String medicineID(String ID){
        String line;
        String parts[] = null;
        
        if(ID.toUpperCase().charAt(0) != 'M'){ //name
            try{
            FileReader fr = new FileReader(MEDICINEINFO);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                    if(parts[1].toUpperCase().equals(ID.toUpperCase())){
                        return parts[0];
                    }   
                }
            }
            catch(FileNotFoundException ex) {
            System.out.println("\nUnable to open file '" + MEDICINEINFO + "'"
                    + "\nClosing application.");  
            System.exit(0);
            }   
            catch(IOException ex) {
                System.out.println("\nError reading file '" + MEDICINEINFO + "'"
                        + "\nClosing application");  
                System.exit(0);
            }
        }
        return ID;        
    }
    
    public void bill(){ // should be done
        
        // dynamic file generation
        String filepath = CUSTOMERFILE + this.id;
        File yourfile = new File(filepath);
        boolean b = false;
        if(!yourfile.exists()){ // creating text file dynamically
            try{
            b = yourfile.createNewFile();
            }
            catch(FileNotFoundException ex) {
                System.out.println("\nUnable to open file '" + filepath + "'"
                        + "\nClosing application.");  
                System.exit(0);
            }   
            catch(IOException ex) {
                System.out.println("\nError reading file '" + filepath + "'"
                        + "\nClosing application");  
                System.exit(0);
            }
        }
        
        // status display
        if(b){
            System.out.println("\nCreating user's cart...");
        }
        else{
            System.out.println("\nUpdating user's cart...");
        }
        
        
        // setting variables to be use
        boolean repeat = true;
        boolean repeat2 = true;
        double amount = 0;
        
        while(repeat){
      
            //display
            System.out.println("\nWhat do you wish to buy? "
                    + "\nPlease provide the medicine ID. If needed, type \"~\" beforehand to check the detail");
            
            // grabbing medicine detail input
            String answer;
            while(true){
                answer = input.nextLine().toUpperCase();
                if(!answer.equals("")){
                    break;
                }
            }
            
            
            
            char check = answer.charAt(0);
            if(check == '~'){ // check for addition prefix for detail
                String parts[] = answer.split("~");
                if(medicineDetail(parts[1].toUpperCase())){
                    while(repeat2){
                        System.out.println("\nWARNING! If there is more than 2 result, the first result will be purchased." 
                                +"\nTo select others, try again and type in the medicine ID instead of the name."
                                +"\nDo you wish to buy "+parts[1]+"? (Y/N)");
                        
                        switch(input.nextLine().toUpperCase()){
                            case "Y":
                                System.out.println("\nHow much do you wish to buy?");
                                int quantity = input.nextInt();
                                double cost = quantity*medicinePrice(parts[1]);
                                amount += cost;

                                //time
                                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                Date date = new Date();


                                try{
                                    FileWriter fw = new FileWriter(filepath, true);
                                    BufferedWriter bw = new BufferedWriter(fw);
                                    bw.write(dateFormat.format(date)+";"+medicineID(parts[1])+";"+quantity+";"+cost+";");
                                    bw.newLine();
                                    bw.close();   
                                }
                                catch(FileNotFoundException ex) {
                                    System.out.println("\nUnable to open file '" + MEDICINEINFO + "'"
                                            + "\nClosing application.");  
                                    System.exit(0);
                                }   
                                catch(IOException ex) {
                                    System.out.println("\nError reading file '" + MEDICINEINFO + "'"
                                            + "\nClosing application");  
                                    System.exit(0);
                                }
                                
                                repeat2 = false;
                                break;
                            case "N":
                                repeat2 = false;
                                break;
                            default:
                                System.out.println("\nInvalid input."
                                        + "\n(Y/N)");
                                break;
                        }
                    }
                }
            } 
            else{ // if detail not needed, move on to order
                if(medicineAvailability(answer)){ // ID only
                    while(repeat2){
                        System.out.println("\nDo you wish to buy "+answer+"? (Y/N)");
                    
                        switch(input.nextLine().toUpperCase()){
                            case "Y":
                                    System.out.println("\nHow much do you wish to buy?"); // integer error checking needed
                                    int quantity = input.nextInt();
                                    double cost = quantity*medicinePrice(answer);
                                    amount += cost;

                                    //time of order
                                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                    Date date = new Date();


                                    try{
                                        FileWriter fw = new FileWriter(filepath, true);
                                        BufferedWriter bw = new BufferedWriter(fw);
                                        bw.write(dateFormat.format(date)+";"+medicineID(answer)+";"+quantity+";"+cost+";");
                                        bw.newLine();
                                        bw.close();   
                                    }
                                    catch(FileNotFoundException ex) {
                                    System.out.println("\nUnable to open file '" + MEDICINEINFO + "'"
                                            + "\nClosing application.");  
                                    System.exit(0);
                                    }   
                                    catch(IOException ex) {
                                        System.out.println("\nError reading file  '" + MEDICINEINFO + "'"
                                                + "\nClosing application");  
                                        System.exit(0);
                                    }
                                    repeat2 = false;
                                    break;
                            case "N":
                                repeat2 = false;
                                break;
                            default:
                                System.out.println("\nInvalid input."
                                        + "\n(Y/N)");
                                break;
                        }
                    }
                }
                
            }
            System.out.println("\nIs there anything else you wish to buy? (Y/N)");
            
            // setting up loop for input jam
            String reply;
            while(true){
                reply = input.nextLine().toUpperCase();
                if(!reply.equals("")){
                    break;
                }
            }
            
            boolean repeat3 = true;
            while(repeat3){
                switch(reply){
                    case "Y":
                        repeat3 = false;
                        break;
                    case "N":
                        repeat3 = false;
                        repeat = false;

                        break;
                    default:
                        System.out.println("\nInvalid input."
                                + "\n(Y/N)");
                        reply = input.nextLine().toUpperCase();
                        break;
                }
            }
        }
        System.out.println("\nThe total amount of the current order is "+amount+" dollar/s. Your account has beeen updated.");
        pressEnter();
        
    }
    
    
    public void action(){ // need to pull from guest
        boolean logout = false;

        while(!logout){
            System.out.println("\n1: Check Medicine Availablilty\n2: Check Medicine Detail\n3: Order\n4: Logout\n5: Logout and Exit");
            char choice = input.next().charAt(0);

            switch(choice){
                case '1':
                    medicineAvailability();
                    System.out.println("\nWhat do you wish to do next?");
                    break;
                case '2':
                    medicineDetail();
                    System.out.println("\nWhat do you wish to do next?");

                    break;
                case '3':
                        bill();
                        break;
                case '4':
                    System.out.println("\nLogging out...");
                    logout = true;
                    break;                                    
                case '5':
                    System.out.println("\nClosing Application...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nIncorrect option. What do you wish to do?");
                    break;
            }                        
        }
    }
}
