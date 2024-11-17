/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action_service;

import application.utilities.Tool;
import data_objects.HotelDao;
import business_objects.Hotel;
import data_objects.File;
import data_objects.IFile;
import data_objects.IHotelDao;
import java.util.Scanner;

public class Service implements IService {

    IHotelDao ht = new HotelDao();
    IFile f = new File();
    public Service() {
        ht.getAllHotels();
    }

    @Override
    public void add() {
        int tmp;
        do
        {
            if (ht.addHotel() == true) {
                System.out.println("Adding successfully");
            } else {
                System.out.println("Adding unsucessfully");
            }
            System.out.println("add continue:1 // back to menu: other");
            Scanner sc = new Scanner(System.in);
            tmp = sc.nextInt();
        }while (tmp == 1);
    }
   
    @Override
    public void checkExist() {
        if (ht.existHotel(Tool.getString("Enter ID", "Invalid ID"))) {
            System.out.println("Exist hotel");
        } else {
            System.out.println("No Hotel Found");
        }
    }
    
    @Override
    public void update() {
        String i = Tool.getString("Enter ID", "Invalid ID");
        Hotel clone = ht.updateHotel(i);
        if (clone != null) {
            System.out.println(clone);
        }

    }

    @Override
    public void delete() {
        if (ht.deleteHotel(Tool.getString("Enter ID", "Invalid ID"))) {
            System.out.println("delete succesfully");
        } else {
            System.out.println("delete fail");
        }

    }

    @Override
    public void searchID() {
        String i = Tool.getString("Enter ID", "Invalid ID");
        Hotel clone = ht.searchByID(i);
        if (clone != null) {
            System.out.println(clone);
        }

    }

    @Override
    public void searchName() {
        String i = Tool.getString("Enter Name", "Invalid Name");
        Hotel clone = ht.searchByName(i);
        if (clone != null) {
            System.out.println(clone);
        } else {
            System.out.println("No exist Hotel");
        }

    }

    @Override
    public void print() {
        ht.display();
    }
}
