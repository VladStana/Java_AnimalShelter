package Animals;

import Employees.Doctor;

public class Dog extends Animal implements Adoptable{
    String breed;
    int category;
    // 0 - small dog
    // 1 - medium dog
    // 2 - big dog
    static int count_dog = 0;

    {
        count_dog++;
    }

    public Dog(){
        id = 1000 + count_dog;
    }

    public Dog(String name, String sex, int age, float weight,
               Boolean trained, String breed, int category) {
        super(name, sex, age, weight, trained);
        this.breed = breed;
        this.category = category;

        id = 1000 + count_dog;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public static int getCount_dog() {
        return count_dog;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", trained=" + trained +
                ", breed='" + breed + '\'' +
                '}';
    }

    public void adoptMe(){
        if(trained)
            System.out.println("I am "+name+", a trained "+age+" year(s) old "+breed+
                    " and I'm looking for my forever home.");
        else
            System.out.println("I am "+name+", a "+age+" year(s) old "+breed+
                    " and I'm looking for my forever home.");
    }

    @Override
    public void ageCategory(){
        if(age == 0)
            System.out.println(name+" is a junior.\n");
        else if(age<15)
            System.out.println(name+" is an adult.\n");
        else
            System.out.println(name+" is a senios.\n");
    }

    @Override
    public void diagnose(Doctor doc) {
        doc.addPatient(id);
        System.out.println("\nDoctor "+doc.getName()+" has examined the dog.");
        if (age == 0) {
            if (2 < weight && weight < 8)
                System.out.println("The puppy is healthy.");
            else if (weight > 8)
                System.out.println("The puppy is obese.");
            else
                System.out.println("The puppy is malnourished.");
        }
        else {
            if (category == 0) {
                if (5 < weight && weight < 10)
                    System.out.println("The dog is healthy weight.");
                else
                    System.out.println("The dog is an unhealthy weight.");
            }
            else if (category == 1) {
                if (18 < weight && weight < 30)
                    System.out.println("The dog is healthy weight.");
                else
                    System.out.println("The dog is an unhealthy weight.");
            }
            else {
                if (40 < weight && weight < 50)
                    System.out.println("The dog is healthy weight.");
                else
                    System.out.println("The dog is an unhealthy weight.");
            }
        }

    }
}
