package myproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Data Access Object to the "music store."
 *
 * @author Matt Getz
 */
public class DAOMusic {

    private final String fileName = "musicdata.txt";
    List<Music> myList;

    public DAOMusic() {
        myList = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            System.out.println("");
        } catch (IOException ex) {
            Logger.getLogger(DAOMusic.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public void create(Music instrument) {
        myList.add(instrument);
        writeList();
    }

    public Music retrieve(int id) {
        System.out.printf("%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");

        for (Music instrument : myList) {
            if (instrument.getId() == id) {
                return instrument;
            }
        }
        return null;
    }

    public void update(Music instrument) {
        for (Music inst : myList) {
            if (inst.getId() == instrument.getId()) {
                inst.setInstrument(instrument.getInstrument());
                inst.setBrand(instrument.getBrand());
                inst.setColor(instrument.getColor());
                inst.setPrice(instrument.getPrice());
                break;
            }
        }
    }

    public void delete(int id) {
        for (Music instrument : myList) {
            if (instrument.getId() == id) {
                myList.remove(instrument);
                writeList();
                break;
            }
        }
    }

    public String statistics() {
        DecimalFormat df = new DecimalFormat("#.00");

        //Loop for lowest price and highest price.
        double lowest = Integer.MAX_VALUE;
        double highest = Integer.MIN_VALUE;
        for (Music instrument : myList) {
            if (instrument.getPrice() < lowest) {
                lowest = instrument.getPrice();
            }
            if (instrument.getPrice() > highest) {
                highest = instrument.getPrice();
            }
        }
        String lowestFormatted = df.format(lowest);
        String highestFormatted = df.format(highest);
        
        //Loop for sum, average, variance, and standard deviation.
        double sum1 = 0;
        double sum2 = 0;
        double sumSquares = 0;
        int n = 0;
        int j = 0;

        for (Music instrument : myList) {
            sum1 += instrument.getPrice();
            sum2 += instrument.getPrice();
            sumSquares += instrument.getPrice() * instrument.getPrice();
            j++;
            n++;
        }
        double average = sum1 / n;
        double variance = (sumSquares - ((double) sum2 * sum2 / j)) / (j - 1);
        double standardDeviation = Math.sqrt(variance);

        String sumFormatted = df.format(sum1);
        String averageFormatted = df.format(average);
        String varianceFormatted = df.format(variance);
        String standardDeviationFormatted = df.format(standardDeviation);

        //Return String formatted.
        String format = String.format("\nThe lowest price of current inventory is: %14s"
                + "\n"
                + "\nThe highest price of current inventory is: %13s"
                + "\n"
                + "\nThe total value of current inventory is: %15s "
                + "\n"
                + "\nThe average price of current inventory is: %13s"
                + "\n"
                + "\nThe variance of the prices is: %25s"
                + "\n"
                + "\nThe standard deviation of the prices is: %15s", 
                "$" + lowestFormatted, "$" + highestFormatted, "$" + sumFormatted, 
                "$" + averageFormatted, varianceFormatted, standardDeviationFormatted);
        return format;
    }

    public String orderByIDDescend() {
        myList.sort(Comparator.comparing(Music::getId).reversed());
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        return this.toString();
    }

    public String orderByInstrumentAscend() {
        myList.sort(Comparator.comparing(Music::getInstrument));
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        return this.toString();
    }

    public String orderByInstrumentDescend() {
        myList.sort(Comparator.comparing(Music::getInstrument).reversed());
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        return this.toString();
    }

    public String orderByBrandAscend() {
        myList.sort(Comparator.comparing(Music::getBrand));
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        return this.toString();
    }

    public String orderByBrandDescend() {
        myList.sort(Comparator.comparing(Music::getBrand).reversed());
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        return this.toString();
    }

    public String orderByPriceAscend() {
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        myList.sort(Comparator.comparing(Music::getPrice));
        return this.toString();
    }

    public String orderByPriceDescend() {
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        myList.sort(Comparator.comparing(Music::getPrice).reversed());
        return this.toString();
    }

    public String orderByInstrumentAscendPriceAscend() {
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        myList.sort(Comparator.comparing(Music::getInstrument).thenComparing(Music::getPrice));
        return this.toString();
    }

    public String orderByInstrumentAscendPriceDescend() {
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        myList.sort(Comparator.comparing(Music::getInstrument).reversed().thenComparing(Music::getPrice).reversed());
        return this.toString();
    }

    public String orderByInstrumentDescendPriceDescend() {
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        myList.sort(Comparator.comparing(Music::getInstrument).thenComparing(Music::getPrice).reversed());
        return this.toString();
    }

    public String orderByInstrumentDescendPriceAscend() {
        System.out.printf("\n%5s %15s %15s %15s %15s %n", "ID", "Instrument", "Brand", "Color", "Price ($)");
        System.out.println("------------------------------------------------------------------------");
        myList.sort(Comparator.comparing(Music::getInstrument).reversed().thenComparing(Music::getPrice));
        return this.toString();
    }

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String instrument = data[1];
                String brand = data[2];
                String color = data[3];
                double price = Double.parseDouble(data[4]);
                Music myinstrument = new Music(id, instrument, brand, color, price);
                myList.add(myinstrument);
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOMusic.class.getName()).log(Level.SEVERE, null, ex);
        }
        myList.sort(Comparator.comparing(Music::getId));
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Music instrument : myList) {
                writer.write(String.format("%d,%s,%s,%s,%.2f\n",
                        instrument.getId(),
                        instrument.getInstrument(),
                        instrument.getBrand(),
                        instrument.getColor(),
                        instrument.getPrice()));
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOMusic.class.getName()).log(Level.SEVERE, null, ex);
        }
        myList.sort(Comparator.comparing(Music::getId));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Music instrument : myList) {
            sb.append(instrument).append("\n");
        }
        myList.sort(Comparator.comparing(Music::getId));
        return sb.toString();
    }
}
