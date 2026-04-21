package topic15.practice;

public class Book implements forBook{
    private final String title;
    private final String author;
    private final int pages;

    public Book(String title, String author, int pages){
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String getTitle () {
        return title;
    }

    public String getAuthor () {
        return author;
    }

    public int getPages () {
        return pages;
    }

    @Override
    public String toString () {
        return "Book{title='%s', author='%s', pages=%d}".formatted(title, author, pages);
    }

    private void reading(String title){
        System.out.println("reading" +title);
    }

    @Override
    public void buy() {
        System.out.println("buy a book");
    }
}
