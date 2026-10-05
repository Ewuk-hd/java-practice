public class Employee {
    private String name;
    private Department department;

    public Employee(String name){
        this(name, null);
    }

    public Employee(String name, Department department){
        if (name == null) throw new IllegalStateException();
        this.name = name;
        this.department = department;
    }

    public void getInfo(){
        if (department != null){
            if (department.getDepartmentHead()!=null && name.equals(department.getDepartmentHead())){
                System.out.printf("%s начальник отдела %s\n", name, department.getDepartmentName());
            }
            else {
                System.out.printf("%s работает в отделе %s, начальник которого %s\n", name,
                        department.getDepartmentName(),
                        department.getDepartmentHead());
            }
        }
    }

    public Department getDepartment(){
        return department;
    }

    public void setDepartment(Department department){
        if (this.department == department) return;
        Department old = this.department;
        this.department = department;
        if (old != null) {
            old.removeEmployee(this);
            if (old.getDepartmentHead() == this){
                old.setDepartmentHead(null);
            }
        }
        if (department != null) {
            department.addEmployee(this);
        }
    }

    public void setName(String name){
        if (name == null) this.name = "unknown";
        this.name = name;
    }

    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        String dep = "";
        String boss = "";
        if (department == null){
            return name + " без отдела";
        }
        if (this == department.getDepartmentHead()){
            return name + " начальник отдела " + department.getDepartmentName();
        }
        return name + " работает в " + department;
    }
}