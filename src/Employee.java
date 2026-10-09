class Employee {
    private String name;
    private Department dep;

    public Employee(String name) { this.name = name; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Department getDep() { return dep; }

    public void setDep(Department dep) {
        if (this.dep == dep) return;
        if (this.dep != null) {
            this.dep.removeEmployee(this);
        }
        this.dep = dep;
        if (dep == null) return;
        this.dep.addEmployee(this);
    }

    @Override
    public String toString() {
        if (dep == null) {
            return name + " без отдела";
        }
        return name + " работает в " + dep.getTitle();
    }
}
