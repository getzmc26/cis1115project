package myproject;


/**
 *
 * @author Matt Getz
 */
public class MusicApp3 {
    public static void main(String[] args) {
        System.out.printf("%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        
        DAOMusic data = new DAOMusic();
        System.out.println(data);
        
//        data.create(new Music(1, "guitar", "fender", "black", 600));
//        System.out.println(data);
        }
}
