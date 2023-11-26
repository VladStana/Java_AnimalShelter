package Employees;

import Animals.*;

public class AnimalKeeper extends Employee implements ChangeSalary,Work{
    int salary = 2500;
    String assign_animal; //the specific species that they take care of

    public AnimalKeeper() {
        id = 1000 + count;
    }

    public AnimalKeeper(String name, int age, String assign_animal) {
        super(name, age);
        this.assign_animal = assign_animal;
        id = 1000 + count;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getAssign_animal() {
        return assign_animal;
    }

    public void setAssign_animal(String assign_animal) {
        this.assign_animal = assign_animal;
    }

    public void RaiseSalary(){
        System.out.println(name+ "'s current salary is: "+salary+". How much is the raise? (percentage)\n");
        float s = scanner.nextInt();
        salary = Math.round(salary + salary * (s/100));
        System.out.println("The new salary is: "+salary+".\n");
    }

    public void LowerSalary(){
        System.out.println(name+"'s current salary is "+salary+". How much is the pay cut? (percentage)\n");
        float s = scanner.nextInt();
        salary = Math.round(salary + salary * (s/100));
        System.out.println("The new salary is: "+salary+".\n");
    }

    public void clean(int id) {
        int x = id / 1000;
        int y = id % 1000;


        if (y!=0 && x == 1 && y <= Dog.getCount_dog())
            System.out.println("The dog with the ID " + id + " is clean.\n");
        else if (y!=0 && x == 2 && y<= Cat.getCount_cat())
            System.out.println("The cat with the ID " + id + " is clean.\n");
        else if (y!=0 && x == 3 && y<= Other.getCount_other())
            System.out.println("The animal with the ID " + id + " is clean.\n");
        else
            System.out.println("No animal has this ID.");
    }

    public void buy(Item x) {
        System.out.println("The worker will buy "+x.getQuantity()+" x "
                +x.getName()+" and the price is "+x.getQuantity()*x.getPrice()+".\n");
    }

    @Override
    public String toString() {
        return "AnimalKeeper{" +
                "salary=" + salary +
                ", assign_animal='" + assign_animal + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
