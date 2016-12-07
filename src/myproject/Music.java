package myproject;

/**
 * Music Store
 * @author Matt Getz
 * 
 */
public class Music {
    private int id;
    private String instrument;
    private String brand;
    private String color;
    private double price;
    
    public Music() {
        
    }

    public Music(int id, String instrument, String brand, String color, double price) {
        this.id = id;
        this.instrument = instrument;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        //return "Music{" + "id=" + id + ", instrument=" + instrument + ", brand=" 
        //        + brand + ", color=" + color + ", price=" + price + '}';
        
        return String.format ("%5d %15s %15s %15s %15.2f %n", id, instrument, brand, color, price);
    }
}


