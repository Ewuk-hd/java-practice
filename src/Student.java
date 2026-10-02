public class Student {
    private String name;
    private int [] marks;

    public Student(String name, int... marks){
        if (marks != null){
            for (int i = 0; i < marks.length; i++){
                checkMark(marks[i]);
            }
        }
        this.name = name;
        this.marks = copy(marks);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int[] getMarks(){
        return copy(marks);
    }

    public void setMarks(int... marks){
        if (marks != null){
            for (int i = 0; i < marks.length; i++){
                checkMark(marks[i]);
            }
        }
        this.marks = copy(marks);
    }

    public void addMark(int mark){
        checkMark(mark);
        int [] arr = new int[marks.length + 1];
        for (int i = 0; i < marks.length; i++){
            arr[i] = marks[i];
        }
        arr[arr.length - 1] = mark;
        marks = arr;
    }

    private static int[] copy(int[] arr){
        if (arr == null){
            return new int[0];
        }
        int [] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            result[i] = arr[i];
        }
        return result;
    }

    private static void checkMark(int mark){
        if (mark < 2 || mark > 5){
            throw new IllegalArgumentException("Оценка должна быть от 2 до 5: " + mark);
        }
    }

    public double getAverage(){
        if (marks.length == 0){
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < marks.length; i++){
            sum += marks[i];
        }
        return sum / marks.length;
    }

    public boolean isExcellent(){
        if (marks.length == 0){
            return false;
        }
        for (int i = 0; i < marks.length; i++){
            if (marks[i] != 5){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
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
