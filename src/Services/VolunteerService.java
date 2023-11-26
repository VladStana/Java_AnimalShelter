package Services;

import Employees.Volunteer;

import java.util.ArrayList;
import java.util.Arrays;

public class VolunteerService {
    ArrayList<Volunteer> vols;

    public VolunteerService() {
        vols = new ArrayList<>();
    }

    public void addVolunteer(Volunteer vol) {
        vols.add(vol);
    }


    public void showVolunteers() {
        System.out.println(Arrays.deepToString(vols.toArray()).replace("},", "},\n"));
    }

    public void deleteVolunteerById(int id) {
        vols.removeIf(volInArray -> volInArray.getId() == id);
    }

    public Volunteer getVolunteerById(int id){
        for (Volunteer volInArray : vols) {
            if(volInArray.getId() == id){
                return volInArray;
            }
        }
        return null;
    }

    public void clean(int id_emp, int id_anim){
        if(getVolunteerById(id_emp) != null)
            getVolunteerById(id_emp).clean(id_anim);
        else
            System.out.println("Error: No volunteer with this ID.");
    }
}
