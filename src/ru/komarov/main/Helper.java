package ru.komarov.main;

public class Helper<T> {
    private T res;



    private Helper(T res) {
        this.res = res;
    }

    public static <P> Helper<P> of(P res){
        return new Helper<>(res);
    }

    public static <P> Helper<P> empty(){
        return new Helper<>(null);
    }

    public T getRes() {
        return res;
    }
}
