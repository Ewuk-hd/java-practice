import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name, List<Book> books){
        this.name = name;
        this.books = new ArrayList<>();
        for(Book b : books){
            addBook(b);
        }
    }

    public Library(String name, Book... books){
        this(name, Arrays.asList(books));
    }

    public Library(String name){
        this(name, new ArrayList<>());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public void setBooks(List<Book> books) {
        List<Book> copy = new ArrayList<>(this.books);
        try{
            this.books = new ArrayList<>();
            for (Book b : books){
                this.addBook(b);
            }

        } catch (RuntimeException e){
            this.books = copy;
            throw e;
        }
    }

    public void addBook(Book book){
        if(book != null){
            if(!this.books.contains(book)){
            this.books.add(book);
            }
        }
        else{
            throw new RuntimeException();
        }
    }

    public void removeBook(Book b){
            this.books.remove(b);
    }

    @Override
    public String toString() {
        return name + " " + books;
    }
}
