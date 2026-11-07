package ru.komarov.study;

public class IllegalGradeException extends RuntimeException{

    public IllegalGradeException() {
    }

    public IllegalGradeException(String message) {
        super(message);
    }
}
