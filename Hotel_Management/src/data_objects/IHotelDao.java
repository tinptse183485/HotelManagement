/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_objects;

import business_objects.Hotel;


/**
 *
 * @author ASUS
 */
public interface IHotelDao {
    public void getAllHotels();
    public Hotel updateHotel (String id);
    public boolean deleteHotel (String id);
    public boolean addHotel ();
    public boolean existHotel(String id);
    public Hotel searchByID (String id);
    public Hotel searchByName (String name);
    public void display();
    
}
