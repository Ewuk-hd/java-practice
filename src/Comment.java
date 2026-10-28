import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comment {
    private String author;
    private String text;
    private List<Comment> comments;

    public Comment(String author, String text, List<Comment> comments){
        this.author = author;
        this.text = text;
        this.comments = new ArrayList<>();
        for (Comment c : comments){
            addComment(c);
        }
    }

    public Comment(String author, String text){
        this(author, text, new ArrayList<>());
    }

    public Comment(String author, String text, Comment... comments){
        this(author, text, Arrays.asList(comments));
    }

    public Comment(Comment com){
        this(com.getAuthor(), com.getText(), com.getComments());
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        if(this.comments.isEmpty()){
        this.text = text;
        }
        else {
            throw new RuntimeException();
        }
    }

    public List<Comment> getComments() {
        return new ArrayList<>(this.comments);
    }

//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }

    public void addComment(Comment comment){
        if(comment != null){
           this.comments.add(comment);
        }
        else {
            throw new RuntimeException();
        }
    }

    @Override
    public String toString(){
        if(this.comments.isEmpty()){
            return "Комментирует: " + author + ": " + text;
        }
        return "Комментирует: " + author + ": " + text + "\n" + comments;
    }
}
