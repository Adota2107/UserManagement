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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user = new User();
        Manage manage = new Manage(); 
        //Step 1: Create menu 
        user.menu();
        //Step 2: User choice and check 
        String choice = user.input();
        switch(choice){
            case "1": //Step 3: Create a new account and add it into file named 'user.dat'  
                manage.createNewAccount();
                break;
            case "2": //Step 4: Let user log into Login System by find it in file 'user.dat' 
                manage.loginSystem();
                break; 
            case "3":
                System.out.println("Goodbye");
                break;
        }     
    }    
}
