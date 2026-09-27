public class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        if (department == null) {
            return name + " не работает ни в одном отделе";
        }

        String title = department.title != null ? department.title : "без названия";

        if (department.boss == this) {
            return name + " начальник отдела " + title;
        }

        String result = name + " работает в отделе " + title;
        if (department.boss == null) {
            return result + ", начальник которого не назначен";
        }
        return result + ", начальник которого " + department.boss.name;
    }
}
