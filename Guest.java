/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodj_assignment_2018;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Chi Gou Lo
 */
public class Guest extends User { // done
    String name;
    String id;
    String role;
    String password;
    
    Scanner input = new Scanner(System.in);

    public static final String MEDICINEINFO = "E:\\OODJ_Assignment_2018\\medicineInfo.txt";
    public static final String TEMPMEDICINEINFO = "E:\\OODJ_Assignment_2018\\TEMPMEDICINEINFO.txt";
    public static final String USERINFO = "E:\\OODJ_Assignment_2018\\userInfo.txt";

    
    public Guest(){
        super();
        this.name = "GUEST";
        this.id = null;
        this.role = "GUEST";
        this.password = null;
    } 
    
    
        public boolean medicineAvailability(String ID){
      
        String line;
        String parts[];
        
        // find medicine
        try{
            FileReader fr = new FileReader(MEDICINEINFO);
            BufferedReader br = new BufferedReader(fr);
            
            //clear file
            PrintWriter pw = new PrintWriter(TEMPMEDICINEINFO);
            pw.print("");
            pw.close();
            
            // start writing into temp file
            FileWriter fw = new FileWriter(TEMPMEDICINEINFO, true);
            BufferedWriter bw = new BufferedWriter(fw);
            boolean exist = false;
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                if(ID.toUpperCase().charAt(0) != 'M'){ // name
                    if(parts[1].toUpperCase().equals(ID.toUpperCase())){
                        if(Integer.parseInt(parts[7])>0){
                        System.out.println("\nThe medicine "+ID+", ID: "+parts[0]+", is currently available with "+parts[7]+" in stock."); // might be wrong
                        pressEnter();
                        exist = true;
                        }
                        else{
                            System.out.println("\nThe medicine "+ID+" is currently out of stock.");
                            pressEnter();
                            return false;
                        }
                    }
                }
                else{ // id
                    if(parts[0].toUpperCase().equals(ID.toUpperCase())){
                        if(Integer.parseInt(parts[7])>0){
                        System.out.println("\nThe medicine "+ID+" is currently available with "+parts[7]+" in stock.");
                        pressEnter();
                        return true;
                        }
                        else{
                            System.out.println("\nThe medicine "+ID+" is currently out of stock.");
                            pressEnter();
                            return false;
                        }
                    }
                }
            }
            
            if(!exist){
                System.out.println("\nSorry, the medicine does not exist in the system.");
                pressEnter();
                return false;
                
            }
            else{
                return true;
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
        return false;
    
    }

    
    public boolean medicineAvailability(){ 
        System.out.println("\nWhat is the ID of the medicine?");

        String ID;
        while(true){
            ID = input.nextLine().toUpperCase();
            if(!ID.equals("")){
                break;
            }
        }
        
        String line;
        String parts[];
        
        // find medicine
        try{
            FileReader fr = new FileReader(MEDICINEINFO);
            BufferedReader br = new BufferedReader(fr);
            
            //clear file
            PrintWriter pw = new PrintWriter(TEMPMEDICINEINFO);
            pw.print("");
            pw.close();
            
            // start writing into temp file
            FileWriter fw = new FileWriter(TEMPMEDICINEINFO, true);
            BufferedWriter bw = new BufferedWriter(fw);
            boolean exist = false;
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                if(ID.toUpperCase().charAt(0) != 'M'){ // name
                    if(parts[1].toUpperCase().equals(ID.toUpperCase())){
                        if(Integer.parseInt(parts[7])>0){
                        System.out.println("\nThe medicine "+ID+", ID: "+parts[0]+", is currently available with "+parts[7]+" in stock."); // might be wrong
                        pressEnter();
                        exist = true;
                        }
                        else{
                            System.out.println("\nThe medicine "+ID+" is currently out of stock.");
                            pressEnter();
                            return false;
                        }
                    }
                }
                else{ // id
                    if(parts[0].toUpperCase().equals(ID.toUpperCase())){
                        if(Integer.parseInt(parts[7])>0){
                        System.out.println("\nThe medicine "+ID+" is currently available with "+parts[7]+" in stock.");
                        pressEnter();
                        return true;
                        }
                        else{
                            System.out.println("\nThe medicine "+ID+" is currently out of stock.");
                            pressEnter();
                            return false;
                        }
                    }
                }
            }
            
            if(!exist){
                System.out.println("\nSorry, the medicine does not exist in the system.");
                pressEnter();
                return false;
                
            }
            else{
                return true;
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
        return false;
    
    }
    
    
    public boolean medicineDetail(String ID){ //used for pharmacist method
        String line;
        String parts[];
        
        // find medicine
        try{
            FileReader fr = new FileReader(MEDICINEINFO);
            BufferedReader br = new BufferedReader(fr);
            boolean exist = false;
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                if(ID.toUpperCase().charAt(0) != 'M'){ //name
                    if(parts[1].toUpperCase().equals(ID.toUpperCase())){
                    System.out.println("\nThe detail of medicine "+ID+"...\nName: " + parts[1] + "\nCompany: " + parts[2] + "\nDOM: " + parts[4] + "\nDOE: " + parts[5] + "\nPrice: " + parts[6]);
                    pressEnter();
                    exist = true; // to print multiple same name 
        }
                }
                else{ // id
                    if(parts[0].toUpperCase().equals(ID.toUpperCase())){ // to list all the names before exiting
                        System.out.println("\nThe detail of medicine "+ID+"...\nName: " + parts[1] + "\nCompany: " + parts[2] + "\nDOM: " + parts[4] + "\nDOE: " + parts[5] + "\nPrice: " + parts[6]);
                        pressEnter();
                        return true;
                    }
                }
            }
            
            
            if(!exist){
                System.out.println("\nSorry, the medicine does not exist in the system.");
                pressEnter();
                return false;
                
            }
            else{
                return true;
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
        return false;
    }
    
    public boolean medicineDetail(){
        System.out.println("\nWhat is the ID of the medicine?");

        String ID;
        while(true){
            ID = input.nextLine().toUpperCase();
            if(!ID.equals("")){
                break;
            }
        }
        String line;
        String parts[];
        
        // find medicine
        try{
            FileReader fr = new FileReader(MEDICINEINFO);
            BufferedReader br = new BufferedReader(fr);
            boolean exist = false;
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                if(ID.toUpperCase().charAt(0) != 'M'){ //name
                    if(parts[1].toUpperCase().equals(ID.toUpperCase())){
                    System.out.println("\nThe detail of medicine "+ID
                            +"...\nName: " + parts[1] 
                            +"\nCompany: " + parts[2] 
                            +"\nDOM: " + parts[4] 
                            +"\nDOE: " + parts[5] 
                            +"\nPrice: " + parts[6]);
                    pressEnter();
                    exist = true; // to print multiple same name 
        }
                }
                else{ // id
                    if(parts[0].toUpperCase().equals(ID.toUpperCase())){ // to list all the names before exiting
                        System.out.println("\nThe detail of medicine "+ID+"...\nName: " + parts[1] + "\nCompany: " + parts[2] + "\nDOM: " + parts[4] + "\nDOE: " + parts[5] + "\nPrice: " + parts[6]);
                        pressEnter();
                        return true;
                    }
                }
            }
            
            
            if(!exist){
                System.out.println("\nSorry, the medicine does not exist in the system.");
                pressEnter();
                return false;
                
            }
            else{
                return true;
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
        return false;
    }
    
    @Override
     public void action(){ // main
        boolean logout = false;

        while(!logout){
            System.out.println("\n1: Check Medicine Availablilty\n2: Check Medicine Detail\n3: Login\n4: Exit");
            char choice = input.next().charAt(0);

            switch(choice){
                case '1':
                    medicineAvailability();
                    System.out.println("\nWhat do you wish to do next?");
                    break;
                case '2':
                    medicineDetail();
                    break;
                case '3':
                    logout = true;
                    break;
                case '4':
                    System.out.println("\nClosing Application...");
                    System.exit(0);
                default:
                    System.out.println("\nIncorrect option. What do you wish to do?");
                    break;
            }                        
        }
    }
     
    /*
    public void pressEnter(){
        System.out.println("\nPress enter to continue...");
        
        String reply = "notempty";
        while(true){
            reply = input.nextLine();
            if(reply.equals("")){
                break;
            }
        }
    }*/
     
    public String idReturn(){
        return this.id;
    }
    
    public String passwordReturn(){
        return this.password;
    }
    
    public String nameReturn(){
        return this.name;
    }
    
    public String roleReturn(){
        return this.role;
    }
    
    public void displayInfo(){
        System.out.println("\nLogged in as..."
                + "\nUser: " + this.name.toUpperCase() + "\nRole: " + this.role.toUpperCase());

    }
            
}
