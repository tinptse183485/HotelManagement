/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_objects;

import application.utilities.Tool;
import static application.utilities.Tool.sc;
import business_objects.Hotel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class HotelDao extends ArrayList<Hotel> implements IHotelDao {

    ArrayList<Hotel> hotelList = new ArrayList<>();
    IFile f = new File();

    public HotelDao() {

    }

    @Override
    public void getAllHotels() {
        this.hotelList = f.ReadObject();
        Collections.sort(this.hotelList, new Comparator<Hotel>() {
            @Override
            public int compare(Hotel o1, Hotel o2) {

                return o2.getName().compareToIgnoreCase(o1.getName());
            }
        });
    }

    @Override
    public Hotel updateHotel(String id) {
        Hotel hotel = new Hotel();
        if (this.existHotel(id) == true) {
            for (Hotel i : hotelList) {
                if (i.getId().equals(id)) {
                    // tạo hotel clone để update thông tin 
                    hotel.setName(Tool.getStringk("Enter Name: "));
                    // kiểm tra name là duy nhất
                    for (Hotel f : hotelList) {
                        if (f.getName().equals(hotel.getName())) {
                            hotel.setName(Tool.getStringk("Already exist name ! Enter Name again "));
                        }
                    }
                    // nhập room được bỏ trống 
                    System.out.println("Enter Room Available");
                    String s = sc.nextLine();
                    if (!s.isEmpty()) {
                        while (Integer.valueOf(s) < 0) {
                            s = Tool.getString("Invalid Room Available, Enter again !", "Invalid Room Available, Enter again !");
                        }
                        int room = Integer.valueOf(s);
                        hotel.setRoomAvailable(room);
                    }

                    hotel.setPhone(Tool.getStringk("Enter phone number", "Invalid number", hotel.REGPHONE));
                    hotel.setAddress(Tool.getStringk("Enter address"));

                    // nhập rating dc bỏ trống 
                    System.out.println("Enter Rating");
                    String f = sc.nextLine();
                    if (!f.isEmpty()) {
                        while (Integer.valueOf(f) < 1 || Integer.valueOf(f) > 5) {
                            s = Tool.getString("Invalid Rating, Enter again !", "Invalid Rating, Enter again !");
                        }
                        int rate = Integer.valueOf(f);
                        hotel.setRating(rate);
                    }

                    // so sánh với i nếu dữ liệu trống thì giữ nguyên information ko thì đổi i
                    if (!hotel.getName().equals("")) {
                        i.setName(hotel.getName());
                    }
                    if (!hotel.getAddress().equals("")) {
                        i.setAddress(hotel.getAddress());
                    }
                    if (!hotel.getPhone().equals("")) {
                        i.setPhone(hotel.getPhone());
                    }
                    if (hotel.getRoomAvailable() != 0) {
                        i.setRoomAvailable(hotel.getRoomAvailable());
                    }
                    if (hotel.getRating() != 0) {
                        i.setRating(hotel.getRating());
                    }
                    return i;

                }
            }
        } else {
            System.out.println("No exist hotel");

        }
        return null;
    }

    @Override
    public boolean deleteHotel(String id) {
        Scanner sc = new Scanner(System.in);

        if (this.existHotel(id)) {
            System.out.println("Do you really want to delete this hotel ? \n yes:1 // no:0");
            if (sc.nextInt() == 1) {
                for (Hotel i : hotelList) {
                    if (i.getId().equals(id)) {
                        hotelList.remove(i);
                        f.WriteListObject(hotelList);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    @Override
    public boolean addHotel() {
        Hotel hotel = new Hotel();
        boolean flag = false;
        hotel.setId(Tool.getString("Enter Hotel_id ", "Invalid ID, Enter in form: h(number) ", hotel.REGID));
        getAllHotels();
        if (hotelList != null) /// kiểm tra id là duy nhất 
        {
            for (Hotel i : hotelList) {
                if (i.getId().equals(hotel.getId())) {
                    hotel.setId(Tool.getString("ID already existed, Enter again ", "Invalid ID"));
                }
            }
        }
        hotel.setName(Tool.getString("Enter Name: ", "Invalid Name"));
        if (hotelList != null) // kiểm tra name là duy nhất
        {
            for (Hotel i : hotelList) {
                if (i.getName().equals(hotel.getName())) {
                    hotel.setName(Tool.getString("Name already existed, Enter again ", "Invalid Name"));
                }
            }
        }

        hotel.setRoomAvailable(Tool.getAnInteger("Enter Room available", "Invalid room available", 0));
        hotel.setPhone(Tool.getString("Enter phone number", "Invalid number", hotel.REGPHONE));
        hotel.setAddress(Tool.getString("Enter address", "Invalid Address"));
        hotel.setRating(Tool.getAnInteger("Enter rating", "Invalid Rating", 0, 5));
        hotelList.add(hotel);
        for (int i = 0; i < hotelList.size(); i++) {
            if (hotelList.get(i) == hotel) {
                flag = true;
                try {
                    f.WriteObject(hotelList.get(i));

                } catch (Exception e) {
                    System.out.println("1");
                }

            }
        }

        return flag;

    }

    @Override
    public boolean existHotel(String id) {
        hotelList = f.ReadObject();
        Hotel hotel = new Hotel();
        for (Hotel i : hotelList) {
            if (i.getId().equals(id)) {
                return true;
            }
        }
        return false;

    }

    @Override
    public Hotel searchByID(String id) {
        if (!this.existHotel(id)) {
            System.out.println("Hotel does not exist");
        } else {
            for (Hotel i : hotelList) {
                if (i.getId().equalsIgnoreCase(id)) {
                    return i;
                }
            }
        }
        return null;
    }

    @Override
    public Hotel searchByName(String name) {
        for (Hotel i : hotelList) {
            if (i.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        System.out.println("No exist hotel ");
        return null;
    }

    @Override
    public void display() {
        if (!hotelList.isEmpty()) {
            for (Hotel i : hotelList) {
                System.out.println(i);
            }
        } else {
            System.out.println("Empty Hotel List");
        }
    }
}
