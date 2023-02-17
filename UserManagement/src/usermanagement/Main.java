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
        //Step 1: Use a loop for the user to enter choice
        do {
        //Step 2: Create menu 
        user.getMenu();          
        //Step 3: Get user choice    
        int choice = user.inputChoice();  
        //Step 4: Do the option in menu
        switch(choice){
            case 1: //Create a new account  
                manage.createNewAccount();
                break;
            case 2: //Let user log into Login System by find it in file 'user.dat' 
                manage.loginSystem();
                break; 
            case 3: //Exit program
                System.exit(0);
        }            
        } while (true);
    }    
}