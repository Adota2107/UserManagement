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
        do {
        //Step 1: Create menu 
        user.menu();          
        //Step 2: User choice     
        int choice = user.input();    
        switch(choice){
            case 1: //Create a new account  
                manage.createNewAccount();
                break;
            case 2: //Let user log into Login System by find it in file 'user.dat' 
                manage.loginSystem();
                break; 
            case 3: //Exit
                user.exit();
                return;
        }            
        } while (true);
    }    
}