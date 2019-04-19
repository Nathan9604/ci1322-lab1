package model;

public class book {
    private String id;
    private String name;
    private String author;
    private String genre;
    private int edition;

    /*
        Constructor de un objeto book. Crea el objeto y lo llena de sus datos correspondientes.
     */
    public book(String id, String name, String author, String genre, int edition) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.edition = edition;
    }

    /*
        Permite establecer el id del libro.
        @param id que se desea establecer.
     */
    public void setId(String id) {
        this.id = id;
    }

    /*
        Permite establecer el nombre del libro.
        @param nombre que se desea establecer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
        Permite establecer el autor del libro.
        @param autor que se desea establecer.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /*
        Permite establecer el género del libro.
        @param género que se desea establecer.
     */
    public void setGenre(String genres) {
        this.genre = genre;
    }

    /*
        Permite establecer la edición del libro.
        @param edición que se desea establecer.
     */
    public void setEdition(int edition) {
        this.edition = edition;
    }

    /*
        Permite conocer el id del libro.
        @return id del objeto book.
     */
    public String getId() {
        return this.id;
    }

    /*
        Permite conocer el nombre del libro.
        @return nombre del objeto book.
     */
    public String getName() {
        return this.name;
    }

    /*
        Permite conocer el autor del libro.
        @return autor del objeto book.
     */
    public String getAuthor() {
        return this.author;
    }

    /*
        Permite conocer el género del libro.
        @return género del objeto book.
     */
    public String getGenre(){
        return this.genre;
    }

    /*
        Permite conocer la edición del libro.
        @return edición del objeto book.
     */
    public int getEdition(){
        return this.edition;
    }
}
