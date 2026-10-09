import java.util.ArrayList;
import java.util.List;

class Department {
    private String title;
    private Employee chief;
    private final List<Employee> employees;

    public Department(String title) {
        this.title = title;
        this.employees = new ArrayList<>();
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public Employee getChief() { return chief; }

    public void setChief(Employee chief) {
        if (this.chief == chief) return;
        this.chief = chief;
        this.addEmployee(chief);
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void addEmployee(Employee e) {
        if (e == null) return;
        if (employees.contains(e)) return;
        employees.add(e);
        e.setDep(this);
    }

    public void removeEmployee(Employee e) {
        if (e == null || !this.employees.contains(e)) return;
        if (e.getDep().getChief() == e) e.getDep().setChief(null);
        employees.remove(e);
        e.setDep(null);
    }
}
