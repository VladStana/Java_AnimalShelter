package Services;

import Animals.Cat;

import java.util.ArrayList;
import java.util.Arrays;

public class CatService {
    ArrayList<Cat> cats;

    public CatService() {
        cats = new ArrayList<>();
    }

    public void addCat(Cat cat) {
        cats.add(cat);
    }

    public void showCats() {
        System.out.println(Arrays.deepToString(cats.toArray()).replace("},", "},\n"));
    }

    public void deleteCatById(int id) {
        cats.removeIf(catInArray -> catInArray.getId() == id);
    }

    public Cat getCatById(int id){
        for (Cat catInArray : cats) {
            if(catInArray.getId() == id){
                return catInArray;
            }
        }
        return null;
    }
}
