package ru.komarov.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String title;
    Employee chief;
    final List<Employee> employees;

    public Department(String title) {
        this.title = title;
        this.employees = new ArrayList<>();
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Employee getChief() { return chief; }

    public void setChief(Employee chief) {
        if (chief != null) chief.setDep(this);
        this.chief = chief;
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void addEmployee(Employee e) {
        if (e != null) e.setDep(this);
    }

    public void removeEmployee(Employee e) {
        if (e != null && e.getDep() == this) e.setDep(null);
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Department d = (Department) o;
        return Objects.equals(title, d.title);
    }

    @Override
    public int hashCode(){
        return  Objects.hashCode(title);
    }
}
