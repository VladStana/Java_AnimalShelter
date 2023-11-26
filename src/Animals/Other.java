package Animals;

import Employees.Doctor;

public class Other extends Animal implements Adoptable {
    String species; // parrot, ferret, hamster
    static int count_other = 0;

    {
        count_other++;
    }

    public Other() {
        id = 3000 + count_other;
    }

    public Other(String name, String sex, int age, float weight,
                 Boolean trained, String species) {
        super(name, sex, age, weight, trained);
        this.species = species;

        id = 3000 + count_other;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public static int getCount_other() {
        return count_other;
    }

    @Override
    public String toString() {
        return "Other{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", trained=" + trained +
                ", species='" + species + '\'' +
                '}';
    }

    public void adoptMe() {
        if (trained)
            System.out.println("I am " + name + ", a trained " + age + " year(s) old " + species +
                    " and I'm looking for my forever home.");
        else
            System.out.println("I am " + name + ", a " + age + " year(s) old " + species +
                    " and I'm looking for my forever home.");
    }

    @Override
    public void ageCategory() {
        if (species.equals("parrot")) {
            if (age == 0)
                System.out.println(name + " is a junior.\n");
            else if (age < 6)
                System.out.println(name + " is an adult.\n");
            else
                System.out.println(name + " is a senios.\n");
        }
        else if (species.equals("ferret")) {
            if (age == 0)
                System.out.println(name + " is a junior.\n");
            else if (age < 6)
                System.out.println(name + " is an adult.\n");
            else
                System.out.println(name + " is a senios.\n");
        }
        else if (species.equals("hamster")) {
            if (age == 0)
                System.out.println(name + " is a junior.\n");
            else
                System.out.println(name + " is an adult.\n");
        }
    }

    @Override
    public void diagnose(Doctor doc) {
        doc.addPatient(id);
        System.out.println("\nDoctor " + doc.getName() + " has examined the ");
        if (species.equals("parrot")) {
            if (30 < weight && weight < 60)
                System.out.println("parrot.\nThe parrot is a healthy weight.");
            else
                System.out.println("parrot.\nThe parrot is an unhealthy weight.");
        }
        else if (species.equals("ferret")) {
            if ( 700 < weight && weight < 2000) // between 0.7-2 kg
                System.out.println("ferret.\n The ferret is healthy weight.");
            else
                System.out.println("ferret.\n The ferret is an unhealthy weight.");
        }
        else if (species.equals("hamster")) {
            if (90 < weight && weight < 150)
                System.out.println("hamster.\n The hamster is healthy weight.");
            else
                System.out.println("hamster.\n The hamster is an unhealthy weight.");
        }
    }
}


