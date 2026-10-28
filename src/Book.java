import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class Book {
    private String name;
    private List<Author> authors;

    public Book(String name, List<Author> authors){
        this.name = name;
        this.authors = new ArrayList<>();
        for(Author a : authors){
            addAuthor(a);
        }
    }

    public Book(String name){
        this(name, new ArrayList<>());
    }

    public Book(String name, Author... authors){
        this(name, Arrays.asList(authors));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return new ArrayList<>(authors);
    }

    public void setAuthors(List<Author> authors) {
        for (Author a : authors) {
            if (a == null) throw new RuntimeException();
        }
        for (Author a : this.getAuthors()) {
            removeAuthor(a);
        }
        for (Author a : authors) {
            addAuthor(a);
        }
    }

    public void addAuthor(Author author){
        if(author != null){
            if(!this.authors.contains(author)){
                this.authors.add(author);
                author.addBook(this); //Если книге добавили автора, то и автору добавляем книгу
            }
        }
        else{
            throw new RuntimeException();
        }
    }

    public void removeAuthor(Author author){
        if(this.authors.contains(author)){
            this.authors.remove(author);
            author.removeBook(this);
        }
    }

    @Override
    public String toString() {
        String result = name + " (";
        for (int i = 0; i < authors.size(); i++) {
            result += authors.get(i).getName();
            if (i < authors.size() - 1) result += ", ";
        }
        return result + ")";
    }
}
