import java.util.ArrayList;

public class Department {
    private String departmentName;
    private Employee departmentHead;
    private ArrayList<Employee> employees;

    public Department(){
        employees = new ArrayList<>();
    }
п
    public Department(String departmentName){
        employees = new ArrayList<>();
        this.departmentName = departmentName;
        this.departmentHead = null;
    }

    public Department(String departmentName, Employee departmentHead){
        employees = new ArrayList<>();
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
    }

    public String getDepartmentName(){
        return departmentName;
    }

    public Employee getDepartmentHead(){
        return departmentHead;
    }

    public ArrayList<Employee> getEmployees(){
        return new ArrayList<>(employees);
    }

    public void setDepartmentHead(Employee name){
        this.departmentHead = name;
    }


    public void removeEmployee(Employee employee){
        employees.remove(employee);
    }

    public void addEmployee(Employee employee) {
        if (employee == null || employees.contains(employee)) return;
        employees.add(employee);
        if (employee.getDepartment() != this) {
            employee.setDepartment(this);
        }
    }

    @Override
    public String toString(){
        if (departmentHead == null) {
            return departmentName + " без начальника";
        }

        return "Отдел " + departmentName + " начальник: " + departmentHead.getName();
    }

}