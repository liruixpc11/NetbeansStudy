package lab.cadl.lirui.netbeans.study.mp3.api;

public class Mp3FileObject {
    private String author;
    private String title;
    private String year;

    public Mp3FileObject() {
    }

    public Mp3FileObject(String author, String title, String year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
