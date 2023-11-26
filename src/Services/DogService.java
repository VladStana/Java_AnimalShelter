package Services;

import Animals.Dog;

import java.util.ArrayList;
import java.util.Arrays;

public class DogService {
    static ArrayList<Dog> dogs;

    public DogService() {
        dogs = new ArrayList<>();
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void showDogs() {
        System.out.println(Arrays.deepToString(dogs.toArray()).replace("},", "},\n"));
    }

    public void deleteDogById(int id) {
        dogs.removeIf(dogInArray -> dogInArray.getId() == id);
    }

    public Dog getDogById(int id){
        for (Dog dogInArray : dogs) {
            if(dogInArray.getId() == id){
                return dogInArray;
            }
        }
        return null;
    }
}

