package ru.komarov.study;

public class IllegalGradeException extends RuntimeException{
    private int wrongGrade;

    public IllegalGradeException(int grade) {
        this.wrongGrade = grade;
        super("grade " + grade + " is not valid for current student");
    }

    public IllegalGradeException() {
    }

    public int getWrongGrade() {
        return wrongGrade;
    }
}
