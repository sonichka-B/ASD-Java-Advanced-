package topic9.practice;

public class Library {
    private final String name;

    public Library(String name){
        this.name=name;
    }

    public class Book{
         String title;
         String author;

        public Book(String title,String author){
            this.title = title;
            this.author = author;
        }

        public String bookLabel(){
            return "Book:" +title+", Author:"+author+", Library:"+name;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                '}';
    }
}
