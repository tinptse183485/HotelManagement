/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_objects;

import business_objects.Hotel;
import java.util.ArrayList;


/**
 *
 * @author ASUS
 */
public interface IFile {
    public void WriteListObject (ArrayList<Hotel> hotelList);
    public void WriteObject (Hotel ht);
    public ArrayList<Hotel> ReadObject ();
        
}
