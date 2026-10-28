package ru.komarov.work;

import java.util.Objects;

public class Employee {
    private String name;
    private Department dep;

    public Employee(String name, Department department) {
        this.name = name;
        this.dep = department;
        if (department != null) department.employees.add(this);
    }

    public Employee(String name) { this.name = name; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Department getDep() { return dep; }

    public void setDep(Department dep) {
        if (this.dep == dep) return;
        if (this.dep != null) {
            if (this.dep.chief == this) this.dep.chief = null;
            for (int i = 0; i < this.dep.employees.size(); i++) {
                if (this.dep.employees.get(i) == this) {
                    this.dep.employees.remove(i);
                    break;
                }
            }
        }
        this.dep = dep;
        if (dep == null) return;
        this.dep.employees.add(this);
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && dep == employee.dep;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, dep);
    }

    @Override
    public String toString() {
        if (dep == null) {
            return name + " без отдела";
        }
        return name + " работает в " + dep.getTitle();
    }
}
