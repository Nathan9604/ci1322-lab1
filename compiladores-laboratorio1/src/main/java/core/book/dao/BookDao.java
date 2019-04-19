package core.book.dao;

import model.book;

import java.sql.SQLException;

public interface BookDao{

    /*
        Busca el libro con el identificador deseado.
        @param id nos indica el libro que deseamos buscar.
        @return book el cual tiene los datos del libro deseado.
     */
    book findById(String id) throws SQLException;

    /*
        Inserta un nuevo libro en la base de datos.
        @param entity contiene los datos del libro que se desea insertar.
        @return answer nos indica si el libro se logro almacenar correctamente.
     */
    String create(book entity);

    /*
        Actualiza los datos de un libro dado.
        @param entity tiene los datos del libro que se desea actualizar.
     */
    void update(book entity);

    /*
        Elimina un libro de la base de datos.
        @param entity provee los datos del libro que se desea eliminar.
     */
    void remove(book entity);
}
