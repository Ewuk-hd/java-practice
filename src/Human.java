public class Human {
    private FullName name;
    private int height;
    private final Human father;

    public Human(FullName name, int height){
        this(name, height, null);
    }

    public Human(FullName name, int height, Human father) {
        if (height < 0){
            throw new IllegalArgumentException("Рост не может быть отрицательным: " + height);
        }
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

    public FullName getName(){ //1.6.7
        return name;
    }

    public void setName(FullName name){
        this.name = name;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        if (height < 0){
            throw new IllegalArgumentException("Рост не может быть отрицательным: " + height);
        }
        this.height = height;
    }

    public Human getFather(){
        return father;
    }

    public String getFirstName(){
        if (name == null){
            return null;
        }
        return name.getFirstName();
    }

    public String getPatronymic(){
        if (name != null && name.getPatronymic() != null){
            return name.getPatronymic();
        }
        if (father != null && father.getFirstName() != null){
            return father.getFirstName() + "ович";
        }
        return null;
    }

    public String getLastName(){
        if (name != null && name.getLastName() != null){
            return name.getLastName();
        }
        if (father == null){
            return null;
        }
        return father.getLastName();
    }

    @Override
    public String toString() {
        return new FullName(getLastName(), getFirstName(), getPatronymic()).toString();
    }
}
