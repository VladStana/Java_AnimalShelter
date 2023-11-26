package Animals;

import Employees.*;

public class Cat extends Animal implements Adoptable{
    String fur_pattern;
    String fur_color;
    static int count_cat = 0;

    {
        count_cat++;
    }

    public Cat(){
        id= 2000 + count_cat;
    }

    public Cat(String name, String sex, int age, float weight,
               Boolean trained, String fur_pattern, String fur_color) {
        super(name, sex, age, weight, trained);
        this.fur_pattern = fur_pattern;
        this.fur_color = fur_color;

        id= 2000 + count_cat;
    }

    public String getFur_pattern() {
        return fur_pattern;
    }

    public void setFur_pattern(String fur_pattern) {
        this.fur_pattern = fur_pattern;
    }

    public String getFur_color() {
        return fur_color;
    }

    public void setFur_color(String fur_color) {
        this.fur_color = fur_color;
    }

    public static int getCount_cat() {
        return count_cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", trained=" + trained +
                ", fur_pattern='" + fur_pattern + '\'' +
                ", fur_color='" + fur_color + '\'' +
                '}';
    }

    public void adoptMe(){
        if(trained)
            System.out.println("I am "+name+", a trained "+age+" year(s) old "+ fur_color+" "+
                    fur_pattern+" cat and I'm looking for my forever home.");
        else
            System.out.println("I am "+name+", a "+age+" year(s) old "+ fur_color+" "+
                    fur_pattern+" cat and I'm looking for my forever home.");
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
        System.out.println("\nDoctor "+doc.getName()+" has examined the cat.");
        if (age == 0) {
            if (2 < (weight * 10) && (weight * 10) < 8) // between 200-800 grams
                System.out.println("The kitten is healthy.");
            else if ((weight * 10) > 8)
                System.out.println("The kitten is obese.");
            else
                System.out.println("The kitten is malnourished.");
        }
        else {
            if (sex.equals("f")) {
                if (3.5 > weight && weight < 5.5)
                    System.out.println("The cat is healthy weight.");
                else
                    System.out.println("The cat is an unhealthy weight.");
            }
            else {
                if (5 > weight && weight < 7.5)
                    System.out.println("The cat is healthy weight.");
                else
                    System.out.println("The cat is an unhealthy weight.");
            }
        }
    }
}
