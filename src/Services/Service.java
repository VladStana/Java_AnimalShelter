package Services;

import Animals.*;
import DB.*;
import Employees.*;
import Files.CSVReader;
import Files.CSVWriter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Service {
    public CatService cs = new CatService();
    public DogService ds = new DogService();
    public OtherService os = new OtherService();
    public AnimalKeeperService aks = new AnimalKeeperService();
    public DoctorService docs = new DoctorService();
    public VolunteerService vs = new VolunteerService();

    Scanner scanner = new Scanner(System.in);

//    private void clearConsole() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }

    public void ReadCSV() {
        Service service = new Service();
        //Reading data from a CSV file
        CSVReader csvr = CSVReader.getInstance();
        try {
            csvr.reader(service);
        }
        catch(IOException e) {
            System.out.println("Error occurred!");
        }
    }

//    //Writing data in a CSV file
//    CSVWriter csvw = CSVWriter.getInstance();

    // Doesn't work
//    public void ConnectToDB() {
//        Service service = new Service();
//    }

    public void start() {
        System.out.println("""
                Welcome to our Animal Adoption Center!
                What would you like to see?
                1 - Animals
                2 - Employees
                """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> goToAnimals();
            case 2 -> goToEmployees();
            default -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                start();
            }
        }
    }

    private void goToAnimals() {
        System.out.println("""
                What animal are you searching for?
                1 - Dog
                2 - Cat
                3 - Other
                4 - I want to see all animals
                0 - BACK""");
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> goToDogs();
            case 2 -> goToCats();
            case 3 -> goToOthers();
            case 4 -> {
                ds.showDogs(); System.out.println("\n");
                cs.showCats(); System.out.println("\n");
                os.showOthers(); System.out.println("\n");
                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToAnimals();
            }
            case 0 -> start();
            default -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                goToAnimals();
            }
        }
    }

    private void goToDogs() {
        System.out.println("""
                What would you like to do?
                1 - Add a dog
                2 - Find a dog using ID
                3 - Delete a dog using ID
                4 - Show all dogs
                5 - Update data
                0 - BACK
                """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                Dog dog = new Dog();

                System.out.println("Name: ");
                dog.setName(scanner.next());
                System.out.println("Sex: ");
                dog.setSex(scanner.next());
                System.out.println("Age: ");
                dog.setAge(scanner.nextInt());
                System.out.println("Weight: ");
                dog.setWeight(scanner.nextFloat());
                System.out.println("Is it trained? ");
                dog.setTrained(scanner.nextBoolean());
                System.out.println("Breed:");
                dog.setBreed(scanner.next());
                System.out.println("""
                        Weight category?
                        0 - small dog
                        1 - medium dog
                        2 - big dog
                        """);
                dog.setCategory(scanner.nextInt());

                ds.addDog(dog);
                DogDB ddb = DogDB.getInstance();
                ddb.insertDog(dog);
                goToDogs();
            }
            case 2 -> {
                System.out.println("What's the dog's ID?\n");
                int id = scanner.nextInt();
                System.out.println(ds.getDogById(id) + "\n");
                goToDogs();
            }
            case 3 -> {
                System.out.println("What's the dog's ID?\n");
                int id= scanner.nextInt();

                DogDB ddb = DogDB.getInstance();
                ddb.deleteDogByName(ds.getDogById(id).getName());
                ds.deleteDogById(id);
                goToDogs();
            }
            case 4 -> {
                ds.showDogs();
                goToDogs();
            }
            case 5 -> {
                DogDB ddb = DogDB.getInstance();
                System.out.println("Dog's name?");
                String name = scanner.next();
                System.out.println("Field: ");
                String field = scanner.next();
                System.out.println("Value: ");
                String value = scanner.next();

                ddb.updateDogDB(field, value, name); //it only changes in the db
                goToDogs();
            }
            case 0 -> goToAnimals();

            default -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                goToDogs();
            }
        }
    }

    private void goToCats() {
        System.out.println("""
                What would you like to do?
                1 - Add a cat
                2 - Find a cat using ID
                3 - Delete a cat using ID
                4 - Show all cats
                5 - Update data
                0 - BACK
                """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                Cat cat = new Cat();

                System.out.println("Name: ");
                cat.setName(scanner.next());
                System.out.println("Sex: ");
                cat.setSex(scanner.next());
                System.out.println("Age: ");
                cat.setAge(scanner.nextInt());
                System.out.println("Weight: ");
                cat.setWeight(scanner.nextFloat());
                System.out.println("Is it trained? ");
                cat.setTrained(scanner.nextBoolean());
                System.out.println("Fur pattern:");
                cat.setFur_pattern(scanner.next());
                System.out.println("Fur color:");
                cat.setFur_color(scanner.next());

                cs.addCat(cat);
                CatDB cdb = CatDB.getInstance();
                cdb.insertCat(cat);

                goToCats();
            }
            case 2 -> {
                System.out.println("What's the cat's ID?\n");
                int id = scanner.nextInt();
                System.out.println(cs.getCatById(id) + "\n");
                goToCats();
            }
            case 3 -> {
                System.out.println("What's the cat's ID?\n");
                int id = scanner.nextInt();

                CatDB cdb = CatDB.getInstance();
                cdb.deleteCatByName(cs.getCatById(id).getName());
                cs.deleteCatById(id);
                goToCats();
            }
            case 4 -> {
                cs.showCats();
                goToCats();
            }
            case 5 -> {
                CatDB cdb = CatDB.getInstance();
                System.out.println("Cat's name?");
                String name = scanner.next();
                System.out.println("Field: ");
                String field = scanner.next();
                System.out.println("Value: ");
                String value = scanner.next();

                cdb.updateCatDB(field, value, name); //it only changes in the db
                goToCats();
            }
            case 0 -> goToAnimals();
            default -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                goToCats();
            }
        }
    }

    private void goToOthers() {
        System.out.println("""
                What would you like to do?
                1 - Add another animal
                2 - Find an animal using ID
                3 - Delete an animal using ID
                4 - Show all other animals
                5 - Update data
                0 - BACK
                """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                Other other = new Other();

                System.out.println("Name: ");
                other.setName(scanner.next());
                System.out.println("Sex: ");
                other.setSex(scanner.next());
                System.out.println("Age: ");
                other.setAge(scanner.nextInt());
                System.out.println("Weight: ");
                other.setWeight(scanner.nextFloat());
                System.out.println("Is it trained? ");
                other.setTrained(scanner.nextBoolean());
                System.out.println("Species: ");
                other.setSpecies(scanner.next());

                os.addOther(other);
                OtherDB odb = OtherDB.getInstance();
                odb.insertOther(other);
                goToOthers();
            }
            case 2 -> {
                System.out.println("What's the animal's ID?\n");
                int id = scanner.nextInt();
                System.out.println(os.getOtherById(id) + "\n");
                goToOthers();
            }
            case 3 -> {
                System.out.println("What's the animal's ID?\n");
                int id = scanner.nextInt();

                OtherDB odb = OtherDB.getInstance();
                odb.deleteOtherByName(os.getOtherById(id).getName());
                os.deleteOtherById(id);
                goToOthers();
            }
            case 4 -> {
                os.showOthers();
                goToOthers();
            }
            case 5 -> {
                OtherDB odb = OtherDB.getInstance();
                System.out.println("Animal's name?");
                String name = scanner.next();
                System.out.println("Field: ");
                String field = scanner.next();
                System.out.println("Value: ");
                String value = scanner.next();

                odb.updateOtherDB(field, value, name); //it only changes in the db
                goToOthers();
            }
            case 0 -> goToAnimals();
            default -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                goToOthers();
            }
        }
    }

    private void goToEmployees() {
        System.out.println("""
                What do you want to do?
                1 - Add an employee
                2 - Delete an employee by name
                3 - Find employee by name
                4 - I want to see all employees
                5 - Update data
                6 - Change salary
                7 - Wash an animal
                8 - Clean an animal's enclosure
                9 - See doctor
                0 - BACK
                """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> addEmployee();
            case 2 -> deleteEmployee();
            case 3 -> findEmployee();
            case 4 -> {
                aks.showAnimalKeepers(); System.out.println("\n");
                docs.showDoctors(); System.out.println("\n");
                vs.showVolunteers(); System.out.println("\n");
                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToEmployees();
            }
            case 5 -> updateEmployee();
            case 6 -> changeSalary();
            case 7 -> {
                System.out.println("What's the employee's ID?");
                int id_emp = scanner.nextInt();
                System.out.println("How about the animal's ID?");
                aks.wash(id_emp,scanner.nextInt());
                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToEmployees();
            }
            case 8 -> {
                System.out.println("What's the employee's ID?");
                int id_emp = scanner.nextInt();
                System.out.println("How about the animal's ID?");
                vs.clean(id_emp,scanner.nextInt());
                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToEmployees();
            }
            case 9 -> seeDoctor();
            case 0 -> start();
            default -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                goToEmployees();
            }
        }
    }

    private void addEmployee() {
        System.out.println("""
                        What's the employee's job?
                        1 - Animal Keeper
                        2 - Doctor
                        3 - Volunteer
                        0 - BACK
                        """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                AnimalKeeper ak = new AnimalKeeper();

                System.out.println("Name: ");
                ak.setName(scanner.next());
                System.out.println("Age: ");
                ak.setAge(scanner.nextInt());
                System.out.println("Assign animal: ");
                ak.setAssign_animal(scanner.next());

                aks.addAnimalKeeper(ak);
                AnimalKeeperDB akdb = AnimalKeeperDB.getInstance();
                akdb.insertAnimalKeeper(ak);

                goToEmployees();
            }
            case 2 -> {
                Doctor d = new Doctor();

                System.out.println("Name: ");
                d.setName(scanner.next());
                System.out.println("Age: ");
                d.setAge(scanner.nextInt());

                docs.addDoctor(d);
                DoctorDB docdb = DoctorDB.getInstance();
                docdb.insertDoctor(d);

                goToEmployees();
            }
            case 3 -> {
                Volunteer v = new Volunteer();

                System.out.println("Name: ");
                v.setName(scanner.next());
                System.out.println("Age: ");
                v.setAge(scanner.nextInt());

                vs.addVolunteer(v);
                VolunteerDB vdb = VolunteerDB.getInstance();
                vdb.insertVolunteer(v);
                goToEmployees();
            }
            case 4 -> goToEmployees();
            case 0 -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                addEmployee();
            }
        }
    }

    private void deleteEmployee() {
        System.out.println("""
                        What's the employee's job?
                        1 - Animal Keeper
                        2 - Doctor
                        3 - Volunteer
                        0 - BACK
                        """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                System.out.println("What's the employee's ID?");
                int id = scanner.nextInt();

                AnimalKeeperDB akdb = AnimalKeeperDB.getInstance();
                akdb.deleteAnimalKeeperByName(aks.getAnimalKeeperById(id).getName());
                aks.deleteAnimalKeeperById(id);
                goToEmployees();
            }
            case 2 -> {
                System.out.println("What's the employee's ID?");
                int id = scanner.nextInt();

                DoctorDB docdb = DoctorDB.getInstance();
                docdb.deleteDoctorByName(docs.getDoctorById(id).getName());
                docs.deleteDoctorById(id);
                goToEmployees();
            }
            case 3 -> {
                System.out.println("What's the employee's ID?");
                int id = scanner.nextInt();

                VolunteerDB vdb = VolunteerDB.getInstance();
                vdb.deleteVolunteerByName(vs.getVolunteerById(id).getName());
                vs.deleteVolunteerById(id);
                goToEmployees();
            }
            case 4 -> goToEmployees();
            case 0 -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                addEmployee();
            }
        }
    }

    private void findEmployee() {
        System.out.println("""
                        What's the employee's job?
                        1 - Animal Keeper
                        2 - Doctor
                        3 - Volunteer
                        0 - BACK
                        """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                System.out.println("What's the employee's ID?");
                System.out.println(aks.getAnimalKeeperById(scanner.nextInt()));

                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToEmployees();
            }
            case 2 -> {
                System.out.println("What's the employee's ID?");
                System.out.println(docs.getDoctorById(scanner.nextInt()));

                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToEmployees();
            }
            case 3 -> {
                System.out.println("What's the employee's ID?");
                System.out.println(vs.getVolunteerById(scanner.nextInt()));

                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToEmployees();
            }
            case 4 -> goToEmployees();
            case 0 -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                addEmployee();
            }
        }
    }

    private void updateEmployee() {
        System.out.println("""
                        What's the employee's job?
                        1 - Animal Keeper
                        2 - Doctor
                        3 - Volunteer
                        0 - BACK
                        """);
        int x = scanner.nextInt();
        switch(x) {
            case 1 -> {
                AnimalKeeperDB akdb = AnimalKeeperDB.getInstance();
                System.out.println("Animal keeper's name?");
                String name = scanner.next();
                System.out.println("Field: ");
                String field = scanner.next();
                System.out.println("Value: ");
                String value = scanner.next();

                akdb.updateAnimalKeeperDB(field, value, name); //it only changes in the db
                goToEmployees();
            }
            case 2 -> {
                DoctorDB docdb = DoctorDB.getInstance();
                System.out.println("Doctor's name?");
                String name = scanner.next();
                System.out.println("Field: ");
                String field = scanner.next();
                System.out.println("Value: ");
                String value = scanner.next();

                docdb.updateDoctorDB(field, value, name); //it only changes in the db
                goToEmployees();
            }
            case 3 -> {
                VolunteerDB vdb = VolunteerDB.getInstance();
                System.out.println("Doctor's name?");
                String name = scanner.next();
                System.out.println("Field: ");
                String field = scanner.next();
                System.out.println("Value: ");
                String value = scanner.next();

                vdb.updateVolunteerDB(field, value, name); //it only changes in the db
                goToEmployees();
            }
        }
    }

    private void changeSalary() {
        System.out.println("""
                        What's the employee's job?
                        1 - Animal Keeper
                        2 - Doctor
                        0 - BACK
                        """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> {
                System.out.println("What's the employee's ID?\n");
                int id = scanner.nextInt();
                System.out.println("""
                        Do you you want to raise or lower the salary?
                        1 - raise
                        2 - lower
                        """);
                aks.changeSalary(id, scanner.nextInt());

                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToEmployees();
            }
            case 2 -> {
                System.out.println("What's the employee's ID?\n");
                int id = scanner.nextInt();
                System.out.println("""
                        Do you you want to raise or lower the salary?
                        1 - raise
                        2 - lower
                        """);
                docs.changeSalary(id, scanner.nextInt());

                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToEmployees();
            }
            case 0 -> goToEmployees();
            default -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                changeSalary();
            }
        }
    }

    private void seeDoctor() {
        System.out.println("""
                What are you here to see the doctor for?
                1 - Diagnose animal
                2 - Today's patients
                0 - BACK
                """);
        int x = scanner.nextInt();
        switch (x) {
            case 1 -> diagnoseAnimal();
            case 2 -> {
                System.out.println("What's the doctor's ID?");
                docs.showTodayPatients(scanner.nextInt());

                System.out.println("1 - to continue.\n");
                if (scanner.next() != null)
                    goToEmployees();
            }
            case 0 -> goToEmployees();
            default -> {
                System.out.println("Error: Incorrect number. Try again!\n");
                seeDoctor();
            }
        }
    }

    private void diagnoseAnimal() {
        System.out.println("What's the animal's ID?");
        int id = scanner.nextInt();
        System.out.println("What's the doctor's ID?");
        int doc = scanner.nextInt();
        if (docs.getDoctorById(doc) != null)
            switch (id/1000) {
                case 1 -> ds.getDogById(id).diagnose(docs.getDoctorById(doc));
                case 2 -> cs.getCatById(id).diagnose(docs.getDoctorById(doc));
                case 3 -> os.getOtherById(id).diagnose(docs.getDoctorById(doc));
            }
        else
            System.out.println("Error: No doctor with this ID.");

        System.out.println("1 - to continue.\n");
        if (scanner.next() != null)
            goToEmployees();
    }

}
