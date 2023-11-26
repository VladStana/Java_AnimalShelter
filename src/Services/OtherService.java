package Services;

import Animals.Other;
import java.util.ArrayList;
import java.util.Arrays;

public class OtherService {
    static ArrayList<Other> others;

    public OtherService() {
        others = new ArrayList<>();
    }

    public void addOther(Other other) {
        others.add(other);
    }

    public void showOthers() {
        System.out.println(Arrays.deepToString(others.toArray()).replace("},", "},\n"));
    }

    public void deleteOtherById(int id) {
        others.removeIf(otherInArray -> otherInArray.getId() == id);
    }

    public Other getOtherById(int id){
        for (Other otherInArray : others) {
            if(otherInArray.getId() == id){
                return otherInArray;
            }
        }
        return null;
    }
}
