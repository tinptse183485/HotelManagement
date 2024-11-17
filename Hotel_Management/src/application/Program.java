/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import action_service.IService;
import action_service.Service;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class Program {
    public static void main(String[] args)  {
        IService sv = new Service();
        int choice;
        do {
            System.out.println(String.join("", Collections.nCopies(10, "**********")));
            Menu.print("1. Adding new Hotel|2. Checking exist Hotel|3. Updating Hotel information|4. Deleting Hotel|5. Searching Hotel|6. Displaying a hotel list(descending by Hotel_Name)|7. Quit ");    
            choice = Menu.getUserChoice(1,7); // hàm menu riêng 
            switch (choice) {
                case 1:
                    sv.add();// ghi nd hàm 
                    break;
                case 2:
                    sv.checkExist();
                    break;
                case 3:
                    sv.update();
                    break;
                case 4:
                    sv.delete();
                    break;
                case 5:
                    Menu.print("1. Searching by ID|2.Searching by Name ");
                    if (Menu.getUserChoice(1,2)==1) {
                        sv.searchID();
                    } else {
                        sv.searchName();
                    }
                    break;
                case 6:
                    sv.print();
                    break;
            }
        } while (choice != 7);

    }

}
