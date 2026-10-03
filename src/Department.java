public class Department {
    private String title;
    private Employee boss;
    private Employee [] employees = new Employee[0];

    public Department(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getBoss() {
        return boss;
    }

    public void setBoss(Employee boss) {
        if (boss == null || boss.getDepartment() == this) {
            this.boss = boss;
        }
    }

    public Employee[] getEmployees() {
        Employee [] copy = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            copy[i] = employees[i];
        }
        return copy;
    }

    public void addEmployee(Employee employee) {
        if (employee == null || employee.getDepartment() != this) {
            return;
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == employee) {
                return;
            }
        }
        Employee [] arr = new Employee[employees.length + 1];
        for (int i = 0; i < employees.length; i++) {
            arr[i] = employees[i];
        }
        arr[arr.length - 1] = employee;
        employees = arr;
    }
}
