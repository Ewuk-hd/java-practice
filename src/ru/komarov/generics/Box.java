package ru.komarov.generics;

public class Box<T> {
    private T ob;

    public T getOb() {
        T tmp = ob;
        ob = null;
        return tmp;
    }

    public void setOb(T ob) {
        if(this.ob != null) throw new RuntimeException();
        this.ob = ob;
    }

    public boolean isFull(){
        return ob != null;
    }
}
