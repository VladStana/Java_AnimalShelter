package Services;

import Employees.Doctor;

import java.util.ArrayList;
import java.util.Arrays;

public class DoctorService {
    ArrayList<Doctor> docs;

    public DoctorService() {
        docs = new ArrayList<>();
    }

    public void addDoctor(Doctor doc) {
        docs.add(doc);
    }


    public void showDoctors() {
        System.out.println(Arrays.deepToString(docs.toArray()).replace("},", "},\n"));
    }

    public void deleteDoctorById(int id) {
        docs.removeIf(docInArray -> docInArray.getId() == id);
    }

    public Doctor getDoctorById(int id){
        for (Doctor docInArray : docs) {
            if(docInArray.getId() == id){
                return docInArray;
            }
        }
        return null;
    }

    public void showTodayPatients(int id) {
        getDoctorById(id).showPatients();
    }


    public void changeSalary(int id, int option) {
        if(getDoctorById(id) != null)
            switch (option) {
                case 1 -> getDoctorById(id).RaiseSalary();
                case 2 -> getDoctorById(id).LowerSalary();
            }
        else
            System.out.println("Error: No doctor with this ID.\n");
    }
}
