package data_objects;

import business_objects.Hotel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public class File implements IFile {

    String filepath = "file.txt";

    public File() {
    }

    public File(String fileIn) {
        this.filepath = fileIn;
    }

    @Override
    public void WriteListObject(ArrayList<Hotel> hotelList) {
        try {
            FileWriter fw = new FileWriter(filepath);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Hotel i : hotelList) {
                bw.write(i.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (Exception e) {

        }
    }

    @Override
    public void WriteObject(Hotel ht) {
        try {
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(ht.toString());
            bw.newLine();
            bw.close();
            fw.close();

        } catch (Exception e) {

        }

    }

    @Override
    public ArrayList<Hotel> ReadObject() {
        ArrayList<Hotel> ht = new ArrayList<>();
        try {
            FileReader fr = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(";");
                String id = txt[0];
                String name = txt[1];
                int ra = Integer.parseInt(txt[2]);
                String address = txt[3];
                String phone = txt[4];
                int rate = Integer.parseInt(txt[5]);
                Hotel h = new Hotel(id, name, ra, address, phone, rate);
                ht.add(h);
            }
        } catch (Exception ex) {
        
        }

        return ht;
    }


}
