public class Employee {
    String name;
    Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;

        if (department != null) {
            if (department.employees == null) {
                department.employees = new Employee[]{this};
            } else {
                Employee [] arr = new Employee[department.employees.length + 1];
                for (int i = 0; i < department.employees.length; i++) {
                    arr[i] = department.employees[i];
                }
                arr[arr.length - 1] = this;
                department.employees = arr;
            }
        }
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
