package Files;

import Animals.*;
import Services.Service;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class CSVReader { //IT WORKS!!

    private static CSVReader csvr = null;

    private CSVReader() {}

    public static CSVReader getInstance() {
        if(csvr == null)
            csvr = new CSVReader();
        return csvr;
    }

    private void cats(Service service) throws IOException {
        File fileCats = new File("src/csv/cats");
        Scanner scanner = new Scanner(fileCats);

        while(scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String[] arg = nextLine.split(",");
            service.cs.addCat(new Cat(arg[0], arg[1],
                    Integer.parseInt(arg[2]),
                    Float.parseFloat(arg[3]),
                    Boolean.parseBoolean(arg[4]),
                    arg[5], arg[6]));
        }
    }

    private void dogs(Service service) throws IOException {
        File fileDogs = new File("src/csv/dogs");
        Scanner scanner = new Scanner(fileDogs);

        while(scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String[] arg = nextLine.split(",");
            service.ds.addDog(new Dog(arg[0], arg[1],
                    Integer.parseInt(arg[2]),
                    Float.parseFloat(arg[3]),
                    Boolean.parseBoolean(arg[4]),
                    arg[5],
                    Integer.parseInt(arg[6])));
        }
    }

    private void others(Service service) throws IOException {
        File fileOthers = new File("src/csv/others");
        Scanner scanner = new Scanner(fileOthers);

        while(scanner.hasNext()) {
            String nextLine = scanner.nextLine();
            String[] arg = nextLine.split(",");
            service.os.addOther(new Other(arg[0], arg[1],
                    Integer.parseInt(arg[2]),
                    Float.parseFloat(arg[3]),
                    Boolean.parseBoolean(arg[4]),
                    arg[5]));
        }
    }

    public void reader(Service s) throws IOException {
        cats(s);
        dogs(s);
        others(s);
    }
}
