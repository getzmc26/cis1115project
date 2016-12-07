package myproject;

import java.io.IOException;

/**
 * Test application for list.
 * @author Matt Getz
 */
public class MusicApp2 {
    public static void main(String[] args) throws IOException {
        //Create 4 entries and print them out.
        DAOMusic data = new DAOMusic();
        data.create(new Music(1, "guitar", "fender", "black", 600));
        data.create(new Music(2, "guitar", "gibson", "blue", 800));
        data.create(new Music(3, "drums", "yamaha", "green", 1200));
        data.create(new Music(4, "bass", "fender", "red", 750));
        
        System.out.printf("%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(data);
        
        //Retrieve entry at ID 3.
        System.out.println(data.retrieve(2));
        
        //m1 creates entry 1 from above, change all fields excluding ID using setters, print out.
        Music m1 = new Music(1, "guitar", "fender", "black", 600);
        m1.setInstrument("drums");
        m1.setBrand("tama");
        m1.setColor("black");
        m1.setPrice(900);
        data.update(m1);
        
        System.out.printf("%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(data);
        
        //Delete entry m1, print out.
        data.delete(3);
        
        System.out.printf("%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(data);
        
    }
}
