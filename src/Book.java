public class Book {
    String name;
    Author author;

    public Book(String name, Author author){
        this.name = name;
        this.author = author;
    }

    @Override
    public String toString(){
        if(author == null){
            return "Автор неизвестен";
        }
        return name + " - " + author;
    }
}
