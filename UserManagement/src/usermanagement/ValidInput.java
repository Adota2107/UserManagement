/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class ValidInput {
    Scanner sc = new Scanner(System.in);
    
    public String checkInput(){
        //loops are used to prevent the user from entering spaces
        while (true) {                   
            String input = sc.nextLine().trim(); 
            if (input.isEmpty()) {
                System.out.println("Can't leave blank!!!");
                System.out.print("Please enter again: ");
            }else{
                return input;
            }
        }
    }
    
    public String checkUsername(){
        System.out.print("Enter Username: ");
        //Loop are used to prevent user from enter wrong regEx
        while (true) {            
            String input = checkInput();
            //regEx: Allow enter 5 character without blank
            //Check if input match with regEx
            if (input.matches("^\\S{5}\\S*$")) {
                return input;
            }
            System.out.println("You must enter least at 5 character, and no space!");
            System.out.print("Enter Username: ");
        }  
    }
    
    public String checkPassword(){
        System.out.print("Enter Password: ");
        //Loop are used to prevent user from enter wrong regEx
        while (true) {            
            String input = checkInput();
            //regEx: Allow enter 6 character without blank
            //Check if input match regEx
            if (input.matches("^\\S{6}\\S*$")) {
                return input;
            }
            System.out.println("You must enter least at 6 character, and no space!");
            System.out.print("Enter Password: ");
        }
    }

    public String checkUsernameInFile(String str){
        File acc = new File("C:\\Users\\admin\\Documents\\NetBeansProjects\\UserManagement\\src\\usermanagement\\user.dat");
        try{
            FileReader fr = new FileReader(acc);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if(line == null) {
                    break;
                }      
                String[] accList = line.split(";");
                //Loop for put username and password to string array until it null
                for (int i = 0; i < accList.length; i++) {
                    if (str.equals(accList[i])) {
                        return accList[i];
                    }                        
                }
            }    
        }
        catch (FileNotFoundException fne){
            System.out.println("Something went wrong");
            System.out.println("Detail: " + fne);
        }
        catch (IOException ioe){
            System.out.println("Something went wrong");
            System.out.println("Detail: " + ioe);
        }
        return null;
    }
 
    //String type return null because it only use to compare with string in function loginSystem in Manage.java
    public String checkPasswordInFile(String str){
        File acc = new File("C:\\Users\\admin\\Documents\\NetBeansProjects\\UserManagement\\src\\usermanagement\\user.dat");
        try{
            FileReader fr = new FileReader(acc);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if(line == null) {
                    break;
                }      
                String[] accList = line.split(";");
                //Loop for put username and password to string array until it null
                for (int i = 0; i < accList.length; i++) {
                    if (str.equals(accList[i])) {
                        return accList[i+1];
                    }                        
                }
            }    
        }
        catch (FileNotFoundException fne){
            System.out.println("Something went wrong");
            System.out.println("Detail: " + fne);
        }
        catch (IOException ioe){
            System.out.println("Something went wrong");
            System.out.println("Detail: " + ioe);
        }
        return null;
    }
    
    //Check when username already exits
    public boolean checkUsernameExits(String str){
        File acc = new File("C:\\Users\\admin\\Documents\\NetBeansProjects\\UserManagement\\src\\usermanagement\\user.dat");
        try{
            FileReader fr = new FileReader(acc);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if(line == null) {
                    break;
                }      
                String[] accList = line.split(";");
                //Loop for put username and password to string array until it null
                for (String accList1 : accList) {
                    if (str.equals(accList1)) {
                        return true;
                    }           
                }
            }    
        }
        catch (IOException ioe){
            System.out.println("Something went wrong");
            System.out.println("Detail: " + ioe);
        }
        return false;
    }
}