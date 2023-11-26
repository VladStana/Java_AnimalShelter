package Services;

import Employees.AnimalKeeper;
import Employees.Doctor;
import Employees.Employee;
import Employees.Volunteer;

import java.util.ArrayList;
import java.util.Arrays;

public class AnimalKeeperService {
    ArrayList<AnimalKeeper> animalKeepers;

    public AnimalKeeperService() {
        animalKeepers = new ArrayList<>();
    }

    public void addAnimalKeeper(AnimalKeeper animalKeeper) {
        animalKeepers.add(animalKeeper);
    }


    public void showAnimalKeepers() {
        System.out.println(Arrays.deepToString(animalKeepers.toArray()).replace("},", "},\n"));
    }

    public void deleteAnimalKeeperById(int id) {
        animalKeepers.removeIf(animalKeeperInArray -> animalKeeperInArray.getId() == id);
    }

    public AnimalKeeper getAnimalKeeperById(int id) {
        for (AnimalKeeper animalKeeperInArray : animalKeepers) {
            if (animalKeeperInArray.getId() == id) {
                return animalKeeperInArray;
            }
        }
        return null;
    }

    public void wash(int id_emp, int id_anim) {
        if (getAnimalKeeperById(id_emp) != null)
            getAnimalKeeperById(id_emp).clean(id_anim);
        else
            System.out.println("Error: No animal keeper with this ID.\n");
    }

    public void changeSalary(int id, int option) {
        if (getAnimalKeeperById(id) != null)
            switch (option) {
                case 1 -> getAnimalKeeperById(id).RaiseSalary();
                case 2 -> getAnimalKeeperById(id).LowerSalary();
            }
        else
            System.out.println("Error: No animal keeper with this ID.\n");
    }

}
