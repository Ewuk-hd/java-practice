public class Employee {
    private String name;
    private final Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        if (department != null) {
            department.addEmployee(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        if (department == null) {
            return name + " не работает ни в одном отделе";
        }

        String title = department.getTitle() != null ? department.getTitle() : "без названия";

        if (department.getBoss() == this) {
            return name + " начальник отдела " + title;
        }

        String result = name + " работает в отделе " + title;
        if (department.getBoss() == null) {
            return result + ", начальник которого не назначен";
        }
        return result + ", начальник которого " + department.getBoss().getName();
    }
}
