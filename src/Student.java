import java.util.ArrayList;

public class Student {
    private String name;
    private ArrayList<Integer> marks;

    public Student(String name, int... marks){
        this.name = name;
        this.marks = toList(marks);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ArrayList<Integer> getMarks(){
        return new ArrayList<>(marks);
    }

    public void setMarks(int... marks){
        this.marks = toList(marks);
    }

    public void addMark(int mark){
        checkMark(mark);
        marks.add(mark);
    }

    private static ArrayList<Integer> toList(int... marks){
        ArrayList<Integer> result = new ArrayList<>();
        if (marks != null){
            for (int i = 0; i < marks.length; i++){
                checkMark(marks[i]);
                result.add(marks[i]);
            }
        }
        return result;
    }

    private static void checkMark(int mark){
        if (mark < 2 || mark > 5){
            throw new IllegalArgumentException("Оценка должна быть от 2 до 5: " + mark);
        }
    }

    public double getAverage(){
        if (marks.isEmpty()){
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < marks.size(); i++){
            sum += marks.get(i);
        }
        return sum / marks.size();
    }

    public boolean isExcellent(){
        if (marks.isEmpty()){
            return false;
        }
        for (int i = 0; i < marks.size(); i++){
            if (marks.get(i) != 5){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return name + ": " + marks;
    }
}
