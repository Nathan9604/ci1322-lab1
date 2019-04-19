package model;

public class read {
    private String student_id;
    private String book_id;

    /*
        Constructor de un objeto read.
     */
    public read(String student_id, String book_id){
        this.student_id = student_id;
        this.book_id = book_id;
    }

    /*
        Estable el identificador del estudiante en la relación.
        @param identificador del estudiante.
     */
    public void setStudentId(String student_id){
        this.student_id = student_id;
    }

    /*
        Estable el identificador del libro en la relación.
        @param identificador del libro.
     */
    public void setBookId(String book_id){
        this.book_id = book_id;
    }

    /*
        Permite conocer el identificador del estudiante en la relación.
        @return identifiador del estudiante.
     */
    public String getStudentId(){
        return this.student_id;
    }

    /*
        Permite conocer el identificador del libro en la relación.
        @return identifiador del libro.
     */
    public String getBookId(){
        return this.book_id;
    }
}
