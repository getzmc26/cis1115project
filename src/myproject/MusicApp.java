package myproject;

/**
 * Music Test Application
 * @author Matt Getz
 */
public class MusicApp {
    public static void main(String[] args) {
        System.out.printf("%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        
        Music m1 = new Music(1, "guitar", "fender", "black", 600);
        System.out.println(m1);
        Music m2 = new Music(2, "guitar", "gibson", "blue", 800);
        System.out.println(m2);
        Music m3 = new Music(3, "drums", "yamaha", "green", 1200);
        System.out.println(m3);
        Music m4 = new Music(4, "bass", "fender", "sunburst", 750);
        System.out.println(m4);
        
    }
}
