import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Author {
    private String name;
    private List<Book> books;

    public Author(String name, List<Book> books){
        this.name = name;
        this.books = new ArrayList<>();
        for(Book b : books){
            addBook(b);
        }
    }

    public Author(String name, Book... books){
        this(name, Arrays.asList(books));
    }

    public Author(String name){
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
        for (Book b : books) {
            if (b == null) throw new RuntimeException();
        }
        for (Book b : this.getBooks()) {
            removeBook(b);
        }
        for (Book b : books) {
            addBook(b);
        }
    }

    public void addBook(Book book){
        if(book != null){
            if (!this.books.contains(book)) {
                this.books.add(book);
                book.addAuthor(this);
            }
        }
        else{
            throw new RuntimeException();
        }
    }

    public void removeBook(Book book){
        if(this.books.contains(book)){
            this.books.remove(book);
            book.removeAuthor(this);
        }
    }

    @Override
    public String toString() {
        String result = name + ": ";
        for (int i = 0; i < books.size(); i++) {
            result += books.get(i).getName();
            if (i < books.size() - 1) result += ", ";
        }
        return result;
    }
}
