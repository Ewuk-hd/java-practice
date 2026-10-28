import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Publication {
    private String author;
    private String text;
    private List<Comment> comments;

    public Publication(String author, String text, List<Comment> comments){
        this.author = author;
        this.text = text;
        this.comments = new ArrayList<>();
        for (Comment c : comments){
            addComment(c);
        }
    }

    public Publication(String author, String text, Comment... comments){
        this(author, text, Arrays.asList(comments));
    }

    public Publication(Publication pub){
        this(pub.getAuthor(), pub.getText(), pub.getComments());
    }

    public Publication(String author, String text){
        this(author, text, new ArrayList<>());
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
            throw new FilledCommentsException();
        }
    }

    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public void addComment(Comment comment){
        if(comment != null){
            this.comments.add(comment);
        }
        else {
            throw new RuntimeException();
        }
    }

    public void setComments(List<Comment> comments) {
        List<Comment> copyarr = new ArrayList<>(this.comments);
        try{
            this.comments = new ArrayList<>();
            for(Comment newComm : comments){
                this.addComment(newComm);
            }
        }catch (RuntimeException e){
            this.comments = copyarr;
            throw e;
        }
    }

    @Override
    public String toString(){
        if(this.comments.isEmpty()){
            return "Публикация: " + author + ": " + text;
        }
        return "Публикация: " + author + ": " + text + "\n" + comments;
    }
}
