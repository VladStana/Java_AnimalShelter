package Files;

import Animals.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter {

    private static CSVWriter csvw = null;

    static File file = null;
    static FileWriter filew = null;
    static BufferedWriter buffw = null;

    private CSVWriter() {}

    public static CSVWriter getInstance() {
        if(csvw == null)
            csvw = new CSVWriter();
        return csvw;
    }

    void openFile(String path) {
        file = new File(path);
        try {
            filew = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        buffw = new BufferedWriter(filew);
    }

    public void cat(Cat cat) {
        try {
            openFile("src/csv/cats");
            if(file.length() != 0)
                buffw.newLine();
            buffw.write(cat.getName() +
                    "," + cat.getSex() +
                    "," + cat.getAge() +
                    "," + cat.getWeight() +
                    "," + cat.getTrained() +
                    "," + cat.getFur_pattern() +
                    "," + cat.getFur_color());
            buffw.close();
        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }

    public void dog(Dog dog) {
        try {
            openFile("src/csv/dogs");
            if(file.length() != 0)
                buffw.newLine();
            buffw.write(dog.getName() +
                    "," + dog.getSex() +
                    "," + dog.getAge() +
                    "," + dog.getWeight() +
                    "," + dog.getTrained() +
                    "," + dog.getBreed() +
                    "," + dog.getCategory());
            buffw.close();
        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }

    public void other(Other other) {
        try {
            openFile("src/csv/others");
            if(file.length() != 0)
                buffw.newLine();
            buffw.write(other.getName() +
                    "," + other.getSex() +
                    "," + other.getAge() +
                    "," + other.getWeight() +
                    "," + other.getTrained() +
                    "," + other.getSpecies());
            buffw.close();
        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }
}
