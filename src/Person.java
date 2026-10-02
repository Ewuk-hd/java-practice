public class Person {
    private String name;
    private int height;

    public Person(String name, int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Рост должен быть больше нуля: " + height);
        }
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Рост должен быть больше нуля: " + height);
        }
        this.height = height;
    }

    @Override
    public String toString() {
        return name + ", рост: " + height;
    }
}
