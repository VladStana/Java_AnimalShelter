package Animals;

import Employees.Doctor;

public abstract class Animal implements Training{
    int id;
    static int count = 0;
    String name;
    String sex; // f/m
    int age;
    float weight;
    Boolean trained;

    {
        count++;
    }

    public Animal(){}

    public Animal(String name, String sex, int age, float weight, Boolean trained) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        //for Cats / Dogs -> kilograms
        //for the other animals -> grams
        this.trained = trained;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Boolean getTrained() {
        return trained;
    }

    public void setTrained(Boolean trained) {
        this.trained = trained;
    }

    public void train(){
        if(!trained)
            trained = true;
        else
            System.out.println("The animal has been trained previously.\n");
    }

    protected abstract void ageCategory();
    protected abstract void diagnose(Doctor doc);
}
