public class Student {
    String name;
    int [] marks;

    public Student(String name, int [] marks){
        this.name = name;
        this.marks = marks;
    }
    @Override
    public String toString() {
        if (marks == null) {
            return name + ": []";
        }

        String result = name + ": [";
        for (int i = 0; i < marks.length; i++){
            if(i > 0){
                result += ", ";
            }
            result += marks[i];
        }
        return result + "]";
    }
}

