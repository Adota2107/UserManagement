/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author admin
 */
public class Manage extends ValidInput{
    public void createNewAccount(){
        String username = checkUsername();   
        while (checkUsernameExits(username)) {
            System.err.println("This username already exits");
            username = checkUsername();
        }
        String password = checkPassword(); 
        try {
            String curentDir = System.getProperty("user.dir");
            File acc = new File(curentDir + "/user.dat");
            if (!acc.exists()) {
                acc.createNewFile();
                System.out.println("File created successfully");
            }else{
                System.err.println("File already exits");
                System.err.println("Your new account will be add into file");
            }
            //Use this constructor because it can't be overridden
            FileWriter writer = new FileWriter(acc, true);
            writer.write(username + ";" + password + "\n");
            writer.close();  
        } catch (IOException ioe) {
            System.err.println("Something went wrong");
            System.out.println("Detail: " + ioe);
        } 
    }
        
    public void loginSystem(){
        if (!checkFileExits()) {
        String username = checkUsername();
        String password = checkPassword();
        //Compare username you entered with username in file
        if (username.equals(checkUsernameInFile(username))) {
            //Compare password you just entered with the password in the 'user.dat' file
            if (password.equals(checkPasswordInFile(username))) {
                System.out.println("Login successfully");
            }else{
                System.err.println("Invalid username or password");
            }
        }else{
            System.err.println("Invalid username or password");
        }        
        }
    }
}