public class Human {
    FullName name;
    int height;
    Human father;

    public Human(FullName name, int height){
        this(name, height, null);
    }

    public Human(FullName name, int height, Human father) {
        this.name = name;
        this.height = height;
        this.father = father;
    }

    public Human(String name){
        this(new FullName(name));
    }

    public Human(FullName name){
        this(name, null);
    }

    public Human(String name, Human father){
        this(new FullName(name), father);
    }

    public Human(FullName name, Human father){
        this(name, 0, father);
    }

    @Override
    public String toString() {
        String lastName = null;
        String firstName = null;
        String patronymic = null;

        if (name != null) {
            lastName = name.lastName;
            firstName = name.firstName;
            patronymic = name.patronymic;
        }

        // Фамилия берётся у отца, если своей нет
        if (lastName == null && father != null && father.name != null) {
            lastName = father.name.lastName;
        }

        // Отчество строится из имени отца, если своего нет
        if (patronymic == null && father != null && father.name != null
                && father.name.firstName != null) {
            patronymic = father.name.firstName + "ович";
        }

        // Собираем новый объект, не меняя поля текущего человека
        return new FullName(lastName, firstName, patronymic).toString();
    }
}
