/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usermanagement;

/**
 *
 * @author admin
 */

public class User extends ValidInput{
    
    public void getMenu(){
        System.out.println("====== USER MANAGEMENT SYSTEM ======");
        System.out.println("1. Create a new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
    }
    
    public int inputChoice(){
        System.out.print("> Choose: ");
        while (true) {    
            String choice = checkInput();
            //regEx: Allow enter between 1 and 3
            if (choice.matches("[1-3]")) {
                return Integer.parseInt(choice);
            }
            System.err.print("Please enter number between 1 and 3: ");
        } 
    }
}