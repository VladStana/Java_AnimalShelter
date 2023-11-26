package Employees;

import java.util.ArrayList;

public class Doctor extends Employee implements ChangeSalary{
    int salary = 4000;
    ArrayList<Integer> patients_today = new ArrayList <>();

    public Doctor() {
        id = 1000 + count;
    }

    public Doctor(String name, int age) {
        super(name, age);
        id = 1000 + count;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ArrayList<Integer> getPatients_today() {
        return patients_today;
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

    public void showPatients(){
        System.out.println(patients_today);
    }

    public void addPatient(int id) {
        patients_today.add(id);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
