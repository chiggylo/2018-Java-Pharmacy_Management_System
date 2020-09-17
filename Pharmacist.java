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

/**
 *
 * @author Chi Gou Lo
 */


public class Pharmacist extends Guest{ // done
    
    public Pharmacist(){
        super();
    }
    
    public Pharmacist(String id, String password, String name, String role){ // for exisiting admin, just for displaying - not for checking
        super();
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }
    
    public boolean availabilityM(String check){ // for unique ID placement, similar to id checking
        String line;
        String parts[];
        
        try{
            FileReader fr = new FileReader(MEDICINEINFO);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                if(parts[0].equals(check)){
                        return false;
                }
            }  
            br.close();   
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + MEDICINEINFO + "'"
                        + "\nClosing application");   
            System.exit(0);
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + MEDICINEINFO + "'"
                        + "\nClosing application");  
            System.exit(0);
        }
        
        return true;
    }
    
    public void addMedicine(){ // should be done
        boolean repeat = true;
        boolean repeat2 = true;
        boolean repeat3 = true;
        //String pass = "";
        String ID = null, nameM = null, companyM = null, batchM = null, DOM = null, DOE = null, priceM = null, quantityM = null;
       
        while(repeat3){ // repeat whole process if not 'no' only
            // unique medicine ID search
            String title = "M";
            int numbering = 0;// 
            String num = Integer.toString(numbering);
            String newID = title + num;
            while(!availabilityM(newID)){
                numbering += 1;
                num = Integer.toString(numbering);
                newID = title + num;
            }
            ID = newID;
            
            repeat = true;
            // medicine name
            while(repeat){
                repeat2 = true;
                System.out.println("\nWhat is the name of the medicine?");
                nameM = input.nextLine().toUpperCase();
                nameM = input.nextLine().toUpperCase(); // did not trigger
                System.out.println("\nAre you sure it's " + nameM + "? (Y/N)");
                while(repeat2){
                    switch(input.nextLine().toUpperCase()){
                        case "Y":
                            repeat = false;
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
            repeat = true;
            repeat2 = true;

            // company name
            while(repeat){
                repeat2 = true;
                System.out.println("\nWhat is the name of the company?");
                companyM = input.nextLine().toUpperCase();
                System.out.println("\nAre you sure it's " + companyM + "? (Y/N)");
                while(repeat2){
                    switch(input.nextLine().toUpperCase()){
                        case "Y":
                            repeat = false;
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
            repeat = true;
            repeat2 = true;
            
            // batchM
            while(repeat){
                repeat2 = true;
                System.out.println("\nWhat is the batch?");
                batchM = input.nextLine();
                System.out.println("\nAre you sure it's " + batchM + "? (Y/N)");
                while(repeat2){
                    switch(input.nextLine().toUpperCase()){
                        case "Y":
                            repeat = false;
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
            repeat = true;
            repeat2 = true;

            // DOM
            while(repeat){
                repeat2 = true;
                System.out.println("\nWhat is the Date of Manufacturing...");
                System.out.println("\nWhat month? (Enter '1' for January, etc)");
                int month = input.nextInt(); // (WIP) error checking for numeric
                System.out.println("\nWhat year?");
                int year = input.nextInt();
                DOM = Integer.toString(month) + ", " + Integer.toString(year);
                System.out.println("\nAre you sure it's " + DOM + "? (Y/N)");
                input.nextLine(); // need it to pause
                while(repeat2){
                    switch(input.nextLine().toUpperCase()){
                        case "Y":
                            repeat = false;
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
            repeat = true;
            repeat2 = true;

            // DOE
            while(repeat){
                repeat2 = true;
                System.out.println("\nWhat is the Date of Expiry...");
                System.out.println("\nWhat month? (Enter '1' for January, etc)");
                int month = input.nextInt();
                System.out.println("\nWhat year?");
                int year = input.nextInt();
                DOE = Integer.toString(month) + ", " + Integer.toString(year);
                System.out.println("\nAre you sure it's " + DOE + "? (Y/N)");
                input.nextLine(); // need it to pause
                while(repeat2){
                    switch(input.nextLine().toUpperCase()){
                        case "Y":
                            repeat = false;
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
            repeat = true;
            repeat2 = true;

            // price
            while(repeat){
                repeat2 = true;
                System.out.println("\nWhat is the price?");
                priceM = input.nextLine();
                System.out.println("\nAre you sure it's " + priceM + "? (Y/N)");
                while(repeat2){
                    switch(input.nextLine().toUpperCase()){
                        case "Y":
                            repeat = false;
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
            repeat = true;
            repeat2 = true;

            // quantity
            while(repeat){
                repeat2 = true;
                System.out.println("\nWhat is the quantity?");
                quantityM = input.nextLine();
                System.out.println("\nAre you sure it's " + quantityM + "? (Y/N)");
                while(repeat2){
                    switch(input.nextLine().toUpperCase()){
                        case "Y":
                            repeat = false;
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
            repeat = true;
            repeat2 = true;

        // confirmation
        
            System.out.println("\nPlease confirm the medicine detail...");
            System.out.println("\nMedicine ID: " + ID + " (Self Generated)\nName: " + nameM + "\nCompany: " + companyM + "\nBatch no. : " + batchM + "\nDOM: " + DOM + "\nDOE: " + DOE + "\nPrice: " + priceM + "\nQuantity: "+ quantityM);            
            System.out.println("\nAre you sure? (Y/N)");
            while(repeat2){
                switch(input.nextLine().toUpperCase()){
                    case "Y":
                        //registering
                        try{
                            FileWriter fw = new FileWriter(MEDICINEINFO, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(ID+";"+nameM+";"+companyM+";"+batchM+";"+DOM+";"+DOE+";"+priceM+";"+quantityM+";");
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
                        repeat = false;
                        repeat2 = false;
                        repeat3 = false;
                        break;
                    case "N":
                        repeat = false;
                        repeat2 = false;
                        boolean repeat4 = true;
                        System.out.println("\nDo you wish to try again? (Y/N)");
                        while(repeat4){
                            switch(input.nextLine().toUpperCase()){
                                case "Y":
                                    repeat4 = false;
                                    break;
                                case "N":
                                    repeat4 = false;
                                    repeat3 = false;
                                    break;
                                default:
                                    System.out.println("\nInvalid input."
                                            + "\n(Y/N)");
                                    break;
                            }
                            
                        }
                        break;
                    default:
                        System.out.println("\nInvalid input."
                                + "\n(Y/N)");
                        break;
                }
            }
        }
    }
    
    public boolean deleteMedicine(){ // done!!!
        System.out.println("\nWhat is the medicine ID/name?");
        String ID = input.nextLine().toUpperCase();
        ID = input.nextLine().toUpperCase();

        String line;
        String parts[];
        boolean deleting = false;
        
        // find medicine
        try{
            FileReader fr = new FileReader(MEDICINEINFO);
            BufferedReader br = new BufferedReader(fr);
            
            //clear temp file for holding
            PrintWriter pw = new PrintWriter(TEMPMEDICINEINFO);
            pw.print("");
            pw.close();
            
            // start writing
            FileWriter fw = new FileWriter(TEMPMEDICINEINFO, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            while((line = br.readLine()) != null) {
                parts = line.split(";"); // search by name
                
                if(!deleting){ // only allows to delete one, also use to search for same name
                    if(ID.charAt(0) != 'M'){ // name search
                        if(parts[1].toUpperCase().equals(ID)){
                            System.out.println("\nDo you wish to delete "+parts[0]+"? (Y/N)\nName: " + parts[1] + "\nCompany: " + parts[2] + "\nBatch no. : " + parts[3] + "\nDOM: " + parts[4] + "\nDOE: " + parts[5] + "\nPrice: " + parts[6] + "\nQuantity: "+ parts[7]);
                            boolean repeat = true;
                            while(repeat){
                            switch(input.nextLine().toUpperCase()){
                                        case "Y":
                                            repeat = false;
                                            deleting = true;
                                            break;
                                        case "N":
                                            repeat = false;
                                            bw.write(line); // write into temp file for transfer
                                            bw.newLine();
                                            break;
                                        default:
                                            System.out.println("\nInvalid input."
                                                + "\n(Y/N)");
                                        break;

                                }
                            }
                        }
                    }
                    else if(ID.charAt(0) == 'M'){ // id search
                        if(parts[0].toUpperCase().equals(ID)){
                            System.out.println("\nDo you wish to delete "+parts[0]+"? (Y/N)\nName: " + parts[1] + "\nCompany: " + parts[2] + "\nBatch no. : " + parts[3] + "\nDOM: " + parts[4] + "\nDOE: " + parts[5] + "\nPrice: " + parts[6] + "\nQuantity: "+ parts[7]);
                            boolean repeat = true;
                            while(repeat){
                            switch(input.nextLine().toUpperCase()){
                                        case "Y":
                                            repeat = false;
                                            deleting = true;
                                            break;
                                        case "N":
                                            repeat = false;
                                            bw.write(line); // write into temp file for transfer
                                            bw.newLine();
                                            return false;
                                        default:
                                            System.out.println("\nInvalid input."
                                                + "\n(Y/N)");
                                        break;

                                }
                            }
                        }
                        
                    }
                    
                }
                else{ // if no match and already deleted once
                    bw.write(line);
                    bw.newLine();
                
                }
            }
            bw.close();
            if(deleting){

                //write into original file from temp file
                FileReader fr2 = new FileReader(TEMPMEDICINEINFO);
                BufferedReader br2 = new BufferedReader(fr2);

                //clear file
                PrintWriter pw2 = new PrintWriter(MEDICINEINFO);
                pw2.print("");
                pw2.close();

                // writing
                FileWriter fw2 = new FileWriter(MEDICINEINFO, true);
                BufferedWriter bw2 = new BufferedWriter(fw2);
                while((line = br2.readLine()) != null){
                    bw2.write(line);
                    bw2.newLine();
                }
                br2.close();
                bw2.close();
                return true;
            }
            System.out.println("\nMedicine does not exist");

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
    
    public boolean modifyMedicine(){ //done!!!
        System.out.println("\nWhat is the medicine ID/name?");
        String ID = input.nextLine().toUpperCase();
        ID = input.nextLine().toUpperCase();
        boolean exist = false;

        // serach by name. this way more easier
        int increment = 0;
        if(ID.charAt(0) != 'M'){
            increment = 1;
        }
        
        
        String line;
        String parts[];
        
        boolean modifying = false;
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
            
            //looping for modifying
            boolean repeat2 = true;
            boolean repeat3 = true;
            String temp = null;

            

            
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                
                
                
                // search by ID
                if(parts[0+increment].toUpperCase().equals(ID)){
                   // System.out.println("\ntimes");
                    boolean repeat = true;
                    while(repeat){

                        System.out.println("\nDo you wish to modify "+parts[0]+"? (Y/N)\nName: " + parts[1] + "\nCompany: " + parts[2] + "\nBatch no. : " + parts[3] + "\nDOM: " + parts[4] + "\nDOE: " + parts[5] + "\nPrice: " + parts[6] + "\nQuantity: "+ parts[7]);
                        switch(input.nextLine().toUpperCase()){
                            case "Y":
                                
                                
                                while(repeat3){ // repeating modification 
                                System.out.println("\nWhat do you wish to modify?\n1: Name\n2: Company\n3: Batch no.\n4: DOM\n5: DOE\n6: Price\n7: Quantity\n8: Confirmation and Exit");
                                repeat2 = true;
                                
                                switch(input.next().charAt(0)){
                                    
                                    case '1': // start of case 1
                                        
                                        System.out.println("\nWhat is the new name?");
                                        temp = input.nextLine().toUpperCase();
                                        temp = input.nextLine().toUpperCase();// need to trigger it
                                        
                                        System.out.println("\nJust to confirm, you wish to change the name "+ parts[1]+" to " +temp+ "? (Y/N)");
                                        // loop for error checking
                                        while(repeat2){
                                            switch(input.nextLine().toUpperCase()){
                                                case "Y": 
                                                    parts[1] = temp;
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
                                        break; // end of case 1
                                           
                                        
                                    case '2': 
                                        System.out.println("\nWhat is the new company?");
                                        temp = input.nextLine().toUpperCase();
                                        temp = input.nextLine().toUpperCase();

                                        System.out.println("\nJust to confirm, you wish to change the company "+ parts[2]+" to " +temp+ "? (Y/N)");
                                        while(repeat2){
                                            switch(input.nextLine().toUpperCase()){
                                                case "Y": // doing case sensitive later
                                                    parts[2] = temp;
                                                    repeat2 = false;
                                                    break;
                                                case "N":
                                                    break;
                                                default:
                                                    System.out.println("\nInvalid input."
                                                            + "\n(Y/N)");
                                                    break;
                                            }
                                        }
                                        break;
                                        
                                        
                                        
                                    case '3':
                                        System.out.println("\nWhat is the new batch no.?");
                                        temp = input.nextLine().toUpperCase();
                                        temp = input.nextLine().toUpperCase();

                                        System.out.println("\nJust to confirm, you wish to change the batch no. "+ parts[3]+" to " +temp+ "? (Y/N)");
                                        while(repeat2){
                                            switch(input.nextLine().toUpperCase()){
                                                case "Y": // doing case sensitive later
                                                    parts[3] = temp;
                                                    repeat2 = false;
                                                    break;
                                                case "N":
                                                    break;
                                                default:
                                                    System.out.println("\nInvalid input."
                                                            + "\n(Y/N)");
                                                    break;
                                            }
                                        }
                                        break;
                                        
                                    case '4': // wokring here
                                        //DOM
                                            
                                            System.out.println("\nWhat is the new Date of Manufacturing...");
                                            System.out.println("\nWhat is month of manufacturing? (Enter '1' for January, etc)"); // (WIP) error checking for numbering/ not like actual date
                                            
                                            input.nextInt();
                                            int tempMonth = input.nextInt();
                                            if(!(tempMonth > 0  || tempMonth <13)){
                                                do{
                                                    System.out.println("\nInvalid input."
                                                                + "\nEnter '1' for January, etc");
                                                    tempMonth = input.nextInt();

                                                }while(!(tempMonth > 0  || tempMonth <13));
                                            }
                                            
                                            System.out.println("\nWhat year of manufactoring?");
                                            input.nextInt();
                                            int tempYear = input.nextInt();

                                            
                                            
                                            String DOM = Integer.toString(tempMonth) + ", " + Integer.toString(tempYear);
                                            System.out.println("\nJust to confirm, you wish to change the DOM "+ parts[4]+" to " +DOM+ "? (Y/N)");


                                            while(repeat2){
                                                switch(input.nextLine().toUpperCase()){
                                                    case "Y":
                                                        parts[4] = DOM;
                                                        repeat2 = false;
                                                        break;
                                                    case "N":
                                                        repeat2 = false;
                                                        break; // do nothing to keep looping
                                                    default:
                                                    System.out.println("\nInvalid input."
                                                            + "\n(Y/N)");
                                                    break;

                                                }
                                            
                                            }
                                            break;
                                            
                                            
                                    case '5':
                                        System.out.println("\nWhat is the new Date of Expiry...");
                                        System.out.println("\nWhat is month of expiry? (Enter '1' for January, etc)"); // (WIP) error checking for numbering/ not like actual date
                                            
                                            input.nextInt();
                                            int month = input.nextInt();
                                            if(!(month > 0  || month <13)){
                                                do{
                                                    System.out.println("\nInvalid input."
                                                                + "\nEnter '1' for January, etc");
                                                    tempMonth = input.nextInt();

                                                }while(!(month > 0  || month <13));
                                            }
                                            
                                            System.out.println("\nWhat year of expiry?");
                                            input.nextInt();
                                            int year = input.nextInt();
                                            
                                        String DOE = Integer.toString(month) + ", " + Integer.toString(year); // too lazy to change
                                        System.out.println("\nJust to confirm, you wish to change the DOE "+ parts[5]+" to " +DOE+ "? (Y/N)");

                                        while(repeat2){
                                            switch(input.nextLine().toUpperCase()){
                                            case "Y":
                                                parts[5] = DOE;
                                                repeat2 = false;
                                                break;
                                            case "N":
                                                repeat2 = false;
                                                break; // do nothing to keep looping
                                            default:
                                                    System.out.println("\nInvalid input."
                                                            + "\n(Y/N)");
                                                    break;
                                            }
                                        }
                                        
                                        break;
                                        
                                    case '6':
                                            System.out.println("\nWhat is the new price?");
                                            input.nextLine();
                                            temp = input.nextLine();
                                            System.out.println("\nJust to confirm, you wish to change the price "+ parts[6]+" to " +temp+ "? (Y/N)");
                                            
                                            while(repeat2){
                                                switch(input.nextLine().toUpperCase()){
                                                    case "Y":
                                                        parts[6] = temp;
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
                                        break;
                                        
                                        
                                    case '7':
                                        System.out.println("\nWhat is the new quantity?");
                                        temp = input.nextLine();
                                        temp = input.nextLine();// need to trigger it

                                        System.out.println("\nJust to confirm, you wish to change the quantity "+ parts[7]+" to " +temp+ "? (Y/N)");
                                        while(repeat2){
                                            switch(input.nextLine().toUpperCase()){
                                                case "Y": // doing case sensitive later
                                                    parts[7] = temp;
                                                    repeat2 = false;
                                                    break;
                                                case "N":
                                                    break;
                                                default:
                                                    System.out.println("\nInvalid input."
                                                            + "\n(Y/N)");
                                                    break;
                                            }
                                        }
                                        break;
                                        
                                        
                                    case '8':// Confirmation and Exit (WIP)
                                        repeat3 = false;

                                        System.out.println("\nConfirming modification to "+ID+"? (Y/N)\nName: " + parts[1] + "\nCompany: " + parts[2] + "\nBatch no. : " + parts[3] + "\nDOM: " + parts[4] + "\nDOE: " + parts[5] + "\nPrice: " + parts[6] + "\nQuantity: "+ parts[7]);
                                        boolean repeat4 = true;
                                        while(repeat4){
                                            String answer = input.nextLine().toUpperCase();
                                            answer = input.nextLine().toUpperCase();
                                            switch(answer){
                                                case "Y":
                                                    modifying = true;
                                                    repeat4 = false;
                                                    repeat = false;
                                                    break;
                                                case "N":
                                                    System.out.println("\nAll changes has been reverted.");
                                                    pressEnter();
                                                    repeat4 = false;
                                                    break;
                                                default:
                                                    System.out.println("\nInvalid input."
                                                            + "\n(Y/N)");
                                                    break;
                                            }
                                        }
                                        break;
                                        
                                }
                                if(modifying){
                                    bw.write(parts[0]+";"+parts[1]+";"+parts[2]+";"+parts[3]+";"+parts[4]+";"+parts[5]+";"+parts[6]+";"+parts[7]+";");
                                    bw.newLine();
                                }
                                
                            }
                                break;
                            // no modification
                            case "N":
                                repeat = false;
                                bw.write(line);
                                bw.newLine();
                                exist = true;
                                break;                               
                            default:
                                System.out.println("\nInvalid input."
                                        + "\n(Y/N)");
                                break;
                        }
                    }
                    
                }
                else{
                    bw.write(line);
                    bw.newLine();
                
                }
            }
            
            bw.close();
            br.close();
            if(modifying){
                // write into original file
                FileReader fr2 = new FileReader(TEMPMEDICINEINFO);
                BufferedReader br2 = new BufferedReader(fr2);
                //clear file
                PrintWriter pw2 = new PrintWriter(MEDICINEINFO);
                pw2.print("");
                pw2.close();
                
                FileWriter fw2 = new FileWriter(MEDICINEINFO, true);
                BufferedWriter bw2 = new BufferedWriter(fw2);
                while((line = br2.readLine()) != null){
                    bw2.write(line);
                    bw2.newLine();
                }
                br2.close();
                bw2.close();
                return true;
            }
            if(exist){
                return false;
            }
            System.out.println("\nMedicine does not exist");
            pressEnter();


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
    
    public void searchMedicine(){ 
        System.out.println("\nWhat is the medicine ID/name?");
        String ID = input.nextLine().toUpperCase();
        ID = input.nextLine().toUpperCase();
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
                int increment = 0;
                if(ID.charAt(0) != 'M'){
                    increment = 1;
                }
                if(parts[0+increment].equals(ID)){
                    System.out.println("\nThe detail of medicine "+parts[0]+"..."
                            + "\nName: " + parts[1] 
                            + "\nCompany: " + parts[2] 
                            + "\nBatch no. : " + parts[3] 
                            + "\nDOM: " + parts[4] 
                            + "\nDOE: " + parts[5] 
                            + "\nPrice: " + parts[6] 
                            + "\nQuantity: "+ parts[7]);
                    exist = true;
                    
                }
            }
            
            if(!exist){
                System.out.println("\nSorry, the medicine does not exist in the system.");
                
            }
            pressEnter();
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
    
    public void expiredOn(){ // done!!
        System.out.println("\nWhat month does the medicine expired on? (Enter '1' for January, etc)");
        
        int tempMonth = -1;
        do{
            tempMonth = input.nextInt();
        } while(tempMonth == -1); // this way it will loop once or many depending if it is assigned.
        
        if(!(tempMonth > 0  || tempMonth <13)){
            do{
                System.out.println("\nInvalid input."
                            + "\nEnter '1' for January, etc");
                tempMonth = input.nextInt();

            }while(!(tempMonth > 0  || tempMonth <13));
        }
        String month = Integer.toString(tempMonth);
        
        String line;
        String parts[];
        try{
            FileReader fr = new FileReader(MEDICINEINFO);
            BufferedReader br = new BufferedReader(fr);
            boolean exist = false;
            while((line = br.readLine()) != null) {
                parts = line.split(";");
                if(parts[5].charAt(0) == month.charAt(0)){
                    System.out.println("\nThe detail of medicine "+parts[0]+"...\nName: " + parts[1] + "\nCompany: " + parts[2] + "\nBatch no. : " + parts[3] + "\nDOM: " + parts[4] + "\nDOE: " + parts[5] + "\nPrice: " + parts[6] + "\nQuantity: "+ parts[7]);
                    pressEnter();
                    exist = true;
                }
            }
            
            if(!exist){
                System.out.println("\nSorry, there is no medicine expired on the selected month.");
                
                
            }
            pressEnter();
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
    
    public void action(){
        boolean logout = false;

        while(!logout){
            System.out.println("\n1: Add medicine\n2: Delete medicine\n3: Modify medicine\n4: Search medicine\n5: Expired on\n6: Check Medicine Availablilty\n7: Check Medicine Detail\n8: Logout \n9: Logout and Exit");
            char choice = input.next().charAt(0); 
            boolean successful;
            switch(choice){
                case '1':
                    addMedicine();
                    System.out.println("\nAdding medicine...\nSuccessful.\nWhat do you wish to do next?");
                    break;
                case '2':
                    successful = deleteMedicine();
                    if(successful){
                        System.out.println("\nDeleting medicine...\nSuccessful.\nWhat do you wish to do next?");

                    }
                    else{
                       System.out.println("\nDeleting medicine...\nUnsuccessful.\nWhat do you wish to do next?");
                    }
                    break;
                case '3':
                    successful = modifyMedicine();
                    if(successful){
                        System.out.println("\nModifying medicine...\nSuccessful.\nWhat do you wish to do next?");
                    }
                    else{
                        System.out.println("\nModifying medicine...\nUnsuccessful.\nWhat do you wish to do next?");
                    }
                    break;
                case '4':
                    searchMedicine();
                    System.out.println("\nWhat do you wish to do next?");
                    break;
                case '5':
                    expiredOn();
                    System.out.println("\nWhat do you wish to do next?");
                    break;
                case '6':
                    medicineAvailability();
                    System.out.println("\nWhat do you wish to do next?");
                    break;
                case '7' :
                    medicineDetail();
                    break;
                case '8':
                    System.out.println("\nLogging out...");
                    logout = true;
                    break;    
                case '9':
                    System.out.println("\nLogging out..."
                            + "\nClosing Application");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nIncorrect option. What do you wish to do?");
                    break;
            }                        
        }
    }
}
